package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.Persona;

public class PersonaDao {
    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(persona);
        tx.commit();
    }

}
