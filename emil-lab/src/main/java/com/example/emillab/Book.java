package com.example.emillab;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {
//Во рамки на апликацијата се чуваат следните податоци за книгите: id (Long), name (String),
//category (enum), author (Author), availableCopies (Integer). Категоријата на книгата може да
//биде: NOVEL, THRILER, HISTORY, FANTASY, BIOGRAPHY, CLASSICS, DRAMA.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CATEGORY category;
    @OneToOne
    private Author author;
    private int availableCopies;
}
