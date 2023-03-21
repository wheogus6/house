package com.wheogus.house.dao;

import com.wheogus.house.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.wheogus.house.dao.UserMapper.";


    @Override
    public int deleteUser(Integer id){
        Map map = new HashMap();
        map.put("id", id);
        return session.delete(namespace + "delete", map);
    }

    @Override
    public UserDto selectUser(String id){
        return session.selectOne(namespace + "select", id);  //잊자말고 id값 꼭 주기
    }
    @Override
    public int insertUser(UserDto userDto){
        return session.insert(namespace + "insert", userDto);
    }
    @Override
    public int updateUser(UserDto userDto){
        return session.update(namespace + "update", userDto);
    }

    @Override
    public Integer selectTotal(String id) throws Exception{
        return session.selectOne(namespace + "total", id);
    }
}
