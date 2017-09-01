package com.zkp.com.myapplication.utils;

import com.zkp.com.myapplication.utils.DateUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * 日期工具类测试类
 *
 * @author ZKP
 *         created at:2017/7/25 10:57
 */
@RunWith(PowerMockRunner.class)
public class DateUtilsTest {

    @Mock
    Calendar calendar;

    private static final String EXPECTED_STR = "0611";

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(Calendar.class);
        when(calendar.get(Calendar.MONTH)).thenReturn(5);
        when(calendar.get(Calendar.DAY_OF_MONTH)).thenReturn(11);
    }

    @Test
    public void test_getTodayStr_right() throws Exception {
        String realStr = DateUtils.getTodayStr(calendar);
        assertEquals(realStr,EXPECTED_STR);
    }
}
