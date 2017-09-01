package com.zkp.com.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zkp.com.myapplication.R;
import com.zkp.com.myapplication.bean.HistoryListItemBean;
import com.zkp.com.myapplication.bean.ResultBean;

/**
 * 历史上的今天-详情
 *
 * @author ZKP
 *         created at:2017/7/19 13:48
 */

public class HistoryDetailActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvContent;

    private ResultBean history;

    public static Intent getCallingIntent(Context context, ResultBean history) {
        Intent intent = new Intent(context, HistoryDetailActivity.class);
        intent.putExtra("history", history);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        setTitle("详情");
        history = (ResultBean) getIntent().getSerializableExtra("history");
        initView();
        initData();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.history_title);
        tvContent = (TextView) findViewById(R.id.history_content);
    }

    private void initData() {
        if (history != null) {
            tvTitle.setText(history.getTitle());
            tvContent.setText(history.getEvent());
        }
    }
}
