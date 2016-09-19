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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGameStat() {
        return gameStat;
    }

    public void setGameStat(String gameStat) {
        this.gameStat = gameStat;
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
