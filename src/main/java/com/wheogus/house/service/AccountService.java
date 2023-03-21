package com.wheogus.house.service;


import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;
import com.wheogus.house.domain.UserDto;

import java.util.List;

public interface AccountService {

    UserDto total(String id);

    List<CalendarDto> findAll() throws Exception;

    MinusDto findById(String mid) throws Exception;


    Integer selectMinus(String mid) throws Exception;

    Integer selectTotal(String id) throws Exception;

    Integer selectPlus(String pid) throws Exception;
}
