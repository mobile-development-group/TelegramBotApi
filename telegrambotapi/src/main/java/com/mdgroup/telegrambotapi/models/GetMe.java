package com.mdgroup.telegrambotapi.models;

public class GetMe {

    private Result result;

    private boolean ok;

    private int error_code;

    private String description;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private class Result {

        private int id;
        private String first_name;
        private String username;
        private boolean is_bot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean is_bot() {
            return is_bot;
        }

        public void setIs_bot(boolean is_bot) {
            this.is_bot = is_bot;
        }
    }
}