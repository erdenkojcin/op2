package com.sportskiklub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class CurrencyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String from;
    private String to;
    private double rate;

    private double value;
    private double convertedValue;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "igrac_id")
    private Igrac igrac;

    public CurrencyResponse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public double getConvertedValue() { return convertedValue; }
    public void setConvertedValue(double convertedValue) { this.convertedValue = convertedValue; }

    public Igrac getIgrac() { return igrac; }
    public void setIgrac(Igrac igrac) { this.igrac = igrac; }

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", rate=" + rate +
                ", value=" + value +
                ", convertedValue=" + convertedValue +
                '}';
    }
}
