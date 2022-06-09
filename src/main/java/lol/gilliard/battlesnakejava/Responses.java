package lol.gilliard.battlesnakejava;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Responses {

    public record BattleSnakeInfo(String apiversion,
                                  String author,
                                  String color,
                                  String head,
                                  String tail,
                                  String version) {
    }

    public enum Direction {
        up, down, left, right;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Move(Direction move, String shout) {
        public Move(Direction move){
            this(move, null);
        }
    }
}
