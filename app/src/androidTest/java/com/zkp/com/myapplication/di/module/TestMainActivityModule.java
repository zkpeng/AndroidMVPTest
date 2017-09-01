package com.zkp.com.myapplication.di.module;

import android.content.Context;

import com.zkp.com.myapplication.mock.MockHistoryListPresenter;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.presenter.HistoryListPresenter;
import com.zkp.com.myapplication.view.IHistoryListView;

import static org.mockito.Mockito.mock;

/**
 * @author ZKP
 *         created at:2017/7/27 13:14
 */

public class TestMainActivityModule extends MainActivityModule {

    public TestMainActivityModule(Context context) {
        super(context);
    }

    @Override
    public IHistoryListView provideIHistoryListView() {
        return mock(IHistoryListView.class);
    }

    @Override
    public HistoryListPresenter provideHistoryListPresenter(IHistoryListView iHistoryListView, HistoryListModel historyListModel) {
        return new MockHistoryListPresenter(null, null);
    }
}
