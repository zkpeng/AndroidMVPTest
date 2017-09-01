package com.zkp.com.myapplication.view;

import com.zkp.com.myapplication.bean.ResultBean;

import java.util.List;

/**
 * 历史上的今天列表view
 *
 * @author ZKP
 *         created at:2017/7/19 10:21
 */

public interface IHistoryListView extends IBaseView {

    void showHistorys(List<ResultBean> historyListItemBeans);
}
