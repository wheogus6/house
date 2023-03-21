package com.wheogus.house.dao;


import com.wheogus.house.domain.PlusDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PlusDaoImpl implements PlusDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.wheogus.house.dao.PlusMapper.";


    @Override
    public PlusDto findById(String pid) throws Exception {
        return session.selectOne(namespace + "findById", pid);
    }

    @Override
    public PlusDto select(String pd) throws Exception{
        return session.selectOne(namespace + "select", pd);
    }

    @Override
    public Integer selectPlus(String pid) throws Exception {
        return session.selectOne(namespace + "selectPlus", pid);
    }



}
