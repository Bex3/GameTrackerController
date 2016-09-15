package com.tiy;


import javax.persistence.*;

/**
 * Created by bearden-tellez on 9/15/16.
 */

@Entity
@Table(name = "games")

public class Game {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User user;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String platform;

    @Column(nullable = false)
    String genre;

    @Column(nullable = false)
    int releaseYear;

    @Column
    String gameStat;

    public Game() {
    }

    public Game(String name, String platform, String genre, int releaseYear, User user, String gameStat) {
        this.name = name;
        this.platform = platform;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.user = user;
        this.gameStat = gameStat;
    }
}
