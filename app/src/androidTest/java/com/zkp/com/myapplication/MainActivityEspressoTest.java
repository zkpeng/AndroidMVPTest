package com.zkp.com.myapplication;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zkp.com.myapplication.activity.HistoryDetailActivity;
import com.zkp.com.myapplication.activity.MainActivity;
import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.di.component.TestMainActivityComponent;
import com.zkp.com.myapplication.presenter.HistoryListPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author ZKP
 *         created at:2017/7/19 16:59
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    private List<ResultBean> HISTORYS = new ArrayList<>();
    private static final String DIALOG_MESSAGE = "正在加载数据...";
    private static final String ERROR_MSG = "error message";

    @Inject
    HistoryListPresenter historyListPresenter;

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class, false, false);

    @Before
    public void setUp() throws Exception {
        App app = (App) getTargetContext().getApplicationContext();
        TestMainActivityComponent component = (TestMainActivityComponent) App.getMainActivityComponent(app);
        component.inject(this);

        intentsTestRule.launchActivity(new Intent(getTargetContext(),MainActivity.class));

        initTestDatas();
    }

    private void initTestDatas() {
        ResultBean resultBean1 = new ResultBean();
        resultBean1.setId("id1");
        resultBean1.setTitle("title1");
        resultBean1.setEvent("event1");
        resultBean1.setDate("date1");
        resultBean1.setMonth(1);
        resultBean1.setDay(1);
        HISTORYS.add(resultBean1);

        ResultBean resultBean2 = new ResultBean();
        resultBean2.setId("id2");
        resultBean2.setTitle("title2");
        resultBean2.setEvent("event2");
        resultBean2.setDate("date2");
        resultBean2.setMonth(2);
        resultBean2.setDay(2);
        HISTORYS.add(resultBean2);
    }

    @Test
    public void test_showHistorys() throws Exception {
        intentsTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                intentsTestRule.getActivity().showHistorys(HISTORYS);
            }
        });
        onView(withText("title1")).check(matches(isDisplayed()));
        onView(withText("title2")).check(matches(isDisplayed()));
    }

    @Test
    public void test_showHideProgressDialog() throws Exception {
        onView(withText(DIALOG_MESSAGE)).check(doesNotExist());
        intentsTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                intentsTestRule.getActivity().showProgressDialog();
            }
        });
        onView(withText(DIALOG_MESSAGE)).check(matches(isDisplayed()));
        intentsTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                intentsTestRule.getActivity().hideProgressDialog();
            }
        });
        onView(withText(DIALOG_MESSAGE)).check(doesNotExist());
    }

    @Test
    public void test_showErrorMsg() throws Exception {
        intentsTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                intentsTestRule.getActivity().showErrorMsg(ERROR_MSG);
            }
        });
        onView(withText(ERROR_MSG)).inRoot(withDecorView(not(is(intentsTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void test_historyItemClick() throws Exception {
        intentsTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                intentsTestRule.getActivity().showHistorys(HISTORYS);
            }
        });

        onView(withId(R.id.rv_history)).perform(actionOnItemAtPosition(1, click()));
        intended(allOf(
                hasComponent(HistoryDetailActivity.class.getName()),
                hasExtra(equalTo("history"), equalTo(HISTORYS.get(1)))));
    }
}
