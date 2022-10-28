package com.program.module_home.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.program.module_home.model.bean.CategoryDB;

@Database(version = 1, exportSchema = false, entities = {CategoryDB.class})
public abstract class ChannelDatabase extends RoomDatabase {
    public abstract ChannelDao getChannelDao();
}
