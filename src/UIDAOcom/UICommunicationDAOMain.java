package UIDAOcom;

import DAO.DAOCourseImpl;
import DAO.DAOEducationImpl;
import DAO.DAOStudentImpl;
import DAO.DAOTeacherImpl;
import Entity.domain.Gender;
import UI.UI;
import schoolmanagementsystem.SchoolManagementSystem;

public class UICommunicationDAOMain {

    public static void DAOProjectCom(int i) {

//create a constructor with 1 entitymanagerfactory that is used for every entityDAO.
        DAOStudentImpl dbs = new DAOStudentImpl();
        DAOTeacherImpl dbt = new DAOTeacherImpl();
        DAOEducationImpl dbe = new DAOEducationImpl();
        DAOCourseImpl dbc = new DAOCourseImpl();

        UICommunicationDAOStudent dbsCom = new UICommunicationDAOStudent();
        UICommunicationDAOTeacher dbtCom = new UICommunicationDAOTeacher();
        UICommunicationDAOEducation dbeCom = new UICommunicationDAOEducation();
        UICommunicationDAOCourse dbcCom = new UICommunicationDAOCourse();

        UI ui = new UI();

        boolean loop = true;

        while (loop) {
            switch (i) {
                case 1:
                    dbsCom.studentSwitch(dbs, ui, dbe);
                    break;
                case 2:
                    dbtCom.switchTeacher(ui, dbt, dbc);
                    break;
                case 3:
                    dbeCom.switchEducation(ui, dbe, dbc);
                    break;
                case 4:
                    dbcCom.switchCourse(ui, dbe, dbc);
                    break;

                case 0:
                    //lägg in en metod som skapats i daoimpl klassen som
                    //avslutar emf i en try catch. dvs. att den ska avsluta den
                    //enbart om det finns en dvs emf !=null.
                    loop = false;
                    SchoolManagementSystem.loop = false;
                    break;
                default:
                    System.out.println("Wrong choice");
                    ;

            }
            loop = false;
        }
    }

}
