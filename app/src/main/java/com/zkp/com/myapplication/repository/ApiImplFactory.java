package com.zkp.com.myapplication.repository;

import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.repository.datasource.CacheApiImpl;
import com.zkp.com.myapplication.repository.datasource.IApi;
import com.zkp.com.myapplication.repository.datasource.OkhttpApiImpl;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/7/24.
 */

public class ApiImplFactory {

    private DBManager dbManager;
    private IApi iApi;

    public ApiImplFactory(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public IApi create()
    {
//        IApi iApi;
        boolean isCached = dbManager.isCached();
        if (!isCached) {
            iApi = new OkhttpApiImpl(dbManager);
        } else {
            iApi = new CacheApiImpl(dbManager);
        }
        return iApi;
    }
}
