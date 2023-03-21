package com.wheogus.house.dao;

import com.wheogus.house.domain.CalendarDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CalendarDaoImpl implements CalendarDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.wheogus.house.dao.CalendarMapper.";

    @Override
    public List<CalendarDto> findAll() throws Exception{
        return session.selectList(namespace + "selectAll");
    }


}
