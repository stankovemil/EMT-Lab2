package com.example.emillab;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Country")
public class Country {
//За секоја земја се
//чуваат податоците: id (Long), name (String), continent (String).
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "countryName")
    private String name;
    @Column(name = "continent")
    private String continent;
}
