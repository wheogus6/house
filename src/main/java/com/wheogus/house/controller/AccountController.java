package com.wheogus.house.controller;


import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.domain.MinusDto;
import com.wheogus.house.domain.PlusDto;
import com.wheogus.house.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/calendar")
public class AccountController {

    @Autowired
    AccountService accountService;


    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id")!=null;
        // id가 null이 아니라면 true -> id값이 있다면 true
    }

    @GetMapping("/list")
    public String listForm(Model model, HttpServletRequest request, HttpSession session) {
        if (!loginCheck(request)) {
            return "redirect:/login/in?toURL=" + request.getRequestURL();
        }
        try {
            // 총액 구하기
            String id = (String)session.getAttribute("id");
            Integer total = accountService.selectTotal(id);
            Integer minus = accountService.selectMinus(id);
            Integer plus = accountService.selectPlus(id);
            Integer userDto = total-minus+plus;
            model.addAttribute("userDto", userDto);

            // 날짜 가져오기
            List<CalendarDto> calendarDto = accountService.findAll();
            System.out.println("calendarDto = " + calendarDto);
            model.addAttribute("calendarDto", calendarDto);

            // 마이너스 플러스 총액 가져오기
            List<MinusDto> minusDto = accountService.dayMinus();
            System.out.println("minusDto = " + minusDto);
            model.addAttribute("minusDto", minusDto);

            List<PlusDto> plusDto = accountService.dayPlus();
            System.out.println("plsDto = " + plusDto);
            model.addAttribute("plusDto", plusDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "calendar";
    }




    @GetMapping("/detail")
    public String detailDay(String week, Model model){
       try{
           String d = accountService.findDay(week);
           model.addAttribute("d", d);

           // 날짜별 플러스, 마이너스 값들 가져오기
           List<MinusDto> minusDto = accountService.MinusContent(week);
           System.out.println("minusDto = " + minusDto);
           List<PlusDto> plusDto = accountService.PlusContent(week);
           System.out.println("plusDto = " + plusDto);

           model.addAttribute("minusDto", minusDto);
           model.addAttribute("plusDto", plusDto);

       }
       catch (Exception e){e.printStackTrace();
    }
        return "detail";
    }

    // 지출 등록
    @PostMapping("/writeMinus")
    public String writeMinus(HttpSession session, MinusDto minusDto) throws Exception{
        String id = (String)session.getAttribute("id");
        minusDto.setId(id);
        accountService.insertMinus(minusDto);

      return "redirect:/calendar/detail?week=" + minusDto.getD();
    }

    //입금 등록
    @PostMapping("/writePlus")
    public String writePlus(HttpSession session, PlusDto plusDto) throws Exception{
        String id = (String)session.getAttribute("id");
        plusDto.setId(id);
        accountService.insertPlus(plusDto);

        return "redirect:/calendar/detail?week=" + plusDto.getD();
    }

    //지출내역 삭제
    @PostMapping("/deleteMinus")
    public String deleteMinus(String d, Integer mno, HttpSession session) throws Exception{
        String id = (String)session.getAttribute("id");
        System.out.println("mno = " + mno);
        String day = accountService.findDay(d);
        accountService.deleteMinus(mno, id);
        return "redirect:/calendar/detail?week=" + day;
    }

    //입금내역 삭제
    @PostMapping("/deletePlus")
    public String deletePlus(String d, Integer pno, HttpSession session)throws Exception {
        String id = (String)session.getAttribute("id");
        System.out.println("pno = " + pno);
        String day = accountService.findDay(d);
        accountService.deletePlus(pno, id);
        return "redirect:/calendar/detail?week=" + day;
    }

    //지출내역 업데이트
    @PostMapping("/updateMinus")
    public String updateM(Integer mno, HttpSession session, MinusDto minusDto) throws Exception {
        String id = (String)session.getAttribute("id");
        minusDto.setId(id);
        minusDto.setMno(mno);
        accountService.updateMinus(minusDto);
        return "redirect:/calendar/detail?week=" + minusDto.getD();
    }


    //입금내역 업데이트
    @PostMapping("/updatePlus")
    public String updateP(Integer pno, HttpSession session, PlusDto plusDto) throws Exception {
        String id = (String)session.getAttribute("id");
        plusDto.setId(id);
        plusDto.setPno(pno);
        accountService.updatePlus(plusDto);
        return "redirect:/calendar/detail?week=" + plusDto.getD();
    }


}
