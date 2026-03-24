package com.sportskiklub.model;

import java.time.LocalDate;
import java.util.List;

public class Utakmica {
    public Long id;
    public Tim mojTim;
    public String protivnik;
    public Dvorana dvorana;
    public LocalDate datum;
    public String rezultat;
    public List<Igrac> igraci;
}
