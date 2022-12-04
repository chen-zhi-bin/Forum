package com.program.moudle_base.model;

import java.io.File;
import java.nio.file.Files;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;

public class NewCollection {

    /**
     * name 收藏夹名称
     * description收藏夹描述
     * cover 封面
     * permission '0'表示公开'1'表示私有
     */
    private String name;
    private String description;
    private String cover;
    private String permission;

    public NewCollection(String name, String description, String cover, String permission) {
        this.name = name;
        this.description = description;
        this.cover = cover;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCover() {
        return cover;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return "NewCollection{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cover=" + cover +
                ", permission='" + permission + '\'' +
                '}';
    }
}
