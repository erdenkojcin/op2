package com.sportskiklub.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQuery(name = Igrac.GET_ALL_IGRACI, query = "Select i from Igrac i")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "igrac_id")
    public List<Karton> kartoni = new ArrayList<>();

}


