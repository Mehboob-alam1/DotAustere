package com.mehboob.ndfrag.ui.about;

public class AboutModel {
    private int image;
    private String title;
    private String Desc;

    public AboutModel(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        Desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
