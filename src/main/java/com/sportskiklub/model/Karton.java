package com.sportskiklub.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@NamedQuery(name = Karton.GET_ALL_KARTONI_FOR_IGRAC_ID, query = "select k from Karton k where k.igrac.id = :id")

public class Karton {

    public static final String GET_ALL_KARTONI_FOR_IGRAC_ID = "GetAllKartoniForIgraci";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String tip;
    private String razlog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igrac_id")
    private Igrac igrac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utakmica_id")
    private Utakmica utakmica;

    public Karton(Long id, String tip, String razlog) {
        this.id = id;
        this.tip = tip;
        this.razlog = razlog;
    }

    public Karton() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getRazlog() {
        return razlog;
    }

    public void setRazlog(String razlog) {
        this.razlog = razlog;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Karton karton)) return false;
        return id.equals(karton.id) && Objects.equals(tip, karton.tip) && Objects.equals(razlog, karton.razlog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tip, razlog);
    }

    @Override
    public String toString() {
        return "Karton{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", razlog='" + razlog + '\'' +
                '}';
    }
}

