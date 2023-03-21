package com.wheogus.house.dao;


import com.wheogus.house.domain.MinusDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MinusDaoImpl implements MinusDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.wheogus.house.dao.MinusMapper.";


    @Override
    public MinusDto findById(String mid) throws Exception {
        return session.selectOne(namespace + "findById", mid);
    }

    @Override
    public MinusDto select(String md) throws Exception{
        return session.selectOne(namespace + "select", md);
    }

    @Override
    public Integer selectMinus(String mid) throws Exception {
        return session.selectOne(namespace + "selectMinus", mid);
    }



}
