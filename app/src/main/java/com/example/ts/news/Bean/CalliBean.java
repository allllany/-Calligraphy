package com.example.ts.news.Bean;

import java.io.Serializable;
//书法知识对应的java类
public class CalliBean implements Serializable {
    //Serializable接口是启用其序列化功能的接口。
    //实现java.io.Serializable 接口的类是可序列化的。
    // 没有实现此接口的类将不能使它们的任意状态被序列化或逆序列化。
    private String title;
    private String notmatch;
    private String desc;
    private int picId;

    public CalliBean(String title, String notmatch, String desc, int picId) {
        this.title = title;
        this.notmatch = notmatch;
        this.desc = desc;
        this.picId = picId;
    }
    public CalliBean(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotmatch() {
        return notmatch;
    }

    public void setNotmatch(String notmatch) {
        this.notmatch = notmatch;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}

