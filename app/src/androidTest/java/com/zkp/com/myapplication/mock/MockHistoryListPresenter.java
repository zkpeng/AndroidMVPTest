package com.zkp.com.myapplication.mock;

import android.util.Log;

import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.presenter.HistoryListPresenter;
import com.zkp.com.myapplication.view.IHistoryListView;

/**
 * Created by Administrator on 2017/7/27.
 */

public class MockHistoryListPresenter extends HistoryListPresenter {
    public MockHistoryListPresenter(IHistoryListView iHistoryListView, HistoryListModel historyListModel) {
        super(iHistoryListView, historyListModel);
    }

    @Override
    public void loadDatas() {
        Log.e("","");
    }
}
