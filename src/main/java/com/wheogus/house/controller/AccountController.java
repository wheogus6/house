package com.wheogus.house.controller;


import com.wheogus.house.domain.CalendarDto;
import com.wheogus.house.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
            String id = (String)session.getAttribute("id");
            Integer total = accountService.selectTotal(id);
            Integer minus = accountService.selectMinus(id);
            Integer plus = accountService.selectPlus(id);

            System.out.println("total = " + total);
            System.out.println("minus = " + minus);
            System.out.println("plus = " + plus);

            Integer userDto = total-minus+plus;

            model.addAttribute("userDto", userDto);


            List<CalendarDto> calendarDto = accountService.findAll();
            System.out.println("calendarDto = " + calendarDto);
            model.addAttribute("calendarDto", calendarDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "calendar";
    }

    @GetMapping("/detail")
    public String detailDay(){
        return "detail";
    }



//    @GetMapping("/read")
//    public String read(Integer num, Integer page, Integer pageSize, Model model) {
//        try {
//            BoardDto boardDto = boardService.read(num);
//            model.addAttribute(boardDto);
//            model.addAttribute("page", page);
//            model.addAttribute("pageSize", pageSize);
//
//            //댓글조회
//            List<CommentDto> comment = null;
//            comment = commentService.getList(num);
//            model.addAttribute("comment", comment);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "board";
//    }
//
//    @GetMapping("/write")
//    public String write(Model model) {
//        model.addAttribute("mode", "new");
//        return "/board";
//    }
//
//    @PostMapping("/write")
//    public String write(BoardDto boardDto, HttpSession session, Model model, RedirectAttributes ratter) {
//        String writer = (String) session.getAttribute("id");  //형변환 주의
//        boardDto.setWriter(writer);
//
//        try {
//            int rowCnt = boardService.insert(boardDto);
//            if (rowCnt != 1) {
//                throw new Exception("write falid");
//            }
//            ratter.addFlashAttribute("msg", "WRT_OK");
//            return "redirect:/board/list";
//        } catch (Exception e) {
//           e.printStackTrace();
//            model.addAttribute(boardDto);
//            model.addAttribute("msg", "WRT_ERR");
//            return "board";
//        }
//    }
//
//    @PostMapping("/remove")
//    public String remove(Integer num, Integer page, Integer pageSize, Model model, HttpSession session, RedirectAttributes ratter) {
//        String writer = (String) session.getAttribute("id"); //LoginController 에서 set함.
//        try {
//            model.addAttribute("page", page);
//            model.addAttribute("pageSize", pageSize);
//            commentService.deleteBoardComment(num);
//            int rowCnt = boardService.remove(num, writer);
//
//            if (rowCnt != 1){
//                throw new Exception("remove Error");}            //나중에 괄호 수정
//            ratter.addFlashAttribute("msg", "DEL_OK");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            ratter.addFlashAttribute("msg", "DEL_ERR");
//        }
//        return "redirect:/board/list";
//    }
//
//    @PostMapping("/modify")
//    public String modify(BoardDto boardDto, HttpSession session, Model model, RedirectAttributes ratter) {
//        String writer = (String) session.getAttribute("id");
//        boardDto.setWriter(writer);
//
//        try {
//            int rowCnt = boardService.modify(boardDto);
//            if (rowCnt != 1) {
//                throw new Exception("Modify failed");
//            }
//            ratter.addFlashAttribute("msg", "MOD_OK");
//            return "redirect:/board/list";
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute(boardDto);
//            model.addAttribute("msg", "MOD_ERR");
//            return "board";
//        }
//    }

}
