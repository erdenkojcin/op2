package com.sportskiklub.model;

import jakarta.persistence.*;


@Entity
public class Oprema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String naziv;
    private String tip;
    private String velicina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tim_id")
    private Tim tim;


    public Oprema() {
    }

    public Oprema(Long id, String naziv, String tip, String velicina) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.velicina = velicina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }
}
