package net.agmsolutions.university.businesslogic;

import java.util.List;
import net.agmsolutions.university.dao.exams.ExamsDAOMethods;
import net.agmsolutions.university.entity.Appelli;


public class ReadAvailableExams {
    
    public List<Appelli> ExamList(){
        ExamsDAOMethods exams=new ExamsDAOMethods();
        return exams.findAll();
    }
}
