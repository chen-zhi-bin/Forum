package com.program.module_moyu.model.bean;

import com.program.moudle_base.model.ICategoryItem;

public class TopicIndexBean implements ICategoryItem {
    private String id;
    private String topicName;

    public TopicIndexBean(String id, String topicName) {
        this.id = id;
        this.topicName = topicName;
    }

    @Override
    public String getCategoryId() {
        return id;
    }

    @Override
    public String getName() {
        return topicName;
    }
}
