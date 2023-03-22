package com.wheogus.house.service;

import com.wheogus.house.dao.CalendarDao;
import com.wheogus.house.dao.MinusDao;
import com.wheogus.house.dao.PlusDao;
import com.wheogus.house.dao.UserDao;
import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;

import com.wheogus.house.domain.PlusDto;
import com.wheogus.house.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
   MinusDao minusDao;
   @Autowired
   UserDao userDao;
   @Autowired
   PlusDao plusDao;
   @Autowired
   CalendarDao calendarDao;

   @Override
   public UserDto total(String id) {
       return userDao.selectUser(id);
   }


    //캘린더 관련
   @Override
   public List<CalendarDto> findAll() throws Exception {
       return calendarDao.findAll();
   }
    @Override
    public String findDay(String week) {
        return calendarDao.findDay(week);
    }




    //마이너스 관련
    @Override
    public Integer selectMinus(String id) throws Exception {
        return minusDao.selectMinus(id);
    }
    @Override
    public MinusDto findById(String id) throws Exception {
        return minusDao.findById(id);
    }
    @Override
    public List<MinusDto> MinusContent(String d)throws Exception {
        return minusDao.minusContent(d);
    }
    @Override
    public int insertMinus(MinusDto minusDto) {
       return minusDao.insertMinus(minusDto);
    }
    @Override
    public int deleteMinus(Integer mno, String id) throws Exception {
        return minusDao.deleteMinus(mno, id);
    }
    @Override
    public int updateMinus(MinusDto minusDto) throws Exception {
        return minusDao.updateMinus(minusDto);
    }



    //플러스 관련
    @Override
    public Integer selectPlus(String id) throws Exception {
        return plusDao.selectPlus(id);
    }
    @Override
    public List<PlusDto> PlusContent(String d)throws Exception {
        return plusDao.plusContent(d);
    }
    @Override
    public int insertPlus(PlusDto plusDto) {
        return plusDao.insertPlus(plusDto);
    }
    @Override
    public int deletePlus(Integer pno, String id) throws Exception {
        return plusDao.deletePlus(pno, id);
    }
    @Override
    public int updatePlus(PlusDto plusDto) throws Exception {
        return plusDao.updatePlus(plusDto);
    }


    // 유저관련
    @Override
    public Integer selectTotal(String id) throws Exception {
        return userDao.selectTotal(id);
    }
}
