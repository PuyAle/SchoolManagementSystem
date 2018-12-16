package DAO;

import Entity.domain.Course;
import Entity.domain.Gender;
import Entity.domain.Student;
import Entity.domain.Teacher;
import java.util.List;

public interface DAOTeacher {

    boolean createTeacher(Long personId, String firstName, String lastName, Gender gender, int salary);

    void updateTeacherSalary(Long personId, int newSalary);

    void updateTeacherCourse(Long personId, long courseId);

    List<Teacher> getTeacher(Long personId);

    List<Teacher> getTeacherByName(String firstName);

    void removeTeacher(Long personId);

}
