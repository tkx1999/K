package com.it.www.util;

public class JsonString {
    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonString() {
    }

    public JsonString(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
