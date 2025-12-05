package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import datasource.MariaDbJpaConnection;

public class TransactionDao {

    public void persist(Transaction tx) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(tx);
        em.getTransaction().commit();
    }

    public java.util.List<Transaction> findAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t", Transaction.class)
                .getResultList();
    }
}
