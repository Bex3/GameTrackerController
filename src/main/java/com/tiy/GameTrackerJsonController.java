package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.annotation.ExceptionProxy;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by bearden-tellez on 9/19/16.
 */

@RestController //rest - json api over http automatically converts the code
public class GameTrackerJsonController {

    @Autowired
    GameRepository games; //must bring in the repo here in order to cycle through the repo


    @RequestMapping(path = "/games.json", method = RequestMethod.GET)
    public ArrayList<Game> jsonHome(User user, String name, String platform, String genre, Integer releaseYear, String gameStat) {
        ArrayList<Game> gameList = new ArrayList<Game>();
        Iterable<Game> allGames = games.findAll(); // hibernate (object relational mapping) uses the repo
        for (Game game : allGames) {
            gameList.add(game);
        }

        try {
            System.out.println("Catching a nap");
            Thread.sleep(3000);
            System.out.println("Power naps are the best");
        } catch (Exception ex){
            System.out.println("Exception");
        }

        return gameList; // returns an object instead of a view b/c this is a restful webservice - only gives data
    }

    ArrayList<Game> getAllGames() {
        ArrayList<Game> gameList = new ArrayList<Game>();
        Iterable<Game> allGames = games.findAll();
        for (Game game : allGames) {
            gameList.add(game);
        }

        return gameList;
    }

    @RequestMapping(path = "/toggleGame.json", method = RequestMethod.GET)
    public ArrayList<Game> toggleGame(int gameID) {
        System.out.println("toggling game with ID " + gameID);
        Game game = games.findOne(gameID);
        game.name = "**" + game.name;
        games.save(game);

        return getAllGames();
    }

    @RequestMapping(path = "/addGame.json", method = RequestMethod.POST) //post & rest combined means that we take the game signaled at the rest controller and turn it into a java object
    public ArrayList<Game> addGame(HttpSession session, @RequestBody Game game) throws Exception {
        User user = (User)session.getAttribute("user");

        if (user == null) {
            throw new Exception("Unable to add game without an active user in the session");
        }
        game.user = user;

        games.save(game);

        return getAllGames();
    }

}
