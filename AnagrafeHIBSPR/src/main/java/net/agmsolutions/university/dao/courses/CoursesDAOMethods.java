package net.agmsolutions.university.dao.courses;


import java.util.List;
import net.agmsolutions.university.entity.Corsi;
import net.agmsolutions.university.entity.Professori;


public class CoursesDAOMethods {
    private static CoursesDAO coursesdao;

    public CoursesDAOMethods() {
        coursesdao = new CoursesDAO();
    }
    
    public void persist(Corsi entity) {
		coursesdao.openCurrentSessionwithTransaction();
		coursesdao.persist(entity);
		coursesdao.closeCurrentSessionwithTransaction();
	}

    public void update(Corsi entity) {
		coursesdao.openCurrentSessionwithTransaction();
		coursesdao.update(entity);
		coursesdao.closeCurrentSessionwithTransaction();
	}

	public Corsi findById(int id) {
		coursesdao.openCurrentSession();
		Corsi corsii = coursesdao.findById(id);
		coursesdao.closeCurrentSession();
		return corsii;
	}
        public List<Corsi> findByProfId(Professori professore) {
                coursesdao.openCurrentSession();
                List<Corsi> corsii = coursesdao.findByProfId(professore);
		coursesdao.closeCurrentSession();
		return corsii;
	}
        
    public List<Corsi> findAll() {
		coursesdao.openCurrentSession();
		List<Corsi> corsii = coursesdao.findAll();
		coursesdao.closeCurrentSession();
		return corsii;
	}
    
    public void delete(int id) {
		coursesdao.openCurrentSessionwithTransaction();
		Corsi corsii = coursesdao.findById(id);
		coursesdao.delete(corsii);
		coursesdao.closeCurrentSessionwithTransaction();
	}
    public CoursesDAO CoursesDAO() {
		return coursesdao;
	}
}
