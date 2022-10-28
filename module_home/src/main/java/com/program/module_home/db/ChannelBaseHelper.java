package com.program.module_home.db;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.program.lib_base.LogUtils;
import com.program.moudle_base.base.BaseApplication;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

public class ChannelBaseHelper {

    private static final String DB_NAME = "channelData.db";
    private static ArrayList<Migration1> MIGRATIONS = new ArrayList<>();

    public ChannelDatabase getDb(){
        LogUtils.d("test","MIG ="+MIGRATIONS);
        Lazy<Object> lazy1 = LazyKt.lazy(() ->
                Room.databaseBuilder(
                BaseApplication.getAppContext().getApplicationContext(),
                ChannelDatabase.class,
                DB_NAME
                ).addCallback(new CreatedCallback())
                    .addMigrations(new Migration(1,2) {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {

                        }
                    })
                    .build());
        LogUtils.d("test","data = "+lazy1.getValue());
        return (ChannelDatabase) lazy1.getValue();
    }


    private static class CreatedCallback extends RoomDatabase.Callback{
        @NotNull
        public static final ChannelBaseHelper.CreatedCallback INSTANCE;
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {

           // 在新装app时会调用，调用时机为数据库build()之后，数据库升级时不调用此函数

//            ArraysKt.map(MIGRATIONS, new Function1<Migration1, Object>() {
//                @Override
//                public Object invoke(Migration1 migration1) {
//                    migration1.migrate(db);
//                    return null;
//                }
//            });
//            Migration1[] migrations = ChannelBaseHelper.getMIGRATIONS();
//            Collection collection =(Collection)(new ArrayList<>());
//            int size = migrations.length;
//            for (int i=0;i<size;i++){
//                Migration1 migration = migrations[i];
//                migration.migrate(db);
//                Unit instance = Unit.INSTANCE;
//                collection.add(instance);
//            }

        }
         static {
            CreatedCallback createdCallback = new CreatedCallback();
            INSTANCE = createdCallback;
        }
    }

//    public static Migration1[] getMIGRATIONS() {
//        return MIGRATIONS;
//    }

    private class Migration1 extends Migration {

        @NotNull
        public final ChannelBaseHelper.Migration1 INSTANCE;

        public Migration1() {
            super(1, 2);
        }

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // 数据库的升级语句
            // database.execSQL("")
        }
        {
            Migration1 migration1 = new Migration1();
            INSTANCE = migration1;
        }
    }
}
