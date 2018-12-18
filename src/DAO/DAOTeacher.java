package DAO;

import Entity.domain.Course;
import Entity.domain.Gender;
import Entity.domain.Student;
import Entity.domain.Teacher;
import java.util.List;

public interface DAOTeacher {

    Teacher createTeacher(Long personId, String firstName, String lastName, Gender gender, int salary);

    void updateTeacherSalary(Long personId, int newSalary);

    void updateTeacherCourse(Long personId, long courseId);

    Teacher getTeacher(Long personId);

    List<Teacher> getTeacherByName(String firstName);

    List<Teacher> getAllTeachers();

    void removeTeacher(Long personId);

}
