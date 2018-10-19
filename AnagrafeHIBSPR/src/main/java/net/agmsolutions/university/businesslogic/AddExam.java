package net.agmsolutions.university.businesslogic;

import java.util.List;
import net.agmsolutions.university.dao.courses.CoursesDAOMethods;
import net.agmsolutions.university.dao.exams.ExamsDAOMethods;
import net.agmsolutions.university.dao.professors.ProfessorsDAOMethods;
import net.agmsolutions.university.entity.Appelli;
import net.agmsolutions.university.entity.Corsi;
import net.agmsolutions.university.entity.Professori;

public class AddExam {

    public List<Corsi> CheckCourses(int idProf) {
        CoursesDAOMethods corsi = new CoursesDAOMethods();
        ProfessorsDAOMethods profmeth = new ProfessorsDAOMethods();
        Professori prof = profmeth.findById(idProf);
        List<Corsi> coursesList = corsi.findByProfId(prof);
        return coursesList;
    }

    public int InsertExam(Integer idClass, String Date) {
        CoursesDAOMethods corsi = new CoursesDAOMethods();
        Corsi corso = corsi.findById(idClass);
        Appelli appello = new Appelli();
        appello.setCorsiIdcorsi(corso);
        appello.setData(Date);
        ExamsDAOMethods insert = new ExamsDAOMethods();
        insert.persist(appello);
        return 1;
    }
}
