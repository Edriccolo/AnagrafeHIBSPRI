package net.agmsolutions.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.agmsolutions.university.businesslogic.ExamReservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping(value = {"/appelli"}, method = RequestMethod.POST)
    public String readAppelli(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int Id = (int) session.getAttribute("Id");

        if (Id == 0) {
            return "index";
        } else {
            return "appelli";
        }
    }

    @RequestMapping(value = {"/scegliAppello"}, method = RequestMethod.POST)
    public String ChooseAppello(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.setAttribute("SelectMethod", "StudAppelli");

        int Id = (int) session.getAttribute("Id");

        if (Id == 0) {
            return "index";
        } else {
            return "select";
        }
    }

    @RequestMapping(value = {"/setReservation"}, method = RequestMethod.POST)
    public String Insert(HttpServletRequest request,@RequestParam("idStudExam") Integer examInt) {
        HttpSession session = request.getSession();

        int Id = (int) session.getAttribute("Id");

        if (Id == 0) {
            return "index";
        } else {
            
            ExamReservation insertion = new ExamReservation();
            int execute = insertion.InsertReserv(examInt, Id);

            if (execute == 1) {
                return "success";
            }
        }
        return "error";
    }
}
