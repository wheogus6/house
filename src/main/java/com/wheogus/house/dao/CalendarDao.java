package com.wheogus.house.dao;

import com.wheogus.house.domain.CalendarDto;

import java.util.List;

public interface CalendarDao {
    List<CalendarDto> findAll() throws Exception;
}
