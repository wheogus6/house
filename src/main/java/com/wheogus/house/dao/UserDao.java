package com.wheogus.house.dao;


import com.wheogus.house.domain.UserDto;


public interface UserDao {

    int deleteUser(Integer id);


    UserDto selectUser(String id);

    int insertUser(UserDto userDto);

    int updateUser(UserDto userDto);




    UserDto userTotal(String id);
}
