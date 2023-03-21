package com.wheogus.house.service;

import com.wheogus.house.dao.CalendarDao;
import com.wheogus.house.dao.MinusDao;
import com.wheogus.house.dao.UserDao;
import com.wheogus.house.domain.CalendarDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AccountServiceImplTest extends TestCase {

    @Autowired
    MinusDao minusDao;

    @Autowired
    UserDao userDao;

    @Autowired
    CalendarDao calendarDao;
    public void testTotal() {

    }

    @Test
    public void testFindAll() throws Exception{
        List<CalendarDto> list = calendarDao.findAll();
//        assertTrue(list.size()==7);
        System.out.println("list = " + list);
    }

    public void testFindById() {
    }

    public void testTestTotal() {
    }

    public void testTestFindAll() {
    }

    public void testTestFindById() {
    }
}