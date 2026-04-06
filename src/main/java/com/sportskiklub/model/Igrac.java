package com.sportskiklub.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = Igrac.GET_ALL_IGRACI, query = "select i from Igrac i")
@NamedQuery(name = Igrac.GET_IGRAC_BY_NAME, query = "select i from Igrac i where i.ime = :imeI")

public class Igrac {

    public static final String GET_ALL_IGRACI = "GetAllIgraci";
    public static final String GET_IGRAC_BY_NAME = "GetIgraciByName";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String ime;
    private String prezime;
    private String pozicija;
    private int brojDresa;
    private LocalDate datumRodjenja;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tim_id")
    private Tim tim;

    @OneToMany(mappedBy = "igrac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Karton> kartoni = new ArrayList<>();

    @OneToOne(mappedBy = "igrac", cascade = CascadeType.ALL)
    private Ugovor ugovor;

    public Igrac(Long id, String ime, String prezime, String pozicija, int brojDresa, LocalDate datumRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.brojDresa = brojDresa;
        this.datumRodjenja = datumRodjenja;
    }

    public Igrac() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public int getBrojDresa() {
        return brojDresa;
    }

    public void setBrojDresa(int brojDresa) {
        this.brojDresa = brojDresa;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public List<Karton> getKartoni() {
        return kartoni;
    }

    public void setKartoni(List<Karton> kartoni) {
        this.kartoni = kartoni;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Igrac igrac)) return false;
        return brojDresa == igrac.brojDresa && Objects.equals(id, igrac.id) && Objects.equals(ime, igrac.ime) && Objects.equals(prezime, igrac.prezime) && Objects.equals(pozicija, igrac.pozicija) && Objects.equals(datumRodjenja, igrac.datumRodjenja) && Objects.equals(kartoni, igrac.kartoni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, pozicija, brojDresa, datumRodjenja, kartoni);
    }

    @Override
    public String toString() {
        return "Igrac{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", pozicija='" + pozicija + '\'' +
                ", brojDresa=" + brojDresa +
                ", datumRodjenja=" + datumRodjenja +
                ", kartoni=" + kartoni +
                '}';
    }
}



