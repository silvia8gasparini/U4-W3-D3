import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioneDao;
import dao.PersonaDao;
import entities.Evento;
import entities.Partecipazione;
import entities.Persona;
import entities.Location;
import enumeration.TipoEvento;
import enumeration.StatoPartecipazione;

import java.time.LocalDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        PersonaDao personaDao = new PersonaDao(em);
        LocationDao locationDao = new LocationDao(em);
        EventoDao eventoDao = new EventoDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);

        Persona p1 = new Persona("Pedro", "Pascal", "pedrito.pascal@email.com", LocalDate.of(1975, 4, 2), "M");
        personaDao.save(p1);

        Persona p2 = new Persona("Florence", "Pugh", "florence.pugh@email.com", LocalDate.of(1996, 1, 3), "F");
        personaDao.save(p2);

        Location l1 = new Location("Biennale", "Venezia");
        locationDao.save(l1);

        Evento e1 = new Evento(
                "Festival del Cinema",
                LocalDate.of(2025, 9, 15),
                "Evento culturale con proiezioni internazionali",
                TipoEvento.PUBBLICO,
                300,
                l1
        );
        eventoDao.salva(e1);

        Partecipazione part1 = new Partecipazione(p1, e1, StatoPartecipazione.CONFERMATA);
        partecipazioneDao.save(part1);

        Partecipazione part2 = new Partecipazione(p2, e1, StatoPartecipazione.CONFERMATA);
        partecipazioneDao.save(part2);

        em.close();
        emf.close();
    }
}
