package test;

import com.mycompany.hibernate.domain.User;
import java.util.List;
import javax.persistence.*;

public class testHibernate {

    public static void main(String[] args) {
        String hql = "SELECT u FROM User u";

        // Crea la instancia para conectar a la base de datos
        EntityManagerFactory f = Persistence.createEntityManagerFactory("Hibernate");
        EntityManager entityManager = f.createEntityManager();

        Query query = entityManager.createQuery(hql);
        List<User> users = query.getResultList();

        for (User u : users) {
            System.out.println("User: " + u);
        }
    }
}
