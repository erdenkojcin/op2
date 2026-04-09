package com.sportskiklub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tim {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String naziv;
    private String uzrast;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klub_id")
    private SportskiKlub klub;

    @OneToOne
    @JoinColumn(name = "dvorana_id")
    private Dvorana maticnaDvorana;

    @OneToMany(mappedBy = "tim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Igrac> igraci = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "TIM_TRENER",
        joinColumns = @JoinColumn(name = "tim_id"),
        inverseJoinColumns = @JoinColumn(name = "trener_id")
    )
    private List<Trener> treneri = new ArrayList<>();

    @OneToMany(mappedBy = "mojTim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Utakmica> utakmice = new ArrayList<>();

    @OneToMany(mappedBy = "tim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TimOprema> timOprema = new ArrayList<>();

    public Tim(Long id, String naziv, String uzrast) {
        this.id = id;
        this.naziv = naziv;
        this.uzrast = uzrast;
    }

    public Tim() {

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

    public String getUzrast() {
        return uzrast;
    }

    public void setUzrast(String uzrast) {
        this.uzrast = uzrast;
    }

    public List<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(List<Igrac> igraci) {
        this.igraci = igraci;
    }

    public List<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
    }

    public List<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(List<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

    public List<TimOprema> getTimOprema() {
        return timOprema;
    }

    public void setTimOprema(List<TimOprema> timOprema) {
        this.timOprema = timOprema;
    }

    public Dvorana getMaticnaDvorana() {
        return maticnaDvorana;
    }

    public void setMaticnaDvorana(Dvorana maticnaDvorana) {
        this.maticnaDvorana = maticnaDvorana;
    }
}
