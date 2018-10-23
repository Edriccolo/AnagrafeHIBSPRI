package net.agmsolutions.university.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.agmsolutions.university.businesslogic.AddExam;
import net.agmsolutions.university.businesslogic.ApproveReservation;
import net.agmsolutions.university.businesslogic.DeleteExam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfessorController {

 @RequestMapping(value = {"/scegliCorso"}, method = RequestMethod.POST)
    public String ChooseCourse(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.setAttribute("SelectMethod", "ProfCorsi");

        int Id = (int) session.getAttribute("Id");

        if (Id == 0) {
            return "index";
        } else {
            return "select";
        }
    }    
    
    @RequestMapping(value = {"/ExamInserted"}, method = RequestMethod.POST)
    public String InsertExam(HttpServletRequest request,@RequestParam("idCorsi") String Esame,@RequestParam("DataEsame") String DataEsame) {

        Integer IdEsame = Integer.parseInt(Esame);

        AddExam adding = new AddExam();
        int execute = adding.InsertExam(IdEsame, DataEsame);

        if (execute == 1) {
           return "success";
        }
        return "error";
    }    
    @RequestMapping(value = {"/eliminaScelta"}, method = RequestMethod.POST)
        public String ChooseExam(HttpServletRequest request) {
            HttpSession session = request.getSession();

            session.setAttribute("SelectMethod", "ProfAppelli");

            int Id = (int) session.getAttribute("Id");

            if (Id == 0) {
                return "index";
            } else {
                return "select";
            }
        }    
        
        @RequestMapping(value = {"/ExamDeleted"}, method = RequestMethod.POST)
    public String DeleteExam(HttpServletRequest request,@RequestParam("idAppelli") String Esame) {

        Integer IdEsame = Integer.parseInt(Esame);

         DeleteExam exams = new DeleteExam();
        boolean execute = exams.DeleteExam(IdEsame);

        if (execute) {
            return "success";
        }
        return "error";
    }    
    
     @RequestMapping(value = {"/prenotazioni"}, method = RequestMethod.POST)
    public String readReserv(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int Id = (int) session.getAttribute("Id");

        if (Id == 0) {
            return "index";
        } else {
            return "prenotazioni";
        }
    }
    
    @RequestMapping(value = {"/cercaStudente"}, method = RequestMethod.POST)
        public String ChoosebyStudent(HttpServletRequest request) {
            HttpSession session = request.getSession();

            session.setAttribute("SelectMethod", "ProfPrenot");

            int Id = (int) session.getAttribute("Id");

            if (Id == 0) {
                return "index";
            } else {
                return "select";
            }
        }    
        
         @RequestMapping(value = {"/mettiVoto"}, method = RequestMethod.POST)
    public String ProcessVote (HttpServletRequest request,@RequestParam("idReserv") String prenotazione,@RequestParam("Vote") String Vote) {

        int prenotazioneInt = Integer.parseInt(prenotazione);
        int voteInt = Integer.parseInt(Vote);

        ApproveReservation vote = new ApproveReservation();

        int execute = vote.processVote(prenotazioneInt, voteInt);

        if (execute==1) {
            return "success";
        }
        return "error";
    }    
}
