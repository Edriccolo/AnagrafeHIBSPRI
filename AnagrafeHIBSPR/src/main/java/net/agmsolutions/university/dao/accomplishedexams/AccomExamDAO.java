package net.agmsolutions.university.dao.accomplishedexams;


import java.util.List;
import net.agmsolutions.university.entity.Esamiconseguiti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AccomExamDAO implements AccomExamDAOInterface<Esamiconseguiti, String>{

    private Session currentSession;
    private Transaction currentTransaction;
    
    @Override
    public void persist(Esamiconseguiti entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Esamiconseguiti entity) {
    getCurrentSession().update(entity);   
    }

    @Override
    public Esamiconseguiti findById(int id) {
        Esamiconseguiti corso = (Esamiconseguiti) getCurrentSession().get(Esamiconseguiti.class, id);
        return corso;
    }

    @Override
    public void delete(Esamiconseguiti entity) {
        getCurrentSession().delete(entity);
    }

      
    
    @Override
    public List<Esamiconseguiti> findAll() {
        List<Esamiconseguiti> corsi = (List<Esamiconseguiti>) getCurrentSession().createQuery("from Esamiconseguiti").list();
	return corsi;    
    }

    @Override
    public void deleteAll() {
        List<Esamiconseguiti> entityList = findAll();
		for (Esamiconseguiti entity : entityList) {
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
