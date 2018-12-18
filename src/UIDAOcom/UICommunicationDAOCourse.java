package UIDAOcom;

import UI.UI;

class UICommunicationDAOCourse {

    public void switchCourse(UI ui, DAO.DAOEducationImpl dbe, DAO.DAOCourseImpl dbc) {
        switch (ui.courseMenu()) {
            case 1:
                dbc.createCourse(ui.enterName(" course "), ui.enterPoints());
                break;
            case 2:
                dbc.addEducation(ui.enterId("course"), ui.enterId("education"));
                break;
            case 3:
                System.out.println(dbc.getCourse(ui.enterId("course")));
                break;
            case 4:
                ui.printList(dbc.getCourseByName(ui.enterName(" course ")));
                break;
            case 5:
                dbc.removeCourse(ui.enterId("course"));
                break;
            default:
                System.out.println("Wrong choice, try again. ");

        }
    }
}
