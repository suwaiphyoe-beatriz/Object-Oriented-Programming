package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import datasource.MariaDbJpaConnection;

public class TransactionDao {

    public void persist(Transaction tx) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(tx);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
