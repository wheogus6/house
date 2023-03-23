package com.wheogus.house.dao;


import com.wheogus.house.domain.PlusDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class PlusDaoImpl implements PlusDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.wheogus.house.dao.PlusMapper.";


    @Override
    public PlusDto findById(String id) throws Exception {
        return session.selectOne(namespace + "findById", id);
    }

    @Override
    public PlusDto select(String d) throws Exception{
        return session.selectOne(namespace + "select", d);
    }

    @Override
    public Integer selectPlus(String id) throws Exception {
        return session.selectOne(namespace + "selectPlus", id);
    }

    @Override
    public List<PlusDto> plusContent(String d) {
        return session.selectList(namespace + "plusContent", d);
    }

    @Override
    public int insertPlus(PlusDto plusDto) {
        return session.insert(namespace + "insertPlus", plusDto);
    }

    @Override
    public int deletePlus(Integer pno, String id) throws Exception{
        Map map = new HashMap();
        map.put("pno", pno);
        map.put("id", id);
        return session.delete(namespace + "deletePlus", map);
    }
    @Override
    public int updatePlus(PlusDto plusDto) throws Exception{
        return session.update(namespace + "updatePlus", plusDto);
    }

    @Override
    public List<PlusDto> dayPlus()throws Exception {
        return session.selectList(namespace + "dayPlus");
    }


}
