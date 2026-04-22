package com.sportskiklub.schedulers;

import com.sportskiklub.model.Ugovor;
import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class IgracScheduler {

    @Inject
    EntityManager em;

    @Scheduled(every = "1m")
    @Transactional
    public void provjeriUgovoreKojiIsticuUskoro() {
        LocalDate danas = LocalDate.now();
        LocalDate za30Dana = danas.plusDays(30);

        List<Ugovor> ugovori = em.createQuery(
                "SELECT u FROM Ugovor u WHERE u.datumIsteka BETWEEN :danas AND :za30Dana",
                Ugovor.class)
                .setParameter("danas", danas)
                .setParameter("za30Dana", za30Dana)
                .getResultList();

        if (!ugovori.isEmpty()) {
            Log.infof("UPOZORENJE: %d ugovor(a) istice u narednih 30 dana!", ugovori.size());
            for (Ugovor u : ugovori) {
                Log.infof("  -> Igrac ID %d, istice: %s, plata: %.2f",
                        u.getIgrac().getId(), u.getDatumIsteka(), u.getPlata());
            }
        } else {
            Log.info("Scheduler: nema ugovora koji isticu u narednih 30 dana.");
        }
    }
}
