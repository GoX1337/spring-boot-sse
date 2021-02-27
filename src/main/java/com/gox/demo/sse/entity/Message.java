package com.gox.demo.sse.entity;

import java.util.Date;

public class Message {

    private int id;
    private String payload;
    private int value;
    private Date date;

    public Message(int id, String payload, int value, Date date) {
        this.id = id;
        this.payload = payload;
        this.value = value;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
