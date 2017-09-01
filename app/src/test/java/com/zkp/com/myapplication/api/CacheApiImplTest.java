package com.zkp.com.myapplication.api;

import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.repository.datasource.CacheApiImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * CacheApiImpl测试类
 *
 * @author ZKP
 *         created at:2017/7/24 16:08
 */

public class CacheApiImplTest {

    private List<ResultBean> historys = new ArrayList<>();

    @Mock
    DBManager dbManager;
    @Mock
    HistoryListModel.OnHistoryListListener onHistoryListListener;

    private CacheApiImpl cacheApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        cacheApi = new CacheApiImpl(dbManager);
    }

    @Test
    public void test_getHistoryList_success() throws Exception {
        when(dbManager.queryHistoryList(anyString())).thenReturn(historys);
        cacheApi.getHistroyList(onHistoryListListener);
        verify(onHistoryListListener).onSuccess(historys);
    }

    @Test
    public void test_getHistoryList_fail() throws Exception {
        when(dbManager.queryHistoryList(anyString())).thenReturn(null);
        cacheApi.getHistroyList(onHistoryListListener);
        verify(onHistoryListListener).onFail("");
    }
}
