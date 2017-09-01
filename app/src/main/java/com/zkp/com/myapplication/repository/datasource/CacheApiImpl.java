package com.zkp.com.myapplication.repository.datasource;

import android.content.Context;

import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.utils.DateUtils;

import java.util.Calendar;
import java.util.List;

/**
 * IApi接口的缓存实现
 *
 * @author ZKP
 *         created at:2017/7/24 8:40
 */
public class CacheApiImpl implements IApi {

    private DBManager dbManager;

    public CacheApiImpl(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void getHistroyList(HistoryListModel.OnHistoryListListener onHistoryListListener) {
        List<ResultBean> historys = dbManager.queryHistoryList(DateUtils.getTodayStr(Calendar.getInstance()));
        if (historys != null) {
            onHistoryListListener.onSuccess(historys);
        }else{
            onHistoryListListener.onFail("");
        }
    }
}
