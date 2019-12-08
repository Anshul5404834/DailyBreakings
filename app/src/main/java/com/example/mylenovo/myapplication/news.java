package com.example.mylenovo.myapplication;

import android.graphics.drawable.DrawableContainer;

public class news {
    public String URL;
    DrawableContainer container;
    private String content;
    private String date;
    private String description;
    private String Image;

    public news(String content, String description, String date, String bmp, String URL) {
        this.content = content;
        this.date = date;
        this.description = description;
        this.Image = bmp;
        this.URL = URL;

    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        int a = date.indexOf('T');
        String date1 = date.substring(0, a);
        return date1;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

}
