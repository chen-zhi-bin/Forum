package com.program.module_moyu.model.bean;

import java.util.List;

/**
 * 发表动态
 */
public class Moment {
//            content为内容
//            linkUrl为链接
//            topicId为话题Id
//            images为图片列表，图片链接地址，最多4张
    private String content;
    private String topicId;
    private List<String> images;
    private String linkUrl;

    public Moment(String content, String topicId, List<String> images, String linkUrl) {
        this.content = content;
        this.topicId = topicId;
        this.images = images;
        this.linkUrl = linkUrl;
    }

    @Override
    public String toString() {
        return "Moment{" +
                "content='" + content + '\'' +
                ", topicId='" + topicId + '\'' +
                ", images=" + images +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
