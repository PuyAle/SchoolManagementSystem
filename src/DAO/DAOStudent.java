/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.domain.Education;
import Entity.domain.Gender;
import Entity.domain.Student;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author puyaa
 */
public interface DAOStudent {

    Student createStudent(Long personId, String firstName, String lastName, Gender gender);

    //boolean updateStudentPoints(Long personId);
    void updateStudentEducation(long personId, long educationId);

    Student getStudent(Long personId);

    List<Student> getStudentByName(String firstName);

    List<Student> getAllStudents();

    boolean removeStudent(Long personId);

}
