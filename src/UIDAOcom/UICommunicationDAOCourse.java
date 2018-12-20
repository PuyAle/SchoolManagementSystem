package UIDAOcom;

import Entity.domain.Course;
import UI.UI;
import java.util.Scanner;

class UICommunicationDAOCourse {

    Scanner sc = new Scanner(System.in);

    public boolean switchCourse(UI ui, DAO.DAOEducationImpl dbe, DAO.DAOCourseImpl dbc) {
        switch (ui.courseMenu()) {
            case 1:
                Course c = dbc.createCourse(ui.enterName(" course "), ui.enterPoints());
                System.out.println("Do you want to add the course to a education? \nEnter 'yes' to add education, otherwise press any key to continue.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    ui.printList(dbc.getAllCourses());
                    System.out.println("Enter the id for the course:");
                    dbe.addCourse(c.getCourseId(), ui.enterId("education"));
                }
                ui.enterToContinue();
                break;

            case 2:
                dbe.getAllEducations();
                dbc.addEducation(ui.enterId("course"), ui.enterId("education"));
                ui.enterToContinue();
                break;
            case 3:
                System.out.println(dbc.getCourse(ui.enterId("course")));
                ui.enterToContinue();
                break;
            case 4:
                ui.printList(dbc.getCourseByName(ui.enterName(" course ")));
                ui.enterToContinue();
                break;
            case 5:
                ui.printList(dbc.getAllCourses());
                ui.enterToContinue();
                break;
            case 6:
                dbc.removeCourse(ui.enterId("course"));
                ui.enterToContinue();
                break;
            case 0:
                return false;
            default:
                System.out.println("Wrong choice, try again. ");
                break;
        }
        return true;
    }
}
