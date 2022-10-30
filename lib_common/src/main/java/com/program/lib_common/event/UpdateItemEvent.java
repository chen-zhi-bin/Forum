package com.program.lib_common.event;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public final class UpdateItemEvent {
    private String event;
    private String id;

    public UpdateItemEvent(String event, String id) {
        this.event = event;
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static final class Event{
        @NotNull
        public static final String UPDATE_ARTICLE="update_article";
        @NotNull
        public static final String UPDATE_MOYU = "update_moyu";
        @NotNull
        public static final String UPDATE_WENDA = "update_wenda";
        @NotNull
        public static final UpdateItemEvent.Event INSTANCE;

        private Event() {
        }

        static {
            Event event1 = new Event();
            INSTANCE = event1;
        }
    }
}
