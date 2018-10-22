package net.agmsolutions.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

    @RequestMapping(value = {"/appelli"}, method = RequestMethod.POST)
    public String readAppelli(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int Id = (int) session.getAttribute("Id");

        if (Id==0) {
            return "index";
        } else {
            return "appelli";
        }
    }
}
