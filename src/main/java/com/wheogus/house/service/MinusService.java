package com.wheogus.house.service;


import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;
import com.wheogus.house.domain.UserDto;

import java.util.List;

public interface MinusService {

    UserDto total(String id);

    List<CalendarDto> findAll() throws Exception;

    MinusDto findById(String mid) throws Exception;
}
