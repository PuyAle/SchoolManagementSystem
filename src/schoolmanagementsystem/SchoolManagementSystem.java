package schoolmanagementsystem;

import DAO.*;
import Entity.domain.*;
import UI.UI;
import UIDAOcom.UICommunicationDAOMain;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SchoolManagementSystem {

    public static boolean loop = true;

    public static void main(String[] args) {

        while (loop) {
            UICommunicationDAOMain.DAOProjectCom(UI.mainMenu());
        }

        //DAOStudentImpl dao = new DAOStudentImpl();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
//
//        EntityManager em = emf.createEntityManager();
//////        Teacher bitaJabbari = new Teacher(7501010000l, "Bita", "Jabbari", Gender.FEMALE, 40000);
////////
//        Course javaProgrammering = new Course("C++", 50);
////        javaProgrammering.addEducation(em.find(Education.class, 2l));
//        Education e = em.find(Education.class, 351l);
//        em.getTransaction().begin();
//        e.addCourse(javaProgrammering);
//        ;
//        em.getTransaction().commit();
////////
//        Education javaUtv = new Education("Javautvecklare", 400);
////
////        //EntityManager em = dao.getEntityManager();
////
        //Student puya = new Student(7010020000L, "Pelle", "Persson", Gender.MALE, 0);
        //javaUtv.addStudent(puya);
        //    javaUtv.addCourse(javaProgrammering);
//
//////////        bitaJabbari.addCourse(javaProgrammering);
//////////
        //Education e = em.getReference(Education.class, 2l);
//        em.getTransaction().begin();
//        //e.addStudent(puya);
//        //em.persist(javaProgrammering);
//        //em.persist(javaUtv);
//
//        em.getTransaction().commit();
////
//
        //em.getTransaction().begin();
//        Course c = em.getReference(Course.class, 251l);
//
//        Set<Education> e = c.getEducations();
//
//        for (Education education : e) {
//            Set<Student> s = education.getStudents();
//            for (Student student : s) {
//                System.out.println(student);
//            }
//
//        }
//remove course
//        em.getTransaction().begin();
//
//        Course c = em.getReference(Course.class, 851l);
//        c.getEducations().clear();
//        em.remove(c);
//        em.getTransaction().commit();
//remove education
//        em.getTransaction().begin();
//        Education e = em.find(Education.class, 2l);
//        Set<Course> setC = e.getCourses();
//        for (Course course : setC) {
//            course.removeEducation(e);
//        }
//        // e.getCourses().clear();
//        Set<Student> s = e.getStudents();
//        for (Student student : s) {
//            student.setEducation(null);
//        }
//        em.remove(e);
//        em.getTransaction().commit();
//Student s = em.getReference(Student.class, 8805130000l);
        //Education e = s.getEducation();
        //Set<Course> set = e.getCourses();
//
//        for (Course course : set) {
//            System.out.println(course);
//        }
        //e.addCourse(em.getReference(Course.class, 251l));
        //em.getTransaction().commit();
//
//        em.getTransaction().begin();
//
//
//         List<Course> courses = t.getCourses();
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
//        em.get Transaction().commit();
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
