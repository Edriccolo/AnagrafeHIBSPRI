package net.agmsolutions.university.businesslogic;

import net.agmsolutions.university.dao.exams.ExamsDAOMethods;
import net.agmsolutions.university.dao.reservations.ReservationsDAOMethods;
import net.agmsolutions.university.dao.students.StudentsDAOMethods;
import net.agmsolutions.university.entity.Appelli;
import net.agmsolutions.university.entity.Prenotazioni;
import net.agmsolutions.university.entity.Studenti;


public class ExamReservation {
    public int InsertReserv(Integer idExam, int idStud) {
        ReservationsDAOMethods insert=new ReservationsDAOMethods();
        Prenotazioni prenotazione=new Prenotazioni();
        ExamsDAOMethods find=new ExamsDAOMethods();
        Appelli appello=find.findById(idExam);
        prenotazione.setAppelliIdappelli(appello);
        StudentsDAOMethods stud=new StudentsDAOMethods();
        Studenti studente=stud.findById(idStud);
        prenotazione.setStudentiIdstudenti(studente);
        insert.persist(prenotazione);
        return 1;
    }
}
