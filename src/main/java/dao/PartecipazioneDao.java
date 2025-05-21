package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.Partecipazione;

public class PartecipazioneDao {
    private final EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(partecipazione);
        tx.commit();
    }
}
