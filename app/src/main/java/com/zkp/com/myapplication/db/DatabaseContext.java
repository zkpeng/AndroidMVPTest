package com.zkp.com.myapplication.db;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class DatabaseContext extends ContextWrapper {

    public DatabaseContext(Context base) {
        super(base);
    }

    /**
     * 获得数据库路径，如果不存在，则自动创建
     */
    @Override
    public File getDatabasePath(String name) {
        boolean sdExist = android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
        if (!sdExist) {//如果不存在,
            Log.e("SD卡管理：", "SD卡不存在，请加载SD卡");
            return null;
        } else {
            String dbDir = android.os.Environment.getExternalStorageDirectory().toString();
            dbDir += "/databases";//数据库所在目录
            String dbPath = dbDir + "/" + name;//数据库路径
            File dirFile = new File(dbDir);
            if (!dirFile.exists())
                dirFile.mkdirs();
            boolean isFileCreateSuccess = false;
            File dbFile = new File(dbPath);
            if (!dbFile.exists()) {
                try {
                    isFileCreateSuccess = dbFile.createNewFile();//创建文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else
                isFileCreateSuccess = true;
            if (isFileCreateSuccess)
                return dbFile;
            else
                return null;
        }
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode,
                                               SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
        return result;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory,
                                               DatabaseErrorHandler errorHandler) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
        return result;
    }
}