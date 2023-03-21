package com.wheogus.house.dao;




import com.wheogus.house.domain.MinusDto;

import java.util.Date;

public interface MinusDao {



    MinusDto findById(String mid) throws Exception;



    MinusDto select(String md) throws Exception;

    Integer selectMinus(String mid) throws Exception;
}
