package ru.dstu.application.dao.entitiesDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.dstu.application.dao.Dao;
import ru.dstu.application.entities.Task;
import ru.dstu.application.utils.HibernateConnector;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskDao implements Dao<Task> {

    private final EntityManager entityManager = HibernateConnector.entityManager;

    @Override
    public List<Task> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Task", Task.class).getResultList();
    }

    public List<Task> findByCondition(int spent_time, int limit,  int offset) {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery(
                   "FROM Task task " +
                      "WHERE task.spent_time > " + spent_time +
                      " AND task.worker.salary < 15000",
                Task.class
        ).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    @Override
    public Task findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Task.class, id);
    }

    @Override
    public void save(Task obj) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        Transaction transaction = session.getTransaction();
        session.saveOrUpdate(obj);
        transaction.commit();
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Task obj = findById(id);
        session.delete(obj);
    }
}
