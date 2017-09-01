package com.zkp.com.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zkp.com.myapplication.App;
import com.zkp.com.myapplication.R;
import com.zkp.com.myapplication.adapter.HistoryListAdapter;
import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.di.module.MainActivityModule;
import com.zkp.com.myapplication.presenter.HistoryListPresenter;
import com.zkp.com.myapplication.utils.DialogUtils;
import com.zkp.com.myapplication.view.IHistoryListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 历史上的今天-列表
 *
 * @author ZKP
 *         created at:2017/7/19 10:13
 */
public class MainActivity extends AppCompatActivity implements IHistoryListView, HistoryListAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private HistoryListAdapter historyListAdapter;
    private List<ResultBean> historyDatas;

    @Inject
    HistoryListPresenter historyListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getMainActivityComponent(this).inject(this);
        setTitle("历史上的今天");
        initRecyclerView();

        historyListPresenter.loadDatas();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        historyDatas = new ArrayList<>();
        historyListAdapter = new HistoryListAdapter(this);
        recyclerView.setAdapter(historyListAdapter);
    }

    @Override
    public void showHistorys(List<ResultBean> historyListItemBeans) {
        historyDatas = historyListItemBeans;
        historyListAdapter.refreshValues(historyDatas);
    }

    @Override
    public void showProgressDialog() {
        DialogUtils.showProgressDialog(this);
    }

    @Override
    public void hideProgressDialog() {
        DialogUtils.hideProgressDialog(this);
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(ResultBean resultBean) {
        startActivity(HistoryDetailActivity.getCallingIntent(this, resultBean));
    }
}
