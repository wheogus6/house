package com.wheogus.house.service;

import com.wheogus.house.dao.CalendarDao;
import com.wheogus.house.dao.MinusDao;
import com.wheogus.house.dao.PlusDao;
import com.wheogus.house.dao.UserDao;
import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;

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

   @Override
   public List<CalendarDto> findAll() throws Exception {
       return calendarDao.findAll();
   }

    @Override
    public MinusDto findById(String mid) throws Exception {
        return minusDao.findById(mid);

    }

    @Override
    public Integer selectMinus(String mid) throws Exception {
        return minusDao.selectMinus(mid);
    }
    @Override
    public Integer selectTotal(String id) throws Exception {
       return userDao.selectTotal(id);
    }
    @Override
    public Integer selectPlus(String pid) throws Exception {
       return plusDao.selectPlus(pid);
    }
}
