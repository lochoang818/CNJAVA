package com.example.labs4;

public class JsonResponse {
    private int code;
    private String message;
    private Object data;

    public JsonResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
