package com.zkp.com.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zkp.com.myapplication.bean.DaoMaster;
import com.zkp.com.myapplication.bean.DaoSession;
import com.zkp.com.myapplication.bean.ResultBean;
import com.zkp.com.myapplication.bean.ResultBeanDao;
import com.zkp.com.myapplication.utils.DateUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

/**
 * 数据库管理类
 *
 * @author ZKP
 *         created at:2017/7/21 11:31
 */
public class DBManager {

    private final static String dbName = "history_db.db";
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
//        DatabaseContext databaseContext = new DatabaseContext(context);
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    public List<ResultBean> queryHistoryList(String date) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ResultBeanDao resultBeanDao = daoSession.getResultBeanDao();
        QueryBuilder<ResultBean> qb = resultBeanDao.queryBuilder();
        qb.where(ResultBeanDao.Properties.Date.like("%" + date))/*.orderAsc(ResultBeanDao.Properties.Date)*/;
        List<ResultBean> list = qb.list();
        return list;
    }

    public void insertHistoryList(List<ResultBean> historys) {
        if (historys == null || historys.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ResultBeanDao resultBeanDao = daoSession.getResultBeanDao();
        resultBeanDao.insertInTx(historys);
    }

    public boolean isCached() {
        List<ResultBean> list = queryHistoryList(DateUtils.getTodayStr(Calendar.getInstance()));
        return list != null && list.size() > 0;
    }

    public void clear() {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        ResultBeanDao resultBeanDao = daoSession.getResultBeanDao();
        resultBeanDao.deleteAll();
    }

    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }
}