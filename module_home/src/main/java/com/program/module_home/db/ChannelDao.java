package com.program.module_home.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.program.module_home.model.bean.CategoryDB;

import java.util.List;

@Dao
public interface ChannelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<CategoryDB> teacher);

    @Insert
    void insertChannel(CategoryDB cs);

//    @Insert
//    void insertChannels(CategoryDB cs);

    @Query("select * from channel where is_my = :isMy")
    List<CategoryDB> getChannelsByFilter(boolean isMy);

    @Query("select * from channel")
    List<CategoryDB> getChannels();

    @Update
    void updateChannels(List<CategoryDB> cs);

    @Update
    void updateChannel(CategoryDB cs);

}
