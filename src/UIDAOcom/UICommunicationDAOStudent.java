package UIDAOcom;

import DAO.DAOCourseImpl;
import DAO.DAOEducationImpl;
import DAO.DAOStudentImpl;
import Entity.domain.Course;
import Entity.domain.Education;
import Entity.domain.Student;
import UI.UI;
import java.util.Scanner;

public class UICommunicationDAOStudent {

    Scanner sc = new Scanner(System.in);

    public boolean studentSwitch(DAOStudentImpl dbs, UI ui, DAOEducationImpl dbe, DAOCourseImpl dbc) {
        switch (ui.studentMenu()) {
            case 1:

                Student s = dbs.createStudent(ui.enterId("student"), ui.enterName(" students first "), ui.enterName(" students last "), ui.enterGender());
                System.out.println("Do you want to add a education? \nEnter 'yes' to add education, otherwise press any key to continue.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    ui.printList(dbe.getAllEducations());
                    System.out.println("Enter the id for the education:");
                    dbs.updateStudentEducation(s.getPersonId(), ui.enterId("education"));
                }
                ui.enterToContinue();
                break;
            case 2:
                ui.printList(dbe.getAllEducations());
                dbs.updateStudentEducation(ui.enterId("student"), ui.enterId("education"));
                ui.enterToContinue();
                break;
            case 3:
                Student s1 = dbs.getStudent(ui.enterId("Student"));
                Education e1 = s1.getEducation();
                ui.printList(e1.getCourses());
                System.out.println("\nChose one of the courses that the student has completed");
                Course c = dbc.getCourse(ui.enterId("course"));
                dbs.updateStudentPoints(s1.getPersonId(), c);
                System.out.println("points uppdated\n");
                ui.enterToContinue();
                break;
            case 4:
                System.out.println(dbs.getStudent(ui.enterId("student")));
                ui.enterToContinue();
                break;
            case 5:
                ui.printList(dbs.getStudentByName(ui.enterName(" students ")));
                ui.enterToContinue();
                break;
            case 6:
                ui.printList(dbs.getAllStudents());
                ui.enterToContinue();
                break;
            case 7:
                dbs.removeStudent(ui.enterId("student"));
                ui.enterToContinue();
                break;
            case 0:
                return false;
            default:
                System.out.println("wrong choice");
                break;
        }
        return true;
    }

}
