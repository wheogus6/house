package com.wheogus.house.service;

import com.wheogus.house.dao.CalendarDao;
import com.wheogus.house.dao.MinusDao;
import com.wheogus.house.dao.UserDao;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinusServiceImplTest extends TestCase {

    @Autowired
    MinusDao minusDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CalendarDao calendarDao;
    public void testTotal() {

    }

    public void testFindAll() {
    }

    public void testFindById() {
    }
}