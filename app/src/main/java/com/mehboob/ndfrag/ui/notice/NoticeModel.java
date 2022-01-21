package com.mehboob.ndfrag.ui.notice;

import java.util.Comparator;

public class NoticeModel  {
    String image,date,time,title;

    public NoticeModel() {
    }

    public NoticeModel(String image, String date, String time, String title) {
        this.image = image;
        this.date = date;
        this.time = time;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setIamge(String iamge) {
        this.image = iamge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
