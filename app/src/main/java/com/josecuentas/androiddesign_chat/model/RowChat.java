package com.josecuentas.androiddesign_chat.model;

import java.util.Date;

/**
 * Created by PibeDx on 14/08/2017.
 */

public class RowChat {

    public String message;
    public Date timeStamp;

    public RowChat(String message, Date timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
