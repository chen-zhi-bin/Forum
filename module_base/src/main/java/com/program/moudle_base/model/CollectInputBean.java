package com.program.moudle_base.model;

public class CollectInputBean {
    private String collectionId;
    private String cover = "";
    private String title;
    private String type = "0";
    private String url;

    public CollectInputBean() {
    }

    public CollectInputBean(String collectionId, String title, String url) {
        this.collectionId = collectionId;
        this.title = title;
        this.url = url;
    }

    public CollectInputBean(String collectionId, String cover, String title, String type, String url) {
        this.collectionId = collectionId;
        this.cover = cover;
        this.title = title;
        this.type = type;
        this.url = url;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
