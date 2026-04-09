package com.sportskiklub.service;

import com.sportskiklub.exception.IgracException;
import com.sportskiklub.model.Igrac;
import com.sportskiklub.model.IgracUtakmica;
import com.sportskiklub.model.Karton;
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
        if (igrac.getIme() == null || igrac.getIme().isEmpty()) {
            throw new IgracException("Ime je prazno");
        }
        if (igrac.getPrezime() == null || igrac.getPrezime().isEmpty()) {
            throw new IgracException("Prezime je prazno");
        }
        if (igrac.getKartoni() != null) {
            for (Karton k : igrac.getKartoni()) {
                k.setIgrac(igrac);
            }
        }
        if (igrac.getUgovor() != null) {
            igrac.getUgovor().setIgrac(igrac);
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

    @Transactional
    public List<Igrac> getIgracByName(String name) throws IgracException {
        List<Igrac> igraci = em.createNamedQuery(Igrac.GET_IGRAC_BY_NAME, Igrac.class)
                .setParameter("imeI", name).getResultList();
        return igraci;
    }

    @Transactional
    public List<Karton> getKartoniByIgracId(Long id) throws IgracException {
        return em.createNamedQuery(Karton.GET_ALL_KARTONI_FOR_IGRAC_ID, Karton.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Transactional
    public List<IgracUtakmica> getUtakmiceByIgracId(Long id) throws IgracException {
        return em.createQuery(
                "SELECT iu FROM IgracUtakmica iu WHERE iu.igrac.id = :id", IgracUtakmica.class)
                .setParameter("id", id)
                .getResultList();
    }
}