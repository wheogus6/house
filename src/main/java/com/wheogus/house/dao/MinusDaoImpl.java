package com.wheogus.house.dao;


import com.wheogus.house.domain.MinusDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;


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
    public MinusDto MinusTotal(Date md) throws Exception{
        return session.selectOne(namespace + "selectMinus", md);
    }


//    @Override
//    public int selectMinus() throws Exception {
//        Map map = new HashMap();
//        map.put("num", num);
//        map.put("writer", writer);
//        return session.delete(namespace + "delete", map);   //입력값을 받기위해 id 뒤에 반드시 map 입력, 얘는 insert와 다르게 생성자가 없어 map으로 입력받는다.
//    }
//
//
//
//    @Override
//    public List<BoardDto> selectAll() throws Exception {
//        return session.selectList(namespace + "selectAll");
//    }
//
//    @Override
//    public int insert(BoardDto dto) throws Exception {
//        return session.insert(namespace + "insert", dto);  //매개변수 dto를 반드시 입력 해야함 , 그래야 dto값을 넘겨줄 수 있다.
//    }
//
//    @Override
//    public int update(BoardDto dto) throws Exception {
//        return session.update(namespace + "update", dto);
//    }
//
//
//
//
//
//
//    @Override
//    public int updateCommentCnt(Integer num, int cnt) {
//        Map map = new HashMap();
//        map.put("cnt", cnt);
//        map.put("num", num);
//        return session.update(namespace + "updateCommentCnt", map);
//    }
}
