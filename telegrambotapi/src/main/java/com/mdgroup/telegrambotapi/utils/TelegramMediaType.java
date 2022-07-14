package com.mdgroup.telegrambotapi.utils;

public class TelegramMediaType {

    public static class Image {
        public static String png = "image/png";
        public static String jpg = "image/jpg";
        public static String jpeg = "image/jpeg";
        public static String bmp = "image/bmp";
        public static String gif = "image/gif";
    }

    public static class Video {
        public static String mp4 = "video/mp4";
        public static String wav = "video/wav";
    }

    public static class Audio {
        public static String mp3 = "audio/mp3";
        public static String ogg = "audio/ogg";
    }

    public static class Document {
        public static String file = "file/*";
    }
}