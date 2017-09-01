package com.zkp.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zkp.com.myapplication.activity.HistoryDetailActivity;
import com.zkp.com.myapplication.activity.MainActivity;
import com.zkp.com.myapplication.bean.ResultBean;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author ZKP
 *         created at:2017/7/19 18:42
 */

@RunWith(AndroidJUnit4.class)
public class HistoryDetailActivityEspressoTest {

    private static ResultBean historyDetail = new ResultBean();

    @Rule
    public ActivityTestRule<HistoryDetailActivity> activityTestRule = new ActivityTestRule<HistoryDetailActivity>(HistoryDetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getTargetContext();
            Intent intent = new Intent(targetContext, MainActivity.class);
            historyDetail = new ResultBean();
            historyDetail.setTitle("history_detail_title");
            historyDetail.setEvent("history_detail_event");
            intent.putExtra("history", historyDetail);
            return intent;
        }
    };

    @Test
    public void test_showHistoryDetail_right() throws Exception {

        onView(withId(R.id.history_title)).check(matches(withText(historyDetail.getTitle())));
        onView(withId(R.id.history_content)).check(matches(withText(historyDetail.getEvent())));
    }
}
