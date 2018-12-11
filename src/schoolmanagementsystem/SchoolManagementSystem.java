package schoolmanagementsystem;

import DAO.*;
import Entity.domain.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SchoolManagementSystem {

    public static void main(String[] args) {

        //DAOStudentImpl dao = new DAOStudentImpl();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

//////        Teacher bitaJabbari = new Teacher(7501010000l, "Bita", "Jabbari", Gender.FEMALE, 40000);
////////        
//////   Course javaProgrammering = new Course("Java programmering", 50);
////        
////        Education javaUtv = new Education("Javautvecklare", 400);
////        
////        //EntityManager em = dao.getEntityManager();
////        
////        Student puya = new Student(8805130000L, "Puya", "Alemirad", Gender.MALE, 0);
////        javaUtv.addStudent(puya);
//        
//////////////////        bitaJabbari.addCourse(javaProgrammering);
//////////////////        
//////////////////        em.getTransaction().begin();
//////////////////        em.persist(bitaJabbari);
//////////////////        em.getTransaction().commit();
//        
        Teacher t = em.getReference(Teacher.class, 7501010000l);
        em.getTransaction().begin();
        for (Course c : t.getCourses()) {
            c.setTeacher(null);
        }
        em.remove(t);
        em.getTransaction().commit();
//        List<Course> courses = t.getCourses();
////        for (Course course : courses) {
////            System.out.println(course);
////        }
//        Iterator<Course> iterator = courses.iterator();
//
//        em.getTransaction().begin();
//        t.getCourses().clear();
//        em.merge(t);
//        while (iterator.hasNext()) {
//            t.removeCourse(iterator.next());
//
//        }
//
//        em.getTransaction().commit();
//        List<Course> courses2 = t.getCourses();
//        for (Course course : courses2) {
//            System.out.println(course);
//        }

///            
//    em.getTransaction().begin();
//        Query q = em.createNativeQuery("ALTER TABLE schoolmanagementsystem.Course \n" +
//"DROP CONSTRAINT theacher_person_id ");
//           
//           // em.remove(t);
//            em.getTransaction().commit();
//            em.getTransaction().begin();
//            em.remove(t);
//            em.getTransaction().commit();
//        //i menynval som leder till avslut skriv även in emf.close();
//        Education javaUtvecklare = new Education("Java utvecklare", 400, List<Course> courses, List<Student> students);
//        dao.createStudent(880513L, "Puya", "Alemirad", 880513, Gender.MALE, 50, );
//        
//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU");
//        EntityManager em=emf.createEntityManager();
//        
//        List<Student> listStudents = em.createQuery("select s from Student s",Student.class).getResultList();
//        
//        for (Student student : listStudents) {
//            System.out.println(student.getNamn());  
//        }
//        Student s=new Student("vg", "Puya");
//        Teacher t=new Teacher(20000,"Ulf");
//        
//        em.getTransaction().begin();
//        em.persist(s);
//        em.persist(t);
//        em.getTransaction().commit();
    }

}
