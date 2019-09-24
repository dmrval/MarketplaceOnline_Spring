package com.epam.dmrval.learnSpring;

import java.text.DateFormat;
import java.util.Date;

/**
 * Author - Damir_Valeev
 * Created on 9/24/2019
 */
public class Event {
    int id;
    String msg;
    Date date;
    DateFormat df;

    public Event(Date date, DateFormat df) {
        id = (int) (Math.random()*10);
        this.date = date;
        this.df = df;
    }

    public Event(Date date) {
        id = (int) (Math.random()*10);
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return df.format(date);
    }
}
