package com.wheogus.house.dao;




import com.wheogus.house.domain.MinusDto;

import java.util.Date;

public interface MinusDao {



    MinusDto findById(String mid) throws Exception;

    MinusDto MinusTotal(Date md) throws Exception;
}
