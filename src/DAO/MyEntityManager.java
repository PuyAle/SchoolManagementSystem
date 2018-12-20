package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class MyEntityManager {

    public MyEntityManager() {
    }

    private static volatile EntityManagerFactory emf;

    synchronized public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PU");
        }
        return emf.createEntityManager();

    }

    synchronized public static void close() {
        if (emf != null) {
            emf.close();
        }
    }

}
