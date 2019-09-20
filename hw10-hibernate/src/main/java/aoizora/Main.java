package aoizora;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        System.out.println(em);
    }

    static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("common-unit");
        return emf.createEntityManager();
    }
}
