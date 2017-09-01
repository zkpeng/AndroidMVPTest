package com.zkp.com.myapplication.presenter;

import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.view.IHistoryListView;

import java.util.List;

import javax.inject.Inject;

/**
 * 历史上的今天-列表
 *
 * @author ZKP
 *         created at:2017/7/19 10:53
 */

public class HistoryListPresenter implements HistoryListModel.OnHistoryListListener {

    private IHistoryListView iHistoryListView;
    private HistoryListModel historyListModel;

    public HistoryListPresenter(IHistoryListView iHistoryListView, HistoryListModel historyListModel) {
        this.iHistoryListView = iHistoryListView;
        this.historyListModel = historyListModel;
    }

    public void loadDatas() {
        iHistoryListView.showProgressDialog();
        historyListModel.getHistroyList(this);
    }

    @Override
    public void onSuccess(List<ResultBean> historys) {
        iHistoryListView.hideProgressDialog();
        iHistoryListView.showHistorys(historys);
    }

    @Override
    public void onFail(String msg) {
        iHistoryListView.hideProgressDialog();
        iHistoryListView.showErrorMsg(msg);
    }
}
