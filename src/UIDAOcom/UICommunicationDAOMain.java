package UIDAOcom;

import DAO.DAOCourseImpl;
import DAO.DAOEducationImpl;
import DAO.DAOStudentImpl;
import DAO.DAOTeacherImpl;

import UI.UI;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UICommunicationDAOMain {

    public UICommunicationDAOMain() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    }

    public static boolean DAOProjectCom(int i) {

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
                    loop = dbsCom.studentSwitch(dbs, ui, dbe);
                    break;
                case 2:
                    loop = dbtCom.switchTeacher(ui, dbt, dbc);
                    break;
                case 3:
                    loop = dbeCom.switchEducation(ui, dbe, dbc);
                    break;
                case 4:
                    loop = dbcCom.switchCourse(ui, dbe, dbc);
                    break;

                case 0:

                    //lägg in en metod som skapats i daoimpl klassen som
                    //avslutar emf i en try catch. dvs. att den ska avsluta den
                    //enbart om det finns en dvs emf !=null.
                    return false;

                default:
                    System.out.println("Wrong choice");

            }
        }
        return true;
    }

}
