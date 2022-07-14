package com.mdgroup.telegrambotapi;

import android.util.Log;
import java.io.File;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

class TelegramClient {

    private static Request getRequest(String botToken, String url) {
        String telegramApiUrl = "https://api.telegram.org/bot" + botToken + url;
        Log.v("response.body()", telegramApiUrl + "");
        return new Request.Builder()
                .url(telegramApiUrl)
                .build();
    }

    static Call getOkHttpClientCall(String botToken, String url, Callback callback) {
        Call call = null;
        call = new OkHttpClient().newCall(getRequest(botToken, url));
        assert call != null;
        call.enqueue(callback);
        return call;
    }

    static Call postOkHttpClientCall(String botToken, String url, String chat_id, String mediaKey,
                                     String mediaType, File file, String caption, Callback callback) {
        Call call = new OkHttpClient().newCall(postRequest(botToken, url, chat_id, mediaKey, mediaType, file, caption));
        call.enqueue(callback);
        return call;
    }

    private static Request postRequest(String botToken, String url, String chat_id, String mediaKey,
                                       String mediaType, File file, String caption) {
        String telegramApiUrl = "https://api.telegram.org/bot" + botToken + url;
        return new Request.Builder()
                .url(telegramApiUrl)
                .post(mediaRequestBody(chat_id, mediaKey, mediaType, file, caption))
                .build();
    }

    private static RequestBody mediaRequestBody(String chat_id, String mediaKey, String mediaType, File file, String caption) {
        return new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("chat_id", chat_id)
                .addFormDataPart("caption", caption)
                .addFormDataPart(mediaKey, file.getName(), RequestBody.create(MediaType.parse(mediaType), file)).build();
    }
}