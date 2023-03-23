package com.wheogus.house.dao;




import com.wheogus.house.domain.MinusDto;

import java.util.Date;
import java.util.List;

public interface MinusDao {



    MinusDto findById(String id) throws Exception;


    List<MinusDto> minusContent(String d) throws Exception;



    Integer selectMinus(String id) throws Exception;

    abstract int insertMinus(MinusDto minusDto);

    int deleteMinus(Integer mno, String id) throws Exception;


    int updateMinus(MinusDto minusDto)throws Exception;


    List<MinusDto> dayMinus()throws Exception;
}
