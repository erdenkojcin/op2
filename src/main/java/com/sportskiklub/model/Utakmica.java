package com.sportskiklub.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utakmica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String protivnik;
    private LocalDate datum;
    private String rezultat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tim_id")
    private Tim tim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dvorana_id")
    private Dvorana dvorana;

    @OneToMany(mappedBy = "utakmica", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Karton> kartoni = new ArrayList<>();

    public Utakmica(Long id, Tim tim, String protivnik, Dvorana dvorana, LocalDate datum, String rezultat) {
        this.id = id;
        this.tim = tim;
        this.protivnik = protivnik;
        this.dvorana = dvorana;
        this.datum = datum;
        this.rezultat = rezultat;
    }

    public Utakmica() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public String getProtivnik() {
        return protivnik;
    }

    public void setProtivnik(String protivnik) {
        this.protivnik = protivnik;
    }

    public Dvorana getDvorana() {
        return dvorana;
    }

    public void setDvorana(Dvorana dvorana) {
        this.dvorana = dvorana;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

}
