package net.agmsolutions.university.dao.professors;

import java.util.List;
import net.agmsolutions.university.entity.Professori;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProfessorsDAO implements ProfessorsDAOinterface<Professori, String>{

    private Session currentSession;
    private Transaction currentTransaction;
    
    @Override
    public void persist(Professori entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Professori entity) {
    getCurrentSession().update(entity);   
    }

    @Override
    public Professori findById(int id) {
        Professori prof = (Professori) getCurrentSession().get(Professori.class, id);
        return prof;
    }

    @Override
    public void delete(Professori entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Professori> findAll() {
        List<Professori> prof = (List<Professori>) getCurrentSession().createQuery("from Professori").list();
	return prof;    
    }

    @Override
    public void deleteAll() {
        List<Professori> entityList = findAll();
		for (Professori entity : entityList) {
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
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder);
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
