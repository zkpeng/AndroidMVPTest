package com.zkp.com.myapplication.repository.datasource;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zkp.com.myapplication.bean.HistoryListItemBean;
import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.model.HistoryListModel;

/**
 * IApi接口的okhttp实现
 *
 * @author ZKP
 *         created at:2017/7/24 8:39
 */

public class OkhttpApiImpl implements IApi {

    private DBManager dbManager;

    public OkhttpApiImpl(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void getHistroyList(final HistoryListModel.OnHistoryListListener onHistoryListListener) {

        RequestCallUtils.buildRequestCall()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        onHistoryListListener.onFail(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response) {
                        HistoryListItemBean historyListItemBean = new Gson().fromJson(response, HistoryListItemBean.class);
                        if (historyListItemBean.getRetCode() != null && historyListItemBean.getRetCode().equals("200")) {
                            onHistoryListListener.onSuccess(historyListItemBean.getResult());
                            dbManager.clear();
                            dbManager.insertHistoryList(historyListItemBean.getResult());
                        } else {
                            onHistoryListListener.onFail(historyListItemBean.getMsg());
                        }
                    }
                });
    }
}
