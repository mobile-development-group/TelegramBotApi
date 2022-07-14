package com.mdgroup.telegrambotapi;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.mdgroup.telegrambotapi.models.GetMe;
import com.mdgroup.telegrambotapi.models.Message;
import com.mdgroup.telegrambotapi.utils.TelegramCallback;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@SuppressWarnings({"ConstantConditions", "JavaDoc", "unchecked"})
public class Telegram {

    public enum ParseMode {Markdown, HTML}

    private String botToken;

    public Telegram(String botToken) {
        this.botToken = botToken;
    }

    /**
     * Get Methods
     */
    public void getMe(final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/getMe";
        TelegramClient.getOkHttpClientCall(botToken,
                sendMessageFunction,
                new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call, @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    telegramCallback.onResponse(call, new Gson().fromJson(response.body().string(), GetMe.class));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendMessage(String chatId, String message, final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendmessage?chat_id=" + chatId + "&text=" + message;
        TelegramClient.getOkHttpClientCall(botToken,
                sendMessageFunction, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call,
                                           @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    telegramCallback.onResponse(call, new Gson().fromJson(response.body().string(), Message.class));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendMessage(String chatId, String message,
                            ParseMode parseMode, final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendmessage?chat_id=" + chatId + "&text=" + message + "&parse_mode=" + parseMode;
        TelegramClient.getOkHttpClientCall(botToken,
                sendMessageFunction, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call,
                                           @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            telegramCallback.onResponse(call,
                                                    new Gson().fromJson(response.body().string(), Message.class));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call,
                                          @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendLocation(String chatId, String latitude, String longitude,
                             final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendLocation?chat_id=" + chatId + "&latitude=" + latitude + "&longitude=" + longitude;
        TelegramClient.getOkHttpClientCall(botToken,
                sendMessageFunction, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call, @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            telegramCallback.onResponse(call,
                                                    new Gson().fromJson(response.body().string(), Message.class));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendVenue(String chatId, String latitude, String longitude,
                          String title, String address,
                          final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendVenue?chat_id=" + chatId
                + "&latitude=" + latitude + "&longitude=" + longitude
                + "&title=" + title + "&address=" + address;
        TelegramClient.getOkHttpClientCall(botToken,
                sendMessageFunction, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call, @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            telegramCallback.onResponse(call,
                                                    new Gson().fromJson(response.body().string(), Message.class));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    /**
     * Post Methods
     */

    public void sendPhoto(String chat_id, String mediaType, File file, String caption,
                          final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendPhoto";
        TelegramClient.postOkHttpClientCall(botToken,
                sendMessageFunction, chat_id, "photo",
                mediaType, file, caption, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call,
                                           @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    telegramCallback.onResponse(call,
                                            new Gson().fromJson(response.body().string(), Message.class));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendAudio(String chat_id, String mediaType, File file, String caption,
                          final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendAudio";
        TelegramClient.postOkHttpClientCall(botToken,
                sendMessageFunction, chat_id, "audio",
                mediaType, file, caption, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call,
                                           @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    telegramCallback.onResponse(call,
                                            new Gson().fromJson(response.body().string(), Message.class));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendVoice(String chat_id, String mediaType, File file, String caption,
                          final TelegramCallback telegramCallback) throws Exception {
        if (file.getName().contains(".ogg")) {
            String sendMessageFunction = "/sendVoice";
            TelegramClient.postOkHttpClientCall(botToken,
                    sendMessageFunction, chat_id, "voice",
                    mediaType, file, caption, new Callback() {
                        @Override
                        public void onResponse(@NonNull final Call call,
                                               @NonNull final Response response) throws IOException {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        telegramCallback.onResponse(call,
                                                new Gson().fromJson(response.body().string(), Message.class));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }

                        @Override
                        public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    telegramCallback.onFailure(call, e);
                                }
                            });
                        }
                    });
        } else {
            throw new Exception("Your voice should be in .ogg format");
        }
    }

    public void sendVideo(String chat_id, String mediaType, File file, String caption,
                          final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendVideo";
        TelegramClient.postOkHttpClientCall(botToken,
                sendMessageFunction, chat_id, "video",
                mediaType, file, caption, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call, @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            telegramCallback.onResponse(call,
                                                    new Gson().fromJson(response.body().string(), Message.class));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }

    public void sendDocument(String chat_id, String mediaType, File file, String caption,
                             final TelegramCallback telegramCallback) {
        String sendMessageFunction = "/sendDocument";
        TelegramClient.postOkHttpClientCall(botToken,
                sendMessageFunction, chat_id, "document",
                mediaType, file, caption, new Callback() {
                    @Override
                    public void onResponse(@NonNull final Call call, @NonNull final Response response) throws IOException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            telegramCallback.onResponse(call,
                                                    new Gson().fromJson(response.body().string(), Message.class));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public void onFailure(@NonNull final Call call, @NonNull final IOException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                telegramCallback.onFailure(call, e);
                            }
                        });
                    }
                });
    }
}