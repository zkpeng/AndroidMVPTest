package com.zkp.com.myapplication.api;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;
import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.matcher.ResultBeanMatcher;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.repository.datasource.OkhttpApiImpl;
import com.zkp.com.myapplication.repository.datasource.RequestCallUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * OkhttpApiImpl测试类
 *
 * @author ZKP
 *         created at:2017/7/24 16:28
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RequestCallUtils.class})
public class OkhttpApiImplTest {

    private static final String RESONSE_SUCCESS = "{" +
            "\"msg\":\"success\"," +
            "\"result\":[{" +
            "\"date\":\"19980725\"," +
            "\"day\":25," +
            "\"event\":\"　　1998年7月25日，《文汇报》和《新民晚报》组成报业集团。\"," +
            "\"id\":\"569881b4590146d407332777\"," +
            "\"month\":7," +
            "\"title\":\"《文汇报》和《新民晚报》组成报业集团\"}]," +
            "\"retCode\":" +
            "\"200\"}";
    private static final List<ResultBean> RESPONSE_SUCCESS_BEANS = new ArrayList<>();

    private static final Exception EXCEPTION = new Exception("Unable to resolve host \"apicloud.mob.com\": No address associated with hostname");
    @Mock
    DBManager dbManager;
    @Mock
    HistoryListModel.OnHistoryListListener onHistoryListListener;
    @Mock
    RequestCall requestCall;
    @Captor
    ArgumentCaptor<StringCallback> argumentCaptor;

    private OkhttpApiImpl okhttpApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(RequestCallUtils.class);
        initSuccessBeans();
        okhttpApi = new OkhttpApiImpl(dbManager);
    }

    private void initSuccessBeans() {
        ResultBean resultBean = new ResultBean();
        resultBean.setId("569881b4590146d407332777");
        resultBean.setTitle("《文汇报》和《新民晚报》组成报业集团");
        resultBean.setEvent("　　1998年7月25日，《文汇报》和《新民晚报》组成报业集团。");
        resultBean.setDate("19980725");
        resultBean.setMonth(7);
        resultBean.setDay(25);
        RESPONSE_SUCCESS_BEANS.add(resultBean);
    }

    @Test
    public void test_getHistroyList_OnResponse() throws Exception {

        PowerMockito.when(RequestCallUtils.buildRequestCall()).thenReturn(requestCall);
        okhttpApi.getHistroyList(onHistoryListListener);
        verify(requestCall).execute(argumentCaptor.capture());
        argumentCaptor.getValue().onResponse(RESONSE_SUCCESS);

        verify(onHistoryListListener, times(1)).onSuccess(argThat(new ResultBeanMatcher(RESPONSE_SUCCESS_BEANS)));
        verify(dbManager).clear();
        verify(dbManager).insertHistoryList(RESPONSE_SUCCESS_BEANS);
    }

    @Test
    public void test_getHistroyList_onError() throws Exception {

        PowerMockito.when(RequestCallUtils.buildRequestCall()).thenReturn(requestCall);
        okhttpApi.getHistroyList(onHistoryListListener);
        verify(requestCall).execute(argumentCaptor.capture());
        argumentCaptor.getValue().onError(any(Request.class), EXCEPTION);

        verify(onHistoryListListener, times(1)).onFail(EXCEPTION.getMessage());
    }
}
