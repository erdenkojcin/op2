package com.sportskiklub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String ime;
    private String prezime;
    private String specijalnost;

    @ManyToMany(mappedBy = "treneri", fetch = FetchType.LAZY)
    private List<Tim> timovi = new ArrayList<>();

    public Trener(Long id, String ime, String prezime, String specijalnost) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.specijalnost = specijalnost;
    }

    public Trener() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getSpecijalnost() { return specijalnost; }
    public void setSpecijalnost(String specijalnost) { this.specijalnost = specijalnost; }

    public List<Tim> getTimovi() { return timovi; }
    public void setTimovi(List<Tim> timovi) { this.timovi = timovi; }
}
