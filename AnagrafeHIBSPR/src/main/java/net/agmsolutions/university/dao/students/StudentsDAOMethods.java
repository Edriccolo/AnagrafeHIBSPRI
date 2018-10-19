package net.agmsolutions.university.dao.students;

import java.util.List;
import net.agmsolutions.university.entity.Studenti;

public class StudentsDAOMethods {
    private static StudentsDAO studentsdao;

    public StudentsDAOMethods() {
        studentsdao = new StudentsDAO();
    }
    
    public void persist(Studenti entity) {
		studentsdao.openCurrentSessionwithTransaction();
		studentsdao.persist(entity);
		studentsdao.closeCurrentSessionwithTransaction();
	}

    public void update(Studenti entity) {
		studentsdao.openCurrentSessionwithTransaction();
		studentsdao.update(entity);
		studentsdao.closeCurrentSessionwithTransaction();
	}

	public Studenti findById(int id) {
		studentsdao.openCurrentSession();
		Studenti studenti = studentsdao.findById(id);
		studentsdao.closeCurrentSession();
		return studenti;
	}
        
    public List<Studenti> findAll() {
		studentsdao.openCurrentSession();
		List<Studenti> studenti = studentsdao.findAll();
		studentsdao.closeCurrentSession();
		return studenti;
	}
    
    public void delete(int id) {
		studentsdao.openCurrentSessionwithTransaction();
		Studenti studenti = studentsdao.findById(id);
		studentsdao.delete(studenti);
		studentsdao.closeCurrentSessionwithTransaction();
	}
    public StudentsDAO StudentsDAO() {
		return studentsdao;
	}
}
