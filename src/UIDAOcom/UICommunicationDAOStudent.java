package UIDAOcom;

import DAO.DAOEducationImpl;
import DAO.DAOStudentImpl;
import Entity.domain.Student;
import UI.UI;
import java.util.Scanner;

public class UICommunicationDAOStudent {

    Scanner sc = new Scanner(System.in);

    public boolean studentSwitch(DAOStudentImpl db, UI ui, DAOEducationImpl dbe) {
        switch (ui.studentMenu()) {
            case 1:

                Student s = db.createStudent(ui.enterId("student"), ui.enterName(" students first "), ui.enterName(" students last "), ui.enterGender());
                System.out.println("Do you want to add a education? \nEnter 'yes' to add education, otherwise press any key to continue.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    ui.printList(dbe.getAllEducations());
                    System.out.println("Enter the id for the education:");
                    db.updateStudentEducation(s.getPersonId(), ui.enterId("education"));
                }
                ui.enterToContinue();
                break;
            case 2:
                db.updateStudentEducation(ui.enterId("student"), ui.enterId("education"));
                ui.enterToContinue();
                break;
            case 3:
                System.out.println(db.getStudent(ui.enterId("student")));
                ui.enterToContinue();
                break;
            case 4:
                ui.printList(db.getStudentByName(ui.enterName(" students ")));
                ui.enterToContinue();
                break;
            case 5:
                ui.printList(db.getAllStudents());
                ui.enterToContinue();
                break;
            case 6:
                db.removeStudent(ui.enterId("student"));
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
