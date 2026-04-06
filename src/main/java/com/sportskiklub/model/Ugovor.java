package com.sportskiklub.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQuery(name = Ugovor.GET_ALL_UGOVORI, query = "Select u from Ugovor u")
public class Ugovor {
    public static final String GET_ALL_UGOVORI = "GetAllUgovori";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ugovor_seq")
    @SequenceGenerator(name = "ugovor_seq", sequenceName = "ugovor_seq", allocationSize = 1)
    private Long id;
    private LocalDate datumPocetka;
    private LocalDate datumIsteka;
    private double plata;

    @OneToOne
    @JoinColumn(name = "igrac_id")
    private Igrac igrac;

    public Ugovor(Long id, LocalDate datumPocetka, LocalDate datumIsteka, double plata) {
        this.id = id;
        this.datumPocetka = datumPocetka;
        this.datumIsteka = datumIsteka;
        this.plata = plata;
    }

    public Ugovor() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDatumPocetka() { return datumPocetka; }
    public void setDatumPocetka(LocalDate datumPocetka) { this.datumPocetka = datumPocetka; }

    public LocalDate getDatumIsteka() { return datumIsteka; }
    public void setDatumIsteka(LocalDate datumIsteka) { this.datumIsteka = datumIsteka; }

    public double getPlata() { return plata; }
    public void setPlata(double plata) { this.plata = plata; }
}