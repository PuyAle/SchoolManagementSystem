package UIDAOcom;

import Entity.domain.Education;
import UI.UI;
import java.util.Scanner;

class UICommunicationDAOEducation {

    Scanner sc = new Scanner(System.in);

    public boolean switchEducation(UI ui, DAO.DAOEducationImpl dbe, DAO.DAOCourseImpl dbc) {
        switch (ui.educationMenu()) {
            case 1:
                Education e = dbe.createEducation(ui.enterName(" education "), ui.enterPoints());
                System.out.println("Do you want to add a course to the education? \nEnter 'yes' to add education, otherwise press any key to continue.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    ui.printList(dbc.getAllCourses());
                    System.out.println("Enter the id for the course:");
                    dbe.addCourse(e.getEducationId(), ui.enterId("course"));
                }
                ui.enterToContinue();
                break;
            case 2:
                dbc.getAllCourses();
                dbe.addCourse(ui.enterId("education"), ui.enterId("course"));
                ui.enterToContinue();
                break;
            case 3:
                System.out.println(dbe.getEducation(ui.enterId("education")));
                ui.enterToContinue();
                break;
            case 4:
                ui.printList(dbe.getEducationByName(ui.enterName(" education ")));
                ui.enterToContinue();
                break;
            case 5:
                ui.printList(dbe.getAllEducations());
                ui.enterToContinue();
                break;
            case 6:
                dbe.removeEducation(ui.enterId("education"));
                ui.enterToContinue();
                break;
            case 0:
                return false;
            default:
                System.out.println("Wrong choice, try again. ");

        }
        return true;
    }

}
