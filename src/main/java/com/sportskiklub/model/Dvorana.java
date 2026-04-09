package com.sportskiklub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dvorana {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String naziv;
    private String lokacija;
    private int kapacitet;

    @OneToMany(mappedBy = "dvorana", fetch = FetchType.LAZY)
    private List<Utakmica> utakmice = new ArrayList<>();

    @OneToOne(mappedBy = "maticnaDvorana")
    private Tim tim;

    public Dvorana(Long id, String naziv, String lokacija, int kapacitet, List<Utakmica> utakmice) {
        this.id = id;
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.kapacitet = kapacitet;
    }

    public Dvorana() {

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

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public List<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(List<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }
}

