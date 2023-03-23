package com.wheogus.house.dao;

import com.wheogus.house.domain.PlusDto;

import java.util.List;

public interface PlusDao {
    PlusDto findById(String pid) throws Exception;

    PlusDto select(String pd) throws Exception;

    Integer selectPlus(String pid) throws Exception;

    List<PlusDto> plusContent(String pd);

    int insertPlus(PlusDto plusDto);

    int deletePlus(Integer pno, String id) throws Exception;


    int updatePlus(PlusDto plusDto) throws Exception;

    List<PlusDto> dayPlus()throws Exception;
}
