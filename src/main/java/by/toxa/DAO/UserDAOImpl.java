package by.toxa.DAO;

import by.toxa.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession (){
        return sessionFactory.getCurrentSession();
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return currentSession ().createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        currentSession ().persist(user);
    }

    @Override
    public void delete(User user) {
        currentSession ().delete(user);
    }

    @Override
    public void edit(User user) {
        currentSession ().update(user);
    }

    @Override
    public User getById(int id) {

        return currentSession ().get(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getByName(String email) {
        Query<User> q=  currentSession().createQuery(
                "from User where email=:email",User.class);
        q.setParameter("email",email);
       if(q.list().isEmpty()) return null;
       else

        return q.list().get(0);
    }
}
