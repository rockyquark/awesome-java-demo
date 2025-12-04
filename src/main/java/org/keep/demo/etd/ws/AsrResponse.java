package org.keep.demo.etd.ws;

public record AsrResponse(boolean success, String text, String error) {

    public static AsrResponse success(String text) {
        return new AsrResponse(true, text, null);
    }

    public static AsrResponse error(String err) {
        return new AsrResponse(false, null, err);
    }
}
