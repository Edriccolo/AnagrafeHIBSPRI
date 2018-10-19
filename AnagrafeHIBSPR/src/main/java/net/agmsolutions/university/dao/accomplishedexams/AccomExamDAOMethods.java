package net.agmsolutions.university.dao.accomplishedexams;


import java.util.List;
import net.agmsolutions.university.entity.Esamiconseguiti;


public class AccomExamDAOMethods {
    private static AccomExamDAO accomExamdao;

    public AccomExamDAOMethods() {
        accomExamdao = new AccomExamDAO();
    }
    
    public void persist(Esamiconseguiti entity) {
		accomExamdao.openCurrentSessionwithTransaction();
		accomExamdao.persist(entity);
		accomExamdao.closeCurrentSessionwithTransaction();
	}

    public void update(Esamiconseguiti entity) {
		accomExamdao.openCurrentSessionwithTransaction();
		accomExamdao.update(entity);
		accomExamdao.closeCurrentSessionwithTransaction();
	}

	public Esamiconseguiti findById(int id) {
		accomExamdao.openCurrentSession();
		Esamiconseguiti examm = accomExamdao.findById(id);
		accomExamdao.closeCurrentSession();
		return examm;
	}
               
    public List<Esamiconseguiti> findAll() {
		accomExamdao.openCurrentSession();
		List<Esamiconseguiti> examm = accomExamdao.findAll();
		accomExamdao.closeCurrentSession();
		return examm;
	}
    
    public void delete(int id) {
		accomExamdao.openCurrentSessionwithTransaction();
		Esamiconseguiti examm = accomExamdao.findById(id);
		accomExamdao.delete(examm);
		accomExamdao.closeCurrentSessionwithTransaction();
	}
    public AccomExamDAO AccomExamDAO() {
		return accomExamdao;
	}
}
