package com.program.module_home.model.bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "channel")
public class CategoryDB {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.TEXT)
    String id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    String categoryName;

    @ColumnInfo(name = "order")
    int order;
    //final String description ="";
    public String description ="";
    //final String createTime ="";
    public String createTime ="";
    //final String pyName ="";
    public String pyName ="";

    @ColumnInfo(name = "is_my")
    boolean isMy =true;

    public CategoryDB(){

    }

    @Ignore
    public CategoryDB(String id, String categoryName, int order) {
        this.id = id;
        this.categoryName = categoryName;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getPyName() {
        return pyName;
    }

    public boolean isMy() {
        return isMy;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setMy(boolean my) {
        isMy = my;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    @Override
    public String toString() {
        return "CategoryDB{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", order=" + order +
                ", description='" + description + '\'' +
                ", createTime='" + createTime + '\'' +
                ", pyName='" + pyName + '\'' +
                ", isMy=" + isMy +
                '}';
    }
}
