package DAO;

import Entity.domain.Education;
import Entity.domain.Gender;
import Entity.domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.*;

public class DAOStudentImpl implements DAOStudent {

    public DAOStudentImpl() {
    }

    public EntityManager getEntityManager() {
        return DAOCourseImpl.getEntityManager();
    }

    @Override
    public Student createStudent(Long personId, String firstName, String lastName, Gender gender) {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student s = new Student(personId, firstName, lastName, gender);
            em.persist(s);
            em.getTransaction().commit();

            return s;

        } catch (EntityExistsException ex) {
            System.err.println("The person does already exist in the system.");
            return null;

            //catch (exception that handles commit problem?)
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void updateStudentEducation(long personId, long educationId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Student s = em.getReference(Student.class, personId);
            Education e = em.getReference(Education.class, educationId);
            e.addStudent(s);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("The person doesn't exist in the system.");

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
    //@Override
//    public boolean updateStudentPoints(Long personId) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Student s = em.getReference(Student.class, personId);
//            Education e = s.getEducation();
//            e.
//            int newPoints = s.getPoints() +;
//            s.setPoints(newPoints);
//            em.getTransaction().commit();
//
//            return true;
//        } catch (EntityNotFoundException ex) {
//            System.out.println("The person doesn't exist in the system.");
//            return false;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//
//    }
//    @Override
//    public boolean updateStudentEducation(Long personId, Education newEducation) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Student s = em.getReference(Student.class, personId);
//            s.setEducation(newEducation);
//            em.getTransaction().commit();
//
//            return true;
//        } catch (EntityNotFoundException ex) {
//            System.out.println("The person doesn't exist in the system.");
//            return false;
//        } //catch (exception handling commit issues  rollback??)
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
    @Override
    public Student getStudent(Long personId) {

        EntityManager em = getEntityManager();
        try {
            Student s = em.find(Student.class, personId);
            return s;
        } catch (EntityNotFoundException e) {
            System.out.println("The person doesn't exist in the system.");
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Student> getStudentByName(String firstName) {

        EntityManager em = getEntityManager();
        try {
            TypedQuery<Student> q = em.createNamedQuery("getStudentByName", Student.class);
            List<Student> list = q.setParameter("firstName", "%" + firstName + "%").getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Student> getAllStudents() {

        EntityManager em = getEntityManager();
        try {
            TypedQuery<Student> q = em.createNamedQuery("getAllStudents", Student.class);
            List<Student> list = q.getResultList();
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
        } catch (EntityNotFoundException e) {
            System.out.println("The person doesn't exist in the system. ");
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

}
