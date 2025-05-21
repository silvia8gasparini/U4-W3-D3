package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.Evento;

public class EventoDao {
    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void salva(Evento evento) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(evento);
        tx.commit();
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void rimuovi(Long id) {
        Evento e = getById(id);

        if (e != null) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(e);
            tx.commit();
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }
    }
}
