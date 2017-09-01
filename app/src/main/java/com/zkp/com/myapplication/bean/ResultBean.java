package com.zkp.com.myapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/21.
 */

@Entity
public class ResultBean implements Serializable {

    private String date;
    private int day;
    private String event;
    private String id;
    private int month;
    private String title;

    @Generated(hash = 1491631062)
    public ResultBean(String date, int day, String event, String id, int month,
                      String title) {
        this.date = date;
        this.day = day;
        this.event = event;
        this.id = id;
        this.month = month;
        this.title = title;
    }

    @Generated(hash = 2137771703)
    public ResultBean() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ResultBean that = (ResultBean) o;
        if (day != that.day)
            return false;
        if (month != that.month)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null)
            return false;
        if (event != null ? !event.equals(that.event) : that.event != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }
}
