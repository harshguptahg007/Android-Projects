package com.example.android.newsapp;

public class News {

    private String title;
    private String description;
    private String url;
    private String urlImage;

    public News(String title, String description, String url, String urlImage) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
