package com.zkp.com.myapplication.view;

/**
 * view基类
 *
 * @author ZKP
 *         created at:2017/7/19 10:17
 */

public interface IBaseView {

    void showProgressDialog();

    void hideProgressDialog();

    void showErrorMsg(String msg);
}
