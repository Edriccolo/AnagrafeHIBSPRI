package net.agmsolutions.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.agmsolutions.university.businesslogic.LoginProfessor;
import net.agmsolutions.university.businesslogic.LoginStudent;
import net.agmsolutions.university.entity.Professori;
import net.agmsolutions.university.entity.Studenti;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam("user") String user, @RequestParam("pwd") String pwd, @RequestParam("switch") String role) {
               
        HttpSession session=request.getSession();

        Studenti studenteCheck = null;
        Professori professoreCheck = null;

        switch (role) {
            case "studente":
                LoginStudent loginStud = new LoginStudent();
                studenteCheck = loginStud.CheckStud(user, pwd);
                break;
            case "professore":
                LoginProfessor loginProf = new LoginProfessor();
                professoreCheck = loginProf.CheckProf(user, pwd);
                break;
        }

        if (studenteCheck != null) {
            session.setAttribute("Name", user);
            session.setAttribute("Id", studenteCheck.getIdstudenti());
            session.setAttribute("Role", role);
        } else if (professoreCheck != null) {
            session.setAttribute("Name", user);
            session.setAttribute("Id", professoreCheck.getIdprofessori());
            session.setAttribute("Role", role);
        } else {
            session.setAttribute("Id", 0);
        }
        return "LoggedIn";
    }

   @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request) {
        
        HttpSession session=request.getSession();
        session.invalidate();
      
            return "logout";
        
    }

}
