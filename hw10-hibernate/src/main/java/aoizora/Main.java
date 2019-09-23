package aoizora;

import aoizora.domain.Address;
import aoizora.domain.Phone;
import aoizora.domain.User;
import org.hibernate.Session;
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
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory("hibernate.cfg.xml", User.class, Address.class, Phone.class);

        try (Session session = sf.openSession()) {
            User user = new User();
            user.setName("John");

            Address address = new Address("Kalinina");
            address.setUser(user);

            Phone phone = new Phone("777");
            phone.setUser(user);

            user.setAddress(address);
            user.setPhone(Collections.singletonList(phone));

            session.beginTransaction();
            Long id = (Long) session.save(user);
            session.getTransaction().commit();

            User loadedUser = session.get(User.class, id);
            System.out.println(loadedUser);

            assert loadedUser.equals(user);
        }
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
