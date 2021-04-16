package com.example.emillab;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Author {
    //    За секој автор пак се
//чуваат податоците: id (Long), name (String), surname (String), country (Country).
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    @OneToOne
    private Country country;
}
