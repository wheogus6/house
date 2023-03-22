package com.wheogus.house.service;


import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;
import com.wheogus.house.domain.PlusDto;
import com.wheogus.house.domain.UserDto;

import java.util.List;

public interface AccountService {

    UserDto total(String id);

    List<CalendarDto> findAll() throws Exception;

    MinusDto findById(String mid) throws Exception;


    List<MinusDto> MinusContent(String md)throws Exception;

    String findDay(String week) throws Exception;

    Integer selectMinus(String mid) throws Exception;

    List<PlusDto> PlusContent(String pd)throws Exception;

    int deletePlus(Integer pno, String id)   throws Exception;



    int updatePlus(PlusDto plusDto) throws Exception;

    Integer selectTotal(String id) throws Exception;

    int insertMinus(MinusDto minusDto);

    int deleteMinus(Integer mno, String id)   throws Exception;


    int updateMinus(MinusDto minusDto) throws Exception;

    Integer selectPlus(String pid) throws Exception;

    int insertPlus(PlusDto plusDto);


}
