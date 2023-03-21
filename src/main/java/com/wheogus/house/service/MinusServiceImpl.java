package com.wheogus.house.service;

import com.wheogus.house.dao.CalendarDao;
import com.wheogus.house.dao.MinusDao;
import com.wheogus.house.dao.UserDao;
import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;

import com.wheogus.house.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinusServiceImpl implements MinusService{

   @Autowired
   MinusDao minusDao;

   @Autowired
   UserDao userDao;

   @Autowired
   CalendarDao calendarDao;
   @Override
   public UserDto total(String id) {
       return userDao.userTotal(id);
   }

   @Override
   public List<CalendarDto> findAll() throws Exception {
       return calendarDao.findAll();
   }

//    @Override
//    public List<BoardDto> getList() throws Exception {
//        return boardDao.selectAll();
//    }

//    @Override
//    public int modify(BoardDto dto) throws Exception {
//        return boardDao.update(dto);
//    }
//
//    @Override
//    public List<BoardDto> getSearchSelectPage(SearchCondition sc) throws Exception{
//        return boardDao.searchSelectPage(sc);
//    }
//
//    @Override
//    public int getSearchResultCnt(SearchCondition sc) throws Exception {
//        return boardDao.searchResultCnt(sc);
//    }

    @Override
    public MinusDto findById(String mid) throws Exception {
        MinusDto minus = minusDao.findById(mid);

        return minus;
    }

//    @Override
//    public List<BoardDto> selectPage(Map map) throws Exception {
//        return boardDao.selectPage(map);
//    }




}
