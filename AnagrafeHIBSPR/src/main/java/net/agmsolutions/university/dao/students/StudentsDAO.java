package net.agmsolutions.university.dao.students;

import java.util.List;
import net.agmsolutions.university.entity.Studenti;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class StudentsDAO implements StudentsDAOinterface<Studenti, String>{

    private Session currentSession;
    private Transaction currentTransaction;
    
    @Override
    public void persist(Studenti entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Studenti entity) {
    getCurrentSession().update(entity);   
    }

    @Override
    public Studenti findById(int id) {
        Studenti stud = (Studenti) getCurrentSession().get(Studenti.class, id);
        return stud;
    }

    @Override
    public void delete(Studenti entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Studenti> findAll() {
        List<Studenti> stud = (List<Studenti>) getCurrentSession().createQuery("from Studenti").list();
	return stud;    
    }

    @Override
    public void deleteAll() {
        List<Studenti> entityList = findAll();
		for (Studenti entity : entityList) {
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
