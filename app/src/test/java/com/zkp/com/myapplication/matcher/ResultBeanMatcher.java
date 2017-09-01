package com.zkp.com.myapplication.matcher;

import com.zkp.com.myapplication.bean.ResultBean;

import org.mockito.ArgumentMatcher;

import java.util.List;

/**
 * ResultBean 匹配器
 *
 * @author ZKP
 *         created at:2017/7/25 9:01
 */

public class ResultBeanMatcher extends ArgumentMatcher<List<ResultBean>> {

    private List<ResultBean> resultBeans;

    public ResultBeanMatcher(List<ResultBean> resultBeans) {
        this.resultBeans = resultBeans;
    }

    @Override
    public boolean matches(Object argument) {
        List<ResultBean> argResultBeans = (List<ResultBean>) argument;
        if (resultBeans.size() != argResultBeans.size()) {
            return false;
        }
        for (int i = 0; i < resultBeans.size(); i++) {
            ResultBean resultBean = resultBeans.get(i);
            ResultBean argResultBean = argResultBeans.get(i);
            if (resultBean.getId().equals(argResultBean.getId())
                    && resultBean.getTitle().equals(argResultBean.getTitle())
                    && resultBean.getEvent().equals(argResultBean.getEvent())
                    && resultBean.getDate().equals(argResultBean.getDate())
                    && resultBean.getMonth() == argResultBean.getMonth()
                    && resultBean.getDay() == argResultBean.getDay()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
