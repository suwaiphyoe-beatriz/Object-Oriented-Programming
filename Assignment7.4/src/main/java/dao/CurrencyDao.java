package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;
import datasource.MariaDbJpaConnection;
import java.util.List;

public class CurrencyDao {

    public void persist(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Currency> findAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
        } finally {
            em.close();
        }
    }
}
