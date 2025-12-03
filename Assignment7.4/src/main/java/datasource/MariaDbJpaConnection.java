package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDbJpaConnection {

    private static EntityManagerFactory emf = null;

    private MariaDbJpaConnection() {}

    public static EntityManager getInstance() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("CurrencyConverterUnit");
        }
        // Always return a new EntityManager
        return emf.createEntityManager();
    }
}
