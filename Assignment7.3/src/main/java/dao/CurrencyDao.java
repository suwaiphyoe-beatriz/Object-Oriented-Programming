package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;
import datasource.MariaDbJpaConnection;

import java.util.List;

public class CurrencyDao {

    public void persist(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    public List<Currency> findAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
    }
}
