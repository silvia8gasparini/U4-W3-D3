package entities;

import jakarta.persistence.*;
import enumeration.StatoPartecipazione;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    public Partecipazione() {}

    public Partecipazione(Persona persona, Evento evento, StatoPartecipazione stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public Long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
