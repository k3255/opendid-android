/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.bioprompthelper;

import android.content.Context;

import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.concurrent.Executor;

public class BioPromptHelper {
    private Context context;
    public BioPromptHelper(){}
    public BioPromptHelper(Context context){
        this.context = context;
    }
    public void setBioPromptListener(BioPromptInterface bioPromptInterface){
        this.bioPromptInterface = bioPromptInterface;
    }
    public interface BioPromptInterface {
        void onSuccess(String result);
        void onFail(String result);
    }
    private BioPromptInterface bioPromptInterface;

    /**
     * register a fingerprint for signing key
     * @param ctx
     */
    public void registerBioKey(Context ctx, String Message) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            Executor executor = ContextCompat.getMainExecutor(ctx);
            BiometricPrompt biometricPrompt = new BiometricPrompt((androidx.fragment.app.FragmentActivity) ctx, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    bioPromptInterface.onFail("onAuthenticationError");
                }

                @Override
                public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    bioPromptInterface.onSuccess("onAuthenticationSucceeded");
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    bioPromptInterface.onFail("onAuthenticationFailed");
                }
            });

            BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Biometric Authentication")
                    .setSubtitle("Authenticate to access your private key")
                    .setNegativeButtonText("Cancel")
                    .build();

            biometricPrompt.authenticate(promptInfo);
        }
    }

    /**
     * authenticates a fingerprint for signing key
     * @param fragment
     * @param ctx
     */
    public void authenticateBioKey(Fragment fragment, Context ctx, String Message) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            Executor executor = ContextCompat.getMainExecutor(ctx);
            BiometricPrompt biometricPrompt = new BiometricPrompt(fragment, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    bioPromptInterface.onFail("onAuthenticationError");
                }

                @Override
                public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    // 지문인증후 bio 서명키 생성
                    bioPromptInterface.onSuccess("onAuthenticationSucceeded");
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    bioPromptInterface.onFail("onAuthenticationFailed");
                    // 인증 실패 처리
                }
            });

            BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Biometric Authentication")
                    .setSubtitle("Authenticate to access your private key")
                    .setNegativeButtonText("Cancel")
                    .build();


            biometricPrompt.authenticate(promptInfo);
        }
    }


}
