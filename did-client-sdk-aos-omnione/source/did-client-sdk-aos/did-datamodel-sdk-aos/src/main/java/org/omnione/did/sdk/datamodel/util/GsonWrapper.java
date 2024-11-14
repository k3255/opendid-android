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

package org.omnione.did.sdk.datamodel.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonWrapper {
	public static GsonWrapper getGson() {
		return new GsonWrapper();
	}

	public static GsonWrapper getGsonPrettyPrinting() {
		return new GsonWrapper(true);
	}

	private Gson gson;

	public GsonWrapper() {
		super();
		gson = new GsonBuilder().disableHtmlEscaping().create();
	}

	public GsonWrapper(boolean prettyPrinting) {
		super();
		GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
		if (prettyPrinting) {
			builder.setPrettyPrinting();
		}
		gson = builder.create();
	}

	public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
		return gson.fromJson(json, classOfT);
	}

	public String toJson(Object src) {
		return gson.toJson(src);
	}

}
