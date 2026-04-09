package com.sportskiklub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class TimOprema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tim_id")
    private Tim tim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oprema_id")
    private Oprema oprema;

    private int kolicina;

    public TimOprema() {}

    public TimOprema(Tim tim, Oprema oprema, int kolicina) {
        this.tim = tim;
        this.oprema = oprema;
        this.kolicina = kolicina;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Tim getTim() { return tim; }
    public void setTim(Tim tim) { this.tim = tim; }

    public Oprema getOprema() { return oprema; }
    public void setOprema(Oprema oprema) { this.oprema = oprema; }

    public int getKolicina() { return kolicina; }
    public void setKolicina(int kolicina) { this.kolicina = kolicina; }
}
