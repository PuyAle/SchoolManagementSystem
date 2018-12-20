package run;

import DAO.MyEntityManager;
import UI.UI;
import UIDAOcom.UICommunicationDAOMain;

public class run {

    public static void main(String[] args) {

        while (UICommunicationDAOMain.DAOProjectCom(UI.mainMenu())) {

        }
        if (MyEntityManager.getEntityManager() != null) {
            MyEntityManager.close();
        }
    }

}
