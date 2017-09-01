package com.zkp.com.myapplication.activity;

import android.content.Intent;
import android.widget.TextView;

import com.zkp.com.myapplication.BuildConfig;
import com.zkp.com.myapplication.R;
import com.zkp.com.myapplication.activity.HistoryDetailActivity;
import com.zkp.com.myapplication.bean.HistoryListItemBean;
import com.zkp.com.myapplication.bean.ResultBean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ZKP
 *         created at:2017/7/19 18:42
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class HistoryDetailActivityRobolectricTest {

    private HistoryDetailActivity historyDetailActivity;
    private static ResultBean historyDetail = new ResultBean();

    @Before
    public void initHistroyDetailActivity() {
        Intent intent = new Intent();
        historyDetail = new ResultBean();
        historyDetail.setTitle("history_detail_title");
        historyDetail.setEvent("history_detail_event");
        intent.putExtra("history", historyDetail);
        historyDetailActivity = Robolectric.buildActivity(HistoryDetailActivity.class, intent).create().get();
    }

    @Test
    public void test_showHistoryDetail_right() {
        TextView tvTitle = (TextView) historyDetailActivity.findViewById(R.id.history_title);
        TextView tvEvent = (TextView) historyDetailActivity.findViewById(R.id.history_content);

        assertNotNull(tvTitle);
        assertNotNull(tvEvent);
        assertEquals(tvTitle.getText(), historyDetail.getTitle());
        assertEquals(tvEvent.getText(), historyDetail.getEvent());
    }
}
