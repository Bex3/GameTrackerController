package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by bearden-tellez on 9/19/16.
 */

@RestController //rest - json api over http
public class GameTrackerJsonController {

    @Autowired
    GameRepository games;


    @RequestMapping(path = "/games.json", method = RequestMethod.GET)
    public ArrayList<Game> jsonHome(User user, String name, String platform, String genre, Integer releaseYear, String gameStat) {
        ArrayList<Game> gameList = new ArrayList<Game>();
        Iterable<Game> allGames = games.findAll();
        for (Game game : allGames) {
            gameList.add(game);
        }
        return gameList;

    }
}
