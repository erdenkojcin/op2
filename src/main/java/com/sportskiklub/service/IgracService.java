package com.sportskiklub.service;

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
    public Igrac sacuvajIgraca(Igrac igrac) {
        return em.merge(igrac);
    }

    @Transactional
    public List<Igrac> sviIgraci() {
        return em.createNamedQuery(Igrac.GET_ALL_IGRACI, Igrac.class).getResultList();
    }
}