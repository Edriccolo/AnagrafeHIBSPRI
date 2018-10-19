package net.agmsolutions.university.dao.reservations;


import java.util.List;
import net.agmsolutions.university.entity.Appelli;
import net.agmsolutions.university.entity.Prenotazioni;


public class ReservationsDAOMethods {
    private static ReservationsDAO reservationsdao;

    public ReservationsDAOMethods() {
        reservationsdao = new ReservationsDAO();
    }
    
    public void persist(Prenotazioni entity) {
		reservationsdao.openCurrentSessionwithTransaction();
		reservationsdao.persist(entity);
		reservationsdao.closeCurrentSessionwithTransaction();
	}

    public void update(Prenotazioni entity) {
		reservationsdao.openCurrentSessionwithTransaction();
		reservationsdao.update(entity);
		reservationsdao.closeCurrentSessionwithTransaction();
	}

	public Prenotazioni findById(int id) {
		reservationsdao.openCurrentSession();
		Prenotazioni prenotazione = reservationsdao.findById(id);
		reservationsdao.closeCurrentSession();
		return prenotazione;
	}
        
    public List<Prenotazioni> findAll() {
		reservationsdao.openCurrentSession();
		List<Prenotazioni> prenotazione = reservationsdao.findAll();
		reservationsdao.closeCurrentSession();
		return prenotazione;
	}
    
    public void delete(int id) {
		reservationsdao.openCurrentSessionwithTransaction();
		Prenotazioni prenotazioni = reservationsdao.findById(id);
		reservationsdao.delete(prenotazioni);
		reservationsdao.closeCurrentSessionwithTransaction();
	}
    public ReservationsDAO ReservationsDAO() {
		return reservationsdao;
	}
}
