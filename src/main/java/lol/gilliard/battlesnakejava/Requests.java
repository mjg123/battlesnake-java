package lol.gilliard.battlesnakejava;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Requests {

    record GameState(
            Game game,
            int turn,
            Board board,
            Battlesnake you
    ) {
    }

    record Game(String id,
                Ruleset ruleset,
                long timeout) {
    }

    record Ruleset(String name,
                   String version,
                   Settings settings) {
    }

    record Settings(
            long foodSpawnChance,
            long minimumFood,
            long hazardDamagePerTurn,
            Royale royale,
            Squad squad
    ) {
    }

    record Royale(long shrinkEveryNTurns) {
    }

    record Squad(boolean allowBodyCollisions,
                 boolean sharedElimination,
                 boolean sharedHealth,
                 boolean sharedLength) {
    }

    record Board(int height,
                 int width,
                 Coord[] food,
                 Battlesnake[] snakes,
                 Coord[] hazards) {
    }

    record Battlesnake(String id,
                       String name,
                       long health,
                       Coord[] body,
                       Coord head,
                       long length,
                       String latency,
                       String shout,
                       String squad) {
    }

    record Coord(int x, int y) {
    }

}
