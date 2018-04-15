package com.brett.beam;

/**
 * Created by Ermano
 * on 4/14/2018.
 */

public class MessageNFC {
    private String from;
    private String message;
    private String mDate;

    public MessageNFC(String from, String message, String mDate) {
        this.from = from;
        this.message = message;
        this.mDate = mDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
