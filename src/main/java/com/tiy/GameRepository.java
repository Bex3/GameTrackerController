package com.tiy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bearden-tellez on 9/15/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByGenre(String genre); //name of the parameter doesn't matter the name of the method matters
    List<Game> findByReleaseYear(int year); // spring takes the first capitalized word and passes it into the database - very important for it to map correctly
    List<Game> findByGameStat(String gameStat);

    List<Game> findByUser(User user);


    @Query("SELECT g FROM Game g WHERE g.name LIKE ?1%") //this uses sql-ish, can customize (good news) bad news (can be different)
    //g can be whatever as long as the after the where matches -also slecting from the entity not the db
    List<Game> findByNameStartsWith(String name);

}
