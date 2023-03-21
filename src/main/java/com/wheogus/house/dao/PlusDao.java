package com.wheogus.house.dao;

import com.wheogus.house.domain.PlusDto;

public interface PlusDao {
    PlusDto findById(String pid) throws Exception;

    PlusDto select(String pd) throws Exception;

    Integer selectPlus(String pid) throws Exception;
}
