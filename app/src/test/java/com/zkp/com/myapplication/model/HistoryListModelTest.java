package com.zkp.com.myapplication.model;

import android.content.Context;

import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.model.HistoryListModel;
import com.zkp.com.myapplication.repository.ApiImplFactory;
import com.zkp.com.myapplication.repository.datasource.IApi;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * HistoryListModel 测试类
 *
 * @author ZKP
 *         created at:2017/7/27 14:00
 */

public class HistoryListModelTest {

    @Mock
    HistoryListModel.OnHistoryListListener onHistoryListListener;
    @Mock
    ApiImplFactory apiImplFactory;
    @Mock
    IApi iApi;

    private HistoryListModel historyListModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        historyListModel = new HistoryListModel(apiImplFactory);
    }

    @Test
    public void test_getHistoryList() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(apiImplFactory.create()).thenReturn(iApi);
        historyListModel.getHistroyList(onHistoryListListener);
        verify(iApi).getHistroyList(onHistoryListListener);
    }
}
