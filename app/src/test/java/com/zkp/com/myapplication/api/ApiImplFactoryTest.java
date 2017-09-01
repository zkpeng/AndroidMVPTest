package com.zkp.com.myapplication.api;

import com.squareup.okhttp.Cache;
import com.zkp.com.myapplication.db.DBManager;
import com.zkp.com.myapplication.repository.ApiImplFactory;
import com.zkp.com.myapplication.repository.datasource.CacheApiImpl;
import com.zkp.com.myapplication.repository.datasource.IApi;
import com.zkp.com.myapplication.repository.datasource.OkhttpApiImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * ApiImplFactory测试类
 *
 * @author ZKP
 *         created at:2017/7/24 15:52
 */

public class ApiImplFactoryTest {

    @Mock
    DBManager dbManager;

    private ApiImplFactory apiImplFactory;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        apiImplFactory = new ApiImplFactory(dbManager);
    }

    @Test
    public void test_create_cache_failed() throws Exception {
        Mockito.when(dbManager.isCached()).thenReturn(false);
        IApi iApi = apiImplFactory.create();
        assertNotNull(iApi);
        assertThat(iApi, is(instanceOf(OkhttpApiImpl.class)));
    }

    @Test
    public void test_create_cache_success() throws Exception {
        Mockito.when(dbManager.isCached()).thenReturn(true);
        IApi iApi = apiImplFactory.create();
        assertNotNull(iApi);
        assertThat(iApi, is(instanceOf(CacheApiImpl.class)));
    }
}
