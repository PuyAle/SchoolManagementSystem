package DAO;

import Entity.domain.Course;
import Entity.domain.Education;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAOCourseImpl implements DAOCourse {

    public static EntityManagerFactory emf;

    public DAOCourseImpl() {
        emf = Persistence.createEntityManagerFactory("PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void createCourse(String name, int points) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Course c = new Course(name, points);
            em.persist(c);
            em.getTransaction().commit();

            //catcha något annat
        }// catch (EntityExistsException ex) {
        //            System.err.println("The Education does already exist in the system.");
        //            return false;
        //}
        //catch (exception that handles commit problem?)
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void addEducation(long courseId, long educationId) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Education e = em.getReference(Education.class, educationId);
            e.addCourse(em.find(Course.class, courseId));
            em.getTransaction().commit();

        } catch (EntityNotFoundException | IllegalArgumentException e) {
            System.err.println("The course or education does not exist in the system.");

            //catch (exception that handles commit problem?)
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Course getCourse(Long courseId) {
        EntityManager em = getEntityManager();
        try {
            Course c = em.find(Course.class, courseId);
            return c;
        } catch (EntityNotFoundException e) {
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Course> getCourseByName(String name) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Course> q = em.createNamedQuery("getCourseByName", Course.class);
            List<Course> list = q.setParameter("name", name + "%").getResultList();
            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Course> q = em.createNamedQuery("getAllCourses", Course.class);
            List<Course> list = q.getResultList();

            return list;
        } finally {
            em.close();
        }
    }

    @Override
    public void removeCourse(long courseId) {
        EntityManager em = null;
        try {

            em = getEntityManager();
            em.getTransaction().begin();

            Course c = em.getReference(Course.class, courseId);
            c.getEducations().clear();
            em.remove(c);
            em.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
