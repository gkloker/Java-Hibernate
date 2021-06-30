package test;

import com.mycompany.hibernate.dao.UserDAO;
import com.mycompany.hibernate.domain.User;

public class OperationsHibernateJPA {

    public static void main(String[] args) {
        // Lista los usarios
        UserDAO userDao = new UserDAO();
        userDao.list();

        // Insert data
        User user = new User();
        user.setFirst_name("Patricia");
        user.setLast_name("Pombo");
        user.setEmail("pgpombo@gmail.com");
        user.setPhone("1165064200");
        userDao.insert(user);

        // Update data
        user.setIdUser(3);
        user = userDao.searchUserId(user);
        user.setFirst_name("Patricia Griselda");
        userDao.update(user);

        //Delete data
        userDao.delete(user);

        userDao.list();
    }
}
