package net.agmsolutions.university.dao.exams;


import java.util.List;
import net.agmsolutions.university.entity.Appelli;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ExamsDAO implements ExamsDAOInterface<Appelli, String>{

    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;
    
    @Override
    public void persist(Appelli entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Appelli entity) {
    getCurrentSession().update(entity);   
    }

    @Override
    public Appelli findById(int id) {
        Appelli appello = (Appelli) getCurrentSession().get(Appelli.class, id);
        return appello;
    }

    @Override
    public void delete(Appelli entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Appelli> findAll() {
        List<Appelli> appello = (List<Appelli>) getCurrentSession().createQuery("FROM Appelli").list();
	return appello;    
    }
    public List<Appelli> findAllbyid(String id) {
        List<Appelli> appello = (List<Appelli>) getCurrentSession().createQuery("SELECT a FROM Appelli a WHERE a.idappelli = :idappelli").setParameter("idappelli",id).list();
	return appello;    
    }
    @Override
    public void deleteAll(String id) {
        List<Appelli> entityList = findAll();
		for (Appelli entity : entityList) {
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
               sessionFactory.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
                currentSession.close(); 
               sessionFactory.close();
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
