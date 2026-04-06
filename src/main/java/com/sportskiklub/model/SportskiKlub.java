package com.sportskiklub.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SportskiKlub {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String naziv;
    private String osnovanGodine;
    private String grad;

    @OneToMany(mappedBy = "klub", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tim> timovi = new ArrayList<>();

    public SportskiKlub(Long id, String naziv, String osnovanGodine, String grad) {
        this.id = id;
        this.naziv = naziv;
        this.osnovanGodine = osnovanGodine;
        this.grad = grad;
    }

    public SportskiKlub() {

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

    public String getOsnovanGodine() {
        return osnovanGodine;
    }

    public void setOsnovanGodine(String osnovanGodine) {
        this.osnovanGodine = osnovanGodine;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public List<Tim> getTimovi() {
        return timovi;
    }

    public void setTimovi(List<Tim> timovi) {
        this.timovi = timovi;
    }
}
