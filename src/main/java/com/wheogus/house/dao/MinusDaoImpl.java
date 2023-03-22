package com.wheogus.house.dao;


import com.wheogus.house.domain.MinusDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MinusDaoImpl implements MinusDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.wheogus.house.dao.MinusMapper.";


    @Override
    public MinusDto findById(String id) throws Exception {
        return session.selectOne(namespace + "findById", id);
    }

    @Override
    public List<MinusDto> minusContent(String d) {
        return session.selectList(namespace + "minusContent", d);
    }


    @Override
    public Integer selectMinus(String id) throws Exception {
        return session.selectOne(namespace + "selectMinus", id);
    }

    @Override
    public int insertMinus(MinusDto minusDto) {
        return session.insert(namespace + "insertMinus", minusDto);
    }

    @Override
    public int deleteMinus(Integer mno, String id) throws Exception{
        Map map = new HashMap();
        map.put("mno", mno);
        map.put("id", id);
        return session.delete(namespace + "deleteMinus", map);
    }

    @Override
    public int updateMinus(MinusDto minusDto)throws Exception {

        return session.update(namespace + "updateMinus", minusDto);
    }
}
