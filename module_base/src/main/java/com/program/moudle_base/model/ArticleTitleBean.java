package com.program.moudle_base.model;

public class ArticleTitleBean extends Object{
    public String elementId;
    public String title;
    public int level;

    public ArticleTitleBean(String elementId, String title, int level) {
        this.elementId = elementId;
        this.title = title;
        this.level = level;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "ArtivleTitleBean{" +
                "elementId='" + elementId + '\'' +
                ", title='" + title + '\'' +
                ", level=" + level +
                '}';
    }
}
