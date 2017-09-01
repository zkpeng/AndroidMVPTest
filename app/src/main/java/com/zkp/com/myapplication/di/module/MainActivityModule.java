package com.zkp.com.myapplication.di.module;

import android.content.Context;

import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.presenter.HistoryListPresenter;
import com.zkp.com.myapplication.repository.ApiImplFactory;
import com.zkp.com.myapplication.view.IHistoryListView;

import dagger.Module;
import dagger.Provides;

/**
 * @author ZKP
 *         created at:2017/7/27 13:14
 */
@Module
public class MainActivityModule {

    private Context context;

    public MainActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public IHistoryListView provideIHistoryListView() {
        return (IHistoryListView) context;
    }

    @Provides
    public HistoryListPresenter provideHistoryListPresenter(IHistoryListView iHistoryListView, HistoryListModel historyListModel) {
        return new HistoryListPresenter(iHistoryListView, historyListModel);
    }

    @Provides
    public HistoryListModel provideHistoryListModel(ApiImplFactory apiImplFactory) {
        return new HistoryListModel(apiImplFactory);
    }

    @Provides
    public ApiImplFactory provideApiImplFactory(DBManager dbManager) {
        return new ApiImplFactory(dbManager);
    }

    @Provides
    public DBManager provideDBManager() {
        return new DBManager(context);
    }
}
