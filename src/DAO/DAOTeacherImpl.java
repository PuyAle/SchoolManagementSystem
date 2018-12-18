package DAO;

import Entity.domain.Course;
import Entity.domain.Education;
import Entity.domain.Gender;
import Entity.domain.Student;
import Entity.domain.Teacher;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAOTeacherImpl implements DAOTeacher {

    public static EntityManagerFactory emf;

    public DAOTeacherImpl() {
        emf = Persistence.createEntityManagerFactory("PU");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Teacher createTeacher(Long personId, String firstName, String lastName, Gender gender, int salary) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Teacher t = new Teacher(personId, firstName, lastName, gender, salary);
            em.persist(t);
            em.getTransaction().commit();

            return t;

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
    public void updateTeacherSalary(Long personId, int newSalary) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Teacher t = em.getReference(Teacher.class, personId);
            t.setSalary(newSalary);
            em.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            System.out.println("The person doesn't exist in the system.");

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void updateTeacherCourse(Long personId, long courseId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Teacher t = em.getReference(Teacher.class, personId);
            Course c = em.getReference(Course.class, courseId);
            c.setTeacher(t);
            em.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            System.out.println("The person doesn't exist in the system.");

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Teacher getTeacher(Long personId) {
        EntityManager em = getEntityManager();
        try {
            Teacher t = em.find(Teacher.class, personId);
            return t;
        } catch (EntityNotFoundException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Teacher> getTeacherByName(String firstName) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Teacher> q = em.createNamedQuery("getTeacherByName", Teacher.class);
            List<Teacher> list = q.setParameter("firstName", firstName + "%").getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Teacher> q = em.createNamedQuery("getAllTeachers", Teacher.class);
            List<Teacher> list = q.getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public void removeTeacher(Long personId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Teacher t = em.getReference(Teacher.class, personId);
            Set<Course> courses = t.getCourses();
            for (Course course : courses) {
                course.setTeacher(null);
            }
            em.remove(t);
            em.getTransaction().commit();
        } catch (EntityNotFoundException ex) {
            System.out.println("The person doesn't exist in the system. ");

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

}
