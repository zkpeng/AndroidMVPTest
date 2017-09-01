package com.zkp.com.myapplication.model;

import android.content.Context;

import com.zkp.com.myapplication.repository.ApiImplFactory;
import com.zkp.com.myapplication.repository.datasource.CacheApiImpl;
import com.zkp.com.myapplication.repository.datasource.IApi;
import com.zkp.com.myapplication.repository.datasource.OkhttpApiImpl;
import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.db.DBManager;

import java.util.List;

import javax.inject.Inject;

/**
 * 历史上的今天-列表
 *
 * @author ZKP
 *         created at:2017/7/19 10:59
 */

public class HistoryListModel {

    private ApiImplFactory apiImplFactory;

    public HistoryListModel(ApiImplFactory apiImplFactory) {
        this.apiImplFactory = apiImplFactory;
    }

    public interface OnHistoryListListener {
        void onSuccess(List<ResultBean> historys);
        void onFail(String msg);
    }

    public void getHistroyList(OnHistoryListListener onHistoryListListener) {
        IApi iApi = apiImplFactory.create();
        iApi.getHistroyList(onHistoryListListener);
    }
}
