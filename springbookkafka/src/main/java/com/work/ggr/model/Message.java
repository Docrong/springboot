package com.work.ggr.model;

/**
 * @author : gr
 * @date : 2019/9/17 14:36
 */
public class Message {
    private String id;
    private String msg;
    private String sendTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
