package net.agmsolutions.university.businesslogic;

import java.util.ArrayList;
import java.util.List;
import net.agmsolutions.university.dao.accomplishedexams.AccomExamDAOMethods;
import net.agmsolutions.university.dao.reservations.ReservationsDAOMethods;
import net.agmsolutions.university.entity.Appelli;
import net.agmsolutions.university.entity.Corsi;
import net.agmsolutions.university.entity.Esamiconseguiti;
import net.agmsolutions.university.entity.Prenotazioni;
import net.agmsolutions.university.entity.Studenti;

public class ApproveReservation {

    public List<Prenotazioni> GetReservByStud(String NomeStud) {
        List<Prenotazioni> prenotazioniStud = new ArrayList<>();
        List<Prenotazioni> prenotazioni = new ArrayList<>();
        ReservationsDAOMethods reserv = new ReservationsDAOMethods();
        prenotazioni = reserv.findAll();
        Prenotazioni[] prenotArray = prenotazioni.toArray(new Prenotazioni[prenotazioni.size()]);
        for (int i = 0; i < prenotazioni.size(); i++) {
            if (prenotArray[i].getStudentiIdstudenti().getNome().equals(NomeStud)) {
                prenotazioniStud.add(prenotArray[i]);
            }
        }
        return prenotazioniStud;
    }
    
    public int processVote(int idPrenotazione,Integer Vote){
        AccomExamDAOMethods examMethod= new AccomExamDAOMethods();
        Esamiconseguiti exam=new Esamiconseguiti();
        ReservationsDAOMethods reserv = new ReservationsDAOMethods();
        Prenotazioni prenotazione = reserv.findById(idPrenotazione);
        Appelli appello=prenotazione.getAppelliIdappelli();
        Corsi corso=appello.getCorsiIdcorsi();
        Studenti studente=prenotazione.getStudentiIdstudenti();
        exam.setCorsiIdcorsi(corso);
        exam.setVoto(Vote);
        exam.setStudentiIdstudenti(studente);
        examMethod.persist(exam);
        reserv.delete(idPrenotazione);
        return 1;
    }
}
