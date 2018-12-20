package DAO;

import Entity.domain.Course;
import Entity.domain.Education;
import Entity.domain.Student;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

public class DAOEducationImpl implements DAOEducation {

    public DAOEducationImpl() {
    }

    public EntityManager getEntityManager() {
        return MyEntityManager.getEntityManager();
    }

    @Override
    public Education createEducation(String name, int points) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Education e = new Education(name, points);
            em.persist(e);
            em.getTransaction().commit();
            return e;

        } catch (EntityExistsException ex) {
            System.err.println("The Education does already exist in the system.");

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    @Override
    public void addCourse(long educationId, long courseId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Education e = em.getReference(Education.class, educationId);
            e.addCourse(em.getReference(Course.class, courseId));
            em.getTransaction().commit();

        } catch (EntityNotFoundException e) {
            System.err.println("The course or education does not exist in the system.");

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public Education getEducation(Long educationId) {
        EntityManager em = getEntityManager();
        try {
            Education e = em.find(Education.class, educationId);
            return e;
        } catch (EntityNotFoundException e) {
            System.out.println("The education does not exist in the system.");
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Education> getEducationByName(String name) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Education> q = em.createNamedQuery("getEducationByName", Education.class);
            List<Education> list = q.setParameter("name", name + "%").getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Education> getAllEducations() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Education> q = em.createNamedQuery("getAllEducations", Education.class);
            List<Education> list = q.getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public void removeEducation(long educationId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Education e = em.find(Education.class, educationId);

            Set<Course> setC = e.getCourses();

            for (Course course : setC) {
                course.removeEducation(e);
            }

            Set<Student> s = e.getStudents();

            for (Student student : s) {
                student.setEducation(null);
            }

            em.remove(e);
            em.getTransaction().commit();

        } catch (EntityNotFoundException e) {
            System.out.println("The education you are trying to delete doesn't exist in the system. ");

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
