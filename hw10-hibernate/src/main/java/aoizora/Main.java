package aoizora;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        System.out.println(em);
    }

    static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("common-unit");
        return emf.createEntityManager();
    }

    static SessionFactory getSessionFactory(String configFile, Class... annotatedClasses) {
        Configuration configuration = new Configuration().configure(configFile);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        MetadataSources mds = new MetadataSources(registry);

        Arrays.stream(annotatedClasses)
                .forEach(mds::addAnnotatedClass);
        Metadata metadata = mds.getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }
}
