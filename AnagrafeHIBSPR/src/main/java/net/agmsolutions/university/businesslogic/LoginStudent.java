package net.agmsolutions.university.businesslogic;

import java.util.List;

import net.agmsolutions.university.dao.students.StudentsDAOMethods;
import net.agmsolutions.university.entity.Studenti;

public class LoginStudent {

    public Studenti CheckStud(String user, String pwd) {
        StudentsDAOMethods students = new StudentsDAOMethods();
        List<Studenti> studentsList = students.findAll();
        for (Studenti student : studentsList) {
            if (student.getNome().equals(user) && student.getPassword().equals(pwd)) {
                return student;
            }

        }
        return null;
    }
}
