package lol.gilliard.battlesnakejava;

public class Requests {

    public record GameState(
            Game game,
            int turn,
            Board board,
            Battlesnake you
    ) {
    }

    public record Game(String id,
                Ruleset ruleset,
                long timeout) {
    }

    public record Ruleset(String name,
                   String version,
                   Settings settings) {
    }

    public record Settings(
            long foodSpawnChance,
            long minimumFood,
            long hazardDamagePerTurn,
            Royale royale,
            Squad squad
    ) {
    }

    public record Royale(long shrinkEveryNTurns) {
    }

    public record Squad(boolean allowBodyCollisions,
                 boolean sharedElimination,
                 boolean sharedHealth,
                 boolean sharedLength) {
    }

    public record Board(int height,
                 int width,
                 Coord[] food,
                 Battlesnake[] snakes,
                 Coord[] hazards) {
    }

    public record Battlesnake(String id,
                       String name,
                       long health,
                       Coord[] body,
                       Coord head,
                       long length,
                       String latency,
                       String shout,
                       String squad) {
    }

}
