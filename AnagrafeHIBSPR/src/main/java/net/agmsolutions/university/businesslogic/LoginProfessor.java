package net.agmsolutions.university.businesslogic;

import java.util.List;

import net.agmsolutions.university.dao.professors.ProfessorsDAOMethods;
import net.agmsolutions.university.entity.Professori;

public class LoginProfessor {

    public Professori CheckProf(String user, String pwd) {
        ProfessorsDAOMethods professors = new ProfessorsDAOMethods();
        List<Professori> professorsList = professors.findAll();
        for (Professori professor : professorsList) {
            if (professor.getNome().equals(user) && professor.getPassword().equals(pwd)) {
                return professor;
            }

        }
        return null;
    }
}
