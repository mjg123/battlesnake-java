package lol.gilliard.battlesnakejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static lol.gilliard.battlesnakejava.Requests.GameState;
import static lol.gilliard.battlesnakejava.Responses.BattleSnakeInfo;
import static lol.gilliard.battlesnakejava.Responses.Move;

@RestController
public class Endpoints {

    private static final BattleSnakeInfo MY_BATTLESNAKE = new Responses.BattleSnakeInfo("1", "mjg123", "#F22F46", "bendr", "round-bum", "0.0.1");
    private final MoveStrategy strat;

    @Autowired
    public Endpoints(MoveStrategy strat){
        this.strat = strat;
    }

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
        System.out.println("\n---------------");
        System.out.println("Turn " + gameState.turn());
        Move move = new Move(strat.bestDirection(gameState));
        System.out.println(move);
        return move;
    }

}
