package com.program.module_home.model.bean;

public class PriseArticleInputBean {
    private String articleId;
    private int sob;

    public PriseArticleInputBean() {
    }

    public PriseArticleInputBean(String articleId, int sob) {
        this.articleId = articleId;
        this.sob = sob;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public int getSob() {
        return sob;
    }

    public void setSob(int sob) {
        this.sob = sob;
    }

    @Override
    public String toString() {
        return "PriseArticleInputBean{" +
                "articleId='" + articleId + '\'' +
                ", sob=" + sob +
                '}';
    }
}
