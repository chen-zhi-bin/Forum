package com.program.module_wenda.model.bean;

public class Answer {
    private String wendaId;
    private String content;

    public Answer(String wendaId, String content) {
        this.wendaId = wendaId;
        this.content = content;
    }

    public String getWendaId() {
        return wendaId;
    }

    public String getContent() {
        return content;
    }
}
