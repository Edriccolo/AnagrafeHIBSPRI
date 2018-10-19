package net.agmsolutions.university.dao.exams;

import java.util.List;
import net.agmsolutions.university.entity.Appelli;


public class ExamsDAOMethods {
    private static ExamsDAO examsdao;

    public ExamsDAOMethods() {
        examsdao = new ExamsDAO();
    }
    
    public void persist(Appelli entity) {
		examsdao.openCurrentSessionwithTransaction();
		examsdao.persist(entity);
		examsdao.closeCurrentSessionwithTransaction();
	}

    public void update(Appelli entity) {
		examsdao.openCurrentSessionwithTransaction();
		examsdao.update(entity);
		examsdao.closeCurrentSessionwithTransaction();
	}

    public Appelli findById(int id) {
		examsdao.openCurrentSession();
		Appelli appello = examsdao.findById(id);
		examsdao.closeCurrentSession();
		return appello;
	}
    
	        
    public List<Appelli> findAll() {
		examsdao.openCurrentSession();
		List<Appelli> appelli = examsdao.findAll();
		examsdao.closeCurrentSession();
		return appelli;
	}
    
    public void delete(int id) {
		examsdao.openCurrentSessionwithTransaction();
		Appelli corsii = examsdao.findById(id);
		examsdao.delete(corsii);
		examsdao.closeCurrentSessionwithTransaction();
	}
    public ExamsDAO ExamsDAO() {
		return examsdao;
	}
}
