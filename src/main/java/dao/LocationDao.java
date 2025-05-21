package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.Location;

public class LocationDao {
    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(location);
        tx.commit();
    }
}
