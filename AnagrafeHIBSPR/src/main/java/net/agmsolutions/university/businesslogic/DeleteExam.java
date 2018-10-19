package net.agmsolutions.university.businesslogic;

import java.util.ArrayList;
import java.util.List;
import net.agmsolutions.university.dao.courses.CoursesDAOMethods;
import net.agmsolutions.university.dao.exams.ExamsDAOMethods;
import net.agmsolutions.university.dao.professors.ProfessorsDAOMethods;
import net.agmsolutions.university.entity.Appelli;
import net.agmsolutions.university.entity.Corsi;
import net.agmsolutions.university.entity.Professori;


public class DeleteExam {
     public List<Appelli> ExamChoice(int id){
         List<Appelli> examss = new ArrayList<Appelli>();
        CoursesDAOMethods corsi=new CoursesDAOMethods();
        ProfessorsDAOMethods profmeth = new ProfessorsDAOMethods();
        Professori prof = profmeth.findById(id);
        List<Corsi> coursesList = corsi.findByProfId(prof);
        Corsi[] arrayCorsi=coursesList.toArray(new Corsi[coursesList.size()]);
        ExamsDAOMethods exams=new ExamsDAOMethods();
        List<Appelli> AllExams=exams.findAll();
        Appelli[] examArray=AllExams.toArray(new Appelli[AllExams.size()]);
        for (int i = 0; i < coursesList.size(); i++) {
            for (int j = 0; j < AllExams.size(); j++) {
            if(arrayCorsi[i].equals(examArray[j].getCorsiIdcorsi()))
                examss.add(examArray[j]);
        }
        }
        return examss;
    }
     
     public boolean DeleteExam(Integer idExam){
        ExamsDAOMethods exams=new ExamsDAOMethods();
        exams.delete(idExam);
        return true;
    }
}
