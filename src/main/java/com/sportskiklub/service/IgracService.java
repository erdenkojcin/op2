package com.sportskiklub.service;

import com.sportskiklub.exception.IgracException;
import com.sportskiklub.model.Igrac;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class IgracService {

    @Inject
    private EntityManager em;

    @Transactional
    public Igrac createIgrac(Igrac igrac) throws IgracException {
        if (igrac == null) {
            throw new IgracException("igrac nije proslijedjen");
        }
        if (igrac.ime == null || igrac.ime.isEmpty()) {
            throw new IgracException("Ime je prazno");
        }
        if (igrac.prezime == null || igrac.prezime.isEmpty()) {
            throw new IgracException("Prezime je prazno");
        }
        return em.merge(igrac);
    }

    @Transactional
    public List<Igrac> gettAllIgraci() throws  IgracException {
        List<Igrac> igraci = em.createNamedQuery(Igrac.GET_ALL_IGRACI,
        Igrac.class).getResultList();

        if  (igraci.isEmpty()) {
            throw new IgracException("Nema igraca");
        }
        return igraci;
    }
}