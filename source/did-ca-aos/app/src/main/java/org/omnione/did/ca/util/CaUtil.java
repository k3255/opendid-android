/*
 * Copyright 2024 OmniOne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omnione.did.ca.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import androidx.core.content.ContextCompat;

import org.omnione.did.ca.config.Config;
import org.omnione.did.ca.config.Constants;
import org.omnione.did.ca.config.Preference;
import org.omnione.did.ca.logger.CaLog;
import org.omnione.did.ca.network.HttpUrlConnection;
import org.omnione.did.ca.push.UpdatePushTokenVo;
import org.omnione.did.ca.ui.common.ErrorDialog;
import org.omnione.did.sdk.datamodel.common.enums.WalletTokenPurpose;
import org.omnione.did.sdk.datamodel.security.ReqEcdh;
import org.omnione.did.sdk.utility.CryptoUtils;
import org.omnione.did.sdk.utility.Encodings.Base16;
import org.omnione.did.sdk.utility.Errors.UtilityException;
import org.omnione.did.sdk.wallet.WalletApi;
import org.omnione.did.sdk.core.exception.WalletCoreException;
import org.omnione.did.sdk.wallet.walletservice.exception.WalletException;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CountDownLatch;

public class CaUtil {
    public static Bitmap drawableFromImgStr(Context context) {
        byte[] bytes=Base64.decode(Preference.loadPicture(context),Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }

    public static String drawableToBase64(Context context, int resId){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteStream);
        byte[] byteArray = byteStream.toByteArray();
        String baseString = "data:image/png;base64," + Base64.encodeToString(byteArray,Base64.DEFAULT);
        return baseString;
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static String convertDate(String targetDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(targetDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String strDateTime = format.format(date);
        return  strDateTime;
    }

    public static String createMessageId(Context context) {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
        String messageId = "";
        try {
            messageId = dateFormat.format(today) + Base16.toHex(CryptoUtils.generateNonce(4));
        } catch (UtilityException e) {
            CaLog.e("createMessageId error : " + e.getMessage());
            ContextCompat.getMainExecutor(context).execute(()  -> {
                CaUtil.showErrorDialog(context, e.getMessage());
            });
        }
        return messageId;
    }
    public static String createCaAppId() throws UtilityException{
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String messageId = "AID" + dateFormat.format(today) + "a" + Base16.toHex(CryptoUtils.generateNonce(5));
        return messageId;
    }
    public static boolean isLock(Context context) {
        final boolean[] resultHolder = new boolean[1];
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WalletApi walletApi = WalletApi.getInstance(context);
                    boolean isLock = walletApi.isLock();
                    CaLog.d("wallet lock type : " + isLock);
                    resultHolder[0] = isLock;
                } catch (WalletCoreException e) {
                    CaLog.e("personalize error : " + e.getMessage());
                    ContextCompat.getMainExecutor(context).execute(()  -> {
                        CaUtil.showErrorDialog(context, e.getMessage());
                    });
                } finally {
                    latch.countDown();
                }
            }
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            ContextCompat.getMainExecutor(context).execute(()  -> {
                CaUtil.showErrorDialog(context, e.getMessage());
            });
        }
        return resultHolder[0];

    }
    public static boolean personalize(String hWalletToken, Context context, WalletTokenPurpose.WALLET_TOKEN_PURPOSE purpose) throws WalletCoreException {
        WalletApi walletApi = WalletApi.getInstance(context);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CaLog.d("user bind: " + walletApi.bindUser(hWalletToken));
                } catch (WalletException e) {
                    CaLog.e("personalize error : " + e.getMessage());
                    ContextCompat.getMainExecutor(context).execute(()  -> {
                        CaUtil.showErrorDialog(context, e.getMessage());
                    });
                }
            }
        }).start();
        return true;
    }
    public static void showErrorDialog(Context context, String message){
        ErrorDialog errorDialog = new ErrorDialog(context);
        errorDialog.setMessage(message);
        errorDialog.setDialogListener(new ErrorDialog.ErrorDialogInterface() {
            @Override
            public void okBtnClicked(String btnName) {
            }
        });
        errorDialog.show();
    }

    public static void showErrorDialog(Context context, String message, Activity activity){
        ErrorDialog errorDialog = new ErrorDialog(context);
        errorDialog.setMessage(message);
        errorDialog.setDialogListener(new ErrorDialog.ErrorDialogInterface() {
            @Override
            public void okBtnClicked(String btnName) {
                activity.finish();
            }
        });
        errorDialog.show();
    }

    public static CompletableFuture<String> getVcSchema(Context context, String schemaId){
        HttpUrlConnection httpUrlConnection = new HttpUrlConnection();

        return CompletableFuture.supplyAsync(() -> httpUrlConnection.send(context, schemaId, "GET", ""))
                .thenCompose(CompletableFuture::completedFuture)
                .exceptionally(ex -> {
                    throw new CompletionException(ex);
                });
    }

    public static CompletableFuture<String> updatePushToken(Context context){
        String api = "/tas/api/v1/update-push-token";

        UpdatePushTokenVo updatePushTokenVo = new UpdatePushTokenVo();
        updatePushTokenVo.setId(CaUtil.createMessageId(context));
        updatePushTokenVo.setDid(Preference.getDID(context));
        updatePushTokenVo.setAppId(Preference.getCaAppId(context));
        CaLog.d("push token : " + Preference.getPushToken(context));
        updatePushTokenVo.setPushToken(Preference.getPushToken(context));
        String updatePushToken = updatePushTokenVo.toJson();
        CaLog.d("Update push token : " + updatePushToken);
        HttpUrlConnection httpUrlConnection = new HttpUrlConnection();

        return CompletableFuture.supplyAsync(() -> httpUrlConnection.send(context, Config.TAS_URL + api, "POST", updatePushToken))
                .thenCompose(CompletableFuture::completedFuture)
                .exceptionally(ex -> {
                    throw new CompletionException(ex);
                });
    }
}
