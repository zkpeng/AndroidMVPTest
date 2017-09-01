package com.zkp.com.myapplication.bean;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * 历史上的今天列表项
 *
 * @author ZKP
 *         created at:2017/7/19 10:23
 */

public class HistoryListItemBean {

    /**
     * msg : success
     * retCode : 200
     * result : [{"date":"19821231","day":31,"event":"1982年12月31日加纳陆军接管了政权。\n加纳新的军人领袖罗林斯这天在电台发表讲话说，加纳陆军已经接管了1979年9月执政的利曼总统的政府，开始执政。这是罗林斯在三年内第二次掌权。\n","id":"569881b8590146d407333528","month":12,"title":"加纳发生军事政变"},{"date":"19531231","day":31,"event":"1953年12月31日。一支由英国发起的寻找谜一般的\u201c雪人\u201d的探险队已到达印度，准备的往尼泊尔。6个月前曾征服喜马拉雅山的埃德蒙·希拉里说，他在早期对喜马拉雅山进行探险时就看见过奇怪的，长着长发的动物的足迹。\n","id":"569881b8590146d407333529","month":12,"title":"搜寻\u201c雪人\u201d的工作开始进行"},{"date":"19471231","day":31,"event":"1947年12月31日，罗马尼亚国王迈克尔在苏联支持的共产党人的压力下被迫退位，红色帷幕至此覆盖了整个东欧。这个正在度假的东欧的最后一个君主迈克尔被迅速叫回国，并由总统戈查向他递交了让位证书。\n","id":"569881b8590146d40733352a","month":12,"title":"罗马尼亚王朝倒台"}]
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }
}
