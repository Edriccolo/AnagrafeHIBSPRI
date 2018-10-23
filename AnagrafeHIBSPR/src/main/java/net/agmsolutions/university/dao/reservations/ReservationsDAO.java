package net.agmsolutions.university.dao.reservations;

import java.util.List;
import net.agmsolutions.university.entity.Prenotazioni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ReservationsDAO implements ReservationsDAOInterface<Prenotazioni, String>{

    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;
    
    @Override
    public void persist(Prenotazioni entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Prenotazioni entity) {
    getCurrentSession().update(entity);   
    }

    @Override
    public Prenotazioni findById(int id) {
        Prenotazioni prenotazione = (Prenotazioni) getCurrentSession().get(Prenotazioni.class, id);
        return prenotazione;
    }

    @Override
    public void delete(Prenotazioni entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Prenotazioni> findAll() {
        List<Prenotazioni> prenotazioni = (List<Prenotazioni>) getCurrentSession().createQuery("from Prenotazioni").list();
	return prenotazioni;    
    }

    @Override
    public void deleteAll() {
        List<Prenotazioni> entityList = findAll();
		for (Prenotazioni entity : entityList) {
			delete(entity);
		}
    }
    public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(builder);
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
}
