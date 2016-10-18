package com.monocole.app.event;

/**
 * Created by visitor15 on 10/18/16.
 */

public class SimpleEvent {

    private final int code;

    private final String message;

    public SimpleEvent(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
