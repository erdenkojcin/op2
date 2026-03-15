package com.sportskiklub.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NamedQuery(name = Igrac.GET_ALL_IGRACI, query = "Select i from Igrac i")
public class Igrac {
    public static final String GET_ALL_IGRACI = "GetAllIgraci";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "igrac_seq")
    @SequenceGenerator(name = "igrac_seq", sequenceName = "igrac_seq", allocationSize = 1)
    public Long id;
    public String ime;
    public String prezime;
    public String pozicija;
    public int brojDresa;
    public LocalDate datumRodjenja;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Igrac igrac = (Igrac) o;
        return Objects.equals(id, igrac.id) && Objects.equals(ime, igrac.ime) && Objects.equals(prezime, igrac.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime);
    }
}