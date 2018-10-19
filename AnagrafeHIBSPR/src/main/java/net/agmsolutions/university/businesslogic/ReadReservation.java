package net.agmsolutions.university.businesslogic;

import java.util.List;
import net.agmsolutions.university.dao.reservations.ReservationsDAOMethods;
import net.agmsolutions.university.entity.Prenotazioni;

public class ReadReservation {
    public List<Prenotazioni> ReservList(){
        ReservationsDAOMethods reservations=new ReservationsDAOMethods();
        return reservations.findAll();
    }
}
