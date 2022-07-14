package com.mdgroup.telegrambotapi.utils;

import okhttp3.Call;

public interface TelegramCallback<T> {

    void onResponse(Call call, T response);

    void onFailure(Call call, Exception e);
}