package com.zkp.com.myapplication.presenter;

import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.presenter.HistoryListPresenter;
import com.zkp.com.myapplication.view.IHistoryListView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * HistoryListPresenter测试
 *
 * @author ZKP
 *         created at:2017/7/19 14:18
 */
//@RunWith(MockitoJUnitRunner.class)
public class HistoryListPresenterTest {

    public static final List<ResultBean> HISTORYS = new ArrayList<ResultBean>();
    public static final String FAIL_MSG = "日期不合法";

    @Mock
    private IHistoryListView iHistoryListView;
    @Mock
    private HistoryListModel historyListModel;
    @Captor
    private ArgumentCaptor<HistoryListModel.OnHistoryListListener> argumentCaptor;

    private HistoryListPresenter historyListPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        initTestDatas();
        historyListPresenter = new HistoryListPresenter(iHistoryListView, historyListModel);
    }

    private void initTestDatas() {
        for (int i = 0; i < 5; i++) {
            ResultBean resultBean = new ResultBean();
            resultBean.setId(i + "");
            resultBean.setDate("20170719");
            resultBean.setDay(19);
            resultBean.setEvent("事件内容" + i);
            resultBean.setMonth(7);
            resultBean.setTitle("事件标题" + i);
            HISTORYS.add(resultBean);
        }
    }

    @Test
    public void test_loadData_success() {
        historyListPresenter.loadDatas();
        verify(iHistoryListView).showProgressDialog();
        verify(historyListModel).getHistroyList(argumentCaptor.capture());

        argumentCaptor.getValue().onSuccess(HISTORYS);
        verify(iHistoryListView).hideProgressDialog();
        verify(iHistoryListView).showHistorys(HISTORYS);
    }

    @Test
    public void test_loadData_fail() {
        historyListPresenter.loadDatas();
        verify(iHistoryListView).showProgressDialog();
        verify(historyListModel).getHistroyList(argumentCaptor.capture());

        argumentCaptor.getValue().onFail(FAIL_MSG);
        verify(iHistoryListView).hideProgressDialog();
        verify(iHistoryListView).showErrorMsg(FAIL_MSG);
    }
}
