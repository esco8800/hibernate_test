package ru.dstu.application.dao.entitiesDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.dstu.application.dao.Dao;
import ru.dstu.application.entities.Worker;
import ru.dstu.application.utils.HibernateConnector;

import javax.persistence.EntityManager;
import java.util.List;

public class WorkerDao implements Dao<Worker> {

    private final EntityManager entityManager = HibernateConnector.entityManager;

    @Override
    public List<Worker> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM Worker", Worker.class).getResultList();
    }

    @Override
    public Worker findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Worker.class, id);
    }

    @Override
    public void save(Worker obj) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        Transaction transaction = session.getTransaction();
        session.saveOrUpdate(obj);
        transaction.commit();
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Worker obj = findById(id);
        session.delete(obj);
    }
}
