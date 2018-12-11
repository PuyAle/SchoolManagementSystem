
package DAO;


import Entity.domain.Course;
import Entity.domain.Gender;
import Entity.domain.Student;
import java.util.List;


public interface DAOTeacher {
 boolean createTeacher(Long personId, String firstName, String lastName, Gender gender, int salary);
    
    boolean updateTeacherSalary(Long personId, int newSalary);
    
    boolean updateTeacherCourse (Long personId, Course newCourse);
    
    List<Student> getTeacher(Long personId);
    
    List <Student> getTeacherByName(String firstName);
    
    boolean removeTeacher(Long personId);
    
}
