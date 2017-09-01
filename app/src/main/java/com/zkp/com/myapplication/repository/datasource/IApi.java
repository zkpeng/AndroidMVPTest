package com.zkp.com.myapplication.repository.datasource;

import com.zkp.com.myapplication.model.HistoryListModel;

/**
 * @author ZKP
 *         created at:2017/7/24 8:37
 */

public interface IApi {

    void getHistroyList(final HistoryListModel.OnHistoryListListener onHistoryListListener);
}
