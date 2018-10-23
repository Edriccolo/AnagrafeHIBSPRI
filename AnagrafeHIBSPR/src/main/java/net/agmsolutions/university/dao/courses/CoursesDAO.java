package net.agmsolutions.university.dao.courses;


import java.util.List;
import net.agmsolutions.university.entity.Corsi;
import net.agmsolutions.university.entity.Professori;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CoursesDAO implements CoursesDAOInterface<Corsi, String>{

    private SessionFactory sessionFactory;
    private Session currentSession;
    private Transaction currentTransaction;
    
    @Override
    public void persist(Corsi entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Corsi entity) {
    getCurrentSession().update(entity);   
    }

    @Override
    public Corsi findById(int id) {
        Corsi corso = (Corsi) getCurrentSession().get(Corsi.class, id);
        return corso;
    }

    @Override
    public void delete(Corsi entity) {
        getCurrentSession().delete(entity);
    }

     public List<Corsi> findByProfId(Professori prof) {
        List<Corsi> corsi = (List<Corsi>) getCurrentSession().createQuery("SELECT c FROM Corsi c WHERE c.professoriIdprofessori = :idProfessori").setParameter("idProfessori",prof).list();
	return corsi;    
    }
    
    
    @Override
    public List<Corsi> findAll() {
        List<Corsi> corsi = (List<Corsi>) getCurrentSession().createQuery("from Corsi").list();
	return corsi;    
    }

    @Override
    public void deleteAll() {
        List<Corsi> entityList = findAll();
		for (Corsi entity : entityList) {
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
                sessionFactory.close();
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
                sessionFactory.close();
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
