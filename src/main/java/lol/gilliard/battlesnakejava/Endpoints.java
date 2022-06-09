package lol.gilliard.battlesnakejava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static lol.gilliard.battlesnakejava.Responses.*;
import static lol.gilliard.battlesnakejava.Requests.*;

@RestController
public class Endpoints {

    private static final BattleSnakeInfo MY_BATTLESNAKE = new Responses.BattleSnakeInfo("1", "mjg123", "#F22F46", "default", "default", "0.0.1");

    @GetMapping(value = "/", produces = "application/json")
    public BattleSnakeInfo getInfo(){
        return MY_BATTLESNAKE;
    }

    @PostMapping("/start")
    public String start(){
        return "";
    }

    @PostMapping("/end")
    public String end(){
        return "";
    }

    @PostMapping("/move")
    public Move move(@RequestBody GameState gameState){
        System.out.println("Turn " + gameState.turn());
        return new Move(Direction.right);
    }

}
