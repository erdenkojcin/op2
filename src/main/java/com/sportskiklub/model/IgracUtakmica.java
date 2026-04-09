package com.sportskiklub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class IgracUtakmica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igrac_id")
    private Igrac igrac;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utakmica_id")
    private Utakmica utakmica;

    private int golovi;
    private int minutiIgre;

    public IgracUtakmica() {}

    public IgracUtakmica(Igrac igrac, Utakmica utakmica, int golovi, int minutiIgre) {
        this.igrac = igrac;
        this.utakmica = utakmica;
        this.golovi = golovi;
        this.minutiIgre = minutiIgre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Igrac getIgrac() { return igrac; }
    public void setIgrac(Igrac igrac) { this.igrac = igrac; }

    public Utakmica getUtakmica() { return utakmica; }
    public void setUtakmica(Utakmica utakmica) { this.utakmica = utakmica; }

    public int getGolovi() { return golovi; }
    public void setGolovi(int golovi) { this.golovi = golovi; }

    public int getMinutiIgre() { return minutiIgre; }
    public void setMinutiIgre(int minutiIgre) { this.minutiIgre = minutiIgre; }
}
