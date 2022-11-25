package com.program.forum;

public class GuideBean {
    private int resId;
    private String title;
    private String desc;

    public GuideBean(int resId, String title, String desc) {
        this.resId = resId;
        this.title = title;
        this.desc = desc;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "GuideBean{" +
                "resId=" + resId +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
