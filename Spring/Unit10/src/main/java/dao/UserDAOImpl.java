package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("userDAO")
public class UserDAOImpl  implements interfaceUserDAO{
    private final static Logger LOGGER = null;
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
