package net.agmsolutions.university.dao.professors;

import java.util.List;
import net.agmsolutions.university.entity.Professori;


public class ProfessorsDAOMethods {
    private static ProfessorsDAO professorsdao;

    public ProfessorsDAOMethods() {
        professorsdao = new ProfessorsDAO();
    }
    
    public void persist(Professori entity) {
		professorsdao.openCurrentSessionwithTransaction();
		professorsdao.persist(entity);
		professorsdao.closeCurrentSessionwithTransaction();
	}

    public void update(Professori entity) {
		professorsdao.openCurrentSessionwithTransaction();
		professorsdao.update(entity);
		professorsdao.closeCurrentSessionwithTransaction();
	}

	public Professori findById(int id) {
		professorsdao.openCurrentSession();
		Professori professori = professorsdao.findById(id);
		professorsdao.closeCurrentSession();
		return professori;
	}
        
    public List<Professori> findAll() {
		professorsdao.openCurrentSession();
		List<Professori> professori = professorsdao.findAll();
		professorsdao.closeCurrentSession();
		return professori;
	}
    
    public void delete(int id) {
		professorsdao.openCurrentSessionwithTransaction();
		Professori professori = professorsdao.findById(id);
		professorsdao.delete(professori);
		professorsdao.closeCurrentSessionwithTransaction();
	}
    public ProfessorsDAO ProfessorsDAO() {
		return professorsdao;
	}
}
