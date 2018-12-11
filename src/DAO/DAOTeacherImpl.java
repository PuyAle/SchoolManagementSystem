
package DAO;

import Entity.domain.Course;
import Entity.domain.Gender;
import Entity.domain.Student;
import Entity.domain.Teacher;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;


public class DAOTeacherImpl implements DAOTeacher{
public static EntityManagerFactory emf;
    public DAOTeacherImpl() {
        emf = Persistence.createEntityManagerFactory("PU");
    }
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    
    
    @Override
    public boolean createTeacher(Long personId, String firstName, String lastName, Gender gender, int salary) {
          EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Teacher t = new Teacher(personId, firstName, lastName, gender, salary);
            em.persist(t);
            em.getTransaction().commit();

            return true;

        } catch (EntityExistsException ex) {
            System.err.println("The person does already exist in the system.");
            return false;

            //catch (exception that handles commit problem?)
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean updateTeacherSalary(Long personId, int newSalary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTeacherCourse(Long personId, Course newCourse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getTeacher(Long personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getTeacherByName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeTeacher(Long personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
