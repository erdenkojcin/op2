package com.sportskiklub.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Karton {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "karton_seq")
    @SequenceGenerator(name = "karton_seq", sequenceName = "karton_seq", allocationSize = 1)
    private int id;

    private String tip;
    private String razlog;
}
