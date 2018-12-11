package DAO;

import Entity.domain.Education;
import Entity.domain.Gender;
import Entity.domain.Student;
import java.time.LocalDate;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;

public class DAOStudentImpl implements DAOStudent {
 
    public static EntityManagerFactory emf;
    
    public DAOStudentImpl() {
    emf = Persistence.createEntityManagerFactory("PU");

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean createStudent(Long personId, String firstName, String lastName, Gender gender, int points, Education education) {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student s = new Student(personId, firstName, lastName, gender, points);
            em.persist(s);
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

    //Create a method that accepts the student to change course from the list in educationclass. 
    //The points from the old course should be added to the students total points. 
    //Create a variable in the student class that has the acctual course set in it, so after the changeCourse method is called 
    // it shoulde change the course variable and get the old points from that course.
    @Override
    public boolean updateStudentPoints(Long personId, int addPoints) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student s = em.getReference(Student.class, personId);
            int newPoints = s.getPoints() + addPoints;
            s.setPoints(newPoints);
            em.getTransaction().commit();

            return true;
        } catch (EntityNotFoundException ex) {
            System.out.println("The person doesn't exist in the system.");
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public boolean updateStudentEducation(Long personId, Education newEducation) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student s = em.getReference(Student.class, personId);
            s.setEducation(newEducation);
            em.getTransaction().commit();

            return true;
        } catch (EntityNotFoundException ex) {
            System.out.println("The person doesn't exist in the system.");
            return false;
        } //catch (exception handling commit issues  rollback??)
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Student> getStudent(Long personId) {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> q = em.createNamedQuery("findStudent", Student.class);

            q.setParameter("personId", personId);
            List<Student> list = q.getResultList();
            //Student s = em.find(Student.class, personId); om jag ska returnera en student enbart, nu returneras en lista ist för att passa printmetoden. 

            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Student> getStudentByName(String firstName) {

        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Student> q = em.createNamedQuery("getStudentByName", Student.class);
            List<Student> list = q.setParameter("firstName", "%" + firstName + "%").getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean removeStudent(Long personId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student s = em.getReference(Student.class, personId);
            em.remove(s);
            em.getTransaction().commit();
            return true;
        } catch (EntityNotFoundException ex) {
            System.out.println("The person doesn't exist in the system. ");
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

}
