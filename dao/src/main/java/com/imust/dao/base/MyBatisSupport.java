package com.imust.dao.base;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.util.List;


public class MyBatisSupport {



    @Resource
    private SqlSessionTemplate sqlSession;

    protected int insert(String statement, Object parameter) throws Exception {
        int res = 0;
        try {
            res = sqlSession.insert(statement, parameter);
        } catch (Exception e) {
            throw e;
        }
        return res;
    }

    protected int delete(String statement, Object parameter) throws Exception {
        int res = 0;
        try {
            res = sqlSession.delete(statement, parameter);
        } catch (Exception e) {
            throw e;
        }
        return res;
    }

    protected int update(String statement, Object parameter) throws Exception {
        int res = 0;
        try {
            res = sqlSession.update(statement, parameter);
        } catch (Exception e) {
            throw e;
        }
        return res;
    }

    protected <T> T select(String statement, Object parameter) throws Exception {
        T obj = null;
        try {
            obj = (T) sqlSession.selectOne(statement, parameter);
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }

    protected <T> List<T> selectList(String statement, Object parameter) throws Exception {
        List<T> list = null;
        try {
            list = sqlSession.selectList(statement, parameter);

        } catch (Exception e) {
            throw e;
        }
        return list;
    }
}
