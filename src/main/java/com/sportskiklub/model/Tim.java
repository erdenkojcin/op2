package com.sportskiklub.model;

import java.util.List;

public class Tim {
    public Long id;
    public String naziv;
    public String uzrast;
    public List<Igrac> igraci;
    public List<Trener> treneri;
    public List<Utakmica> utakmice;
    public List<Oprema> oprema;
}
