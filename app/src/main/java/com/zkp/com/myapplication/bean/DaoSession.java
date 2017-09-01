package com.zkp.com.myapplication.bean;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.zkp.com.myapplication.bean.ResultBean;

import com.zkp.com.myapplication.bean.ResultBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig resultBeanDaoConfig;

    private final ResultBeanDao resultBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        resultBeanDaoConfig = daoConfigMap.get(ResultBeanDao.class).clone();
        resultBeanDaoConfig.initIdentityScope(type);

        resultBeanDao = new ResultBeanDao(resultBeanDaoConfig, this);

        registerDao(ResultBean.class, resultBeanDao);
    }
    
    public void clear() {
        resultBeanDaoConfig.getIdentityScope().clear();
    }

    public ResultBeanDao getResultBeanDao() {
        return resultBeanDao;
    }

}
