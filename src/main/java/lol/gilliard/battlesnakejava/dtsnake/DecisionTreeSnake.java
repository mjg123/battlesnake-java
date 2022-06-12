package lol.gilliard.battlesnakejava.dtsnake;

import lol.gilliard.battlesnakejava.Coord;
import lol.gilliard.battlesnakejava.Direction;
import lol.gilliard.battlesnakejava.MoveStrategy;
import lol.gilliard.battlesnakejava.dtsnake.board.ParsedBoard;
import lol.gilliard.battlesnakejava.dtsnake.strats.RandomStrat;
import lol.gilliard.battlesnakejava.dtsnake.strats.Strat;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static lol.gilliard.battlesnakejava.Direction.up;
import static lol.gilliard.battlesnakejava.Direction.values;
import static lol.gilliard.battlesnakejava.Requests.GameState;

@Component
public class DecisionTreeSnake implements MoveStrategy {

    @Override
    public Direction bestDirection(GameState gameState) {
        ParsedBoard board = new ParsedBoard(gameState);
        return getDirection(board);
    }

    private Direction getDirection(ParsedBoard board) {

        // what is even possible?
        Map<Direction, List<Strat.StratResult>> candidates = possibleMoves(board);

        // tap out early if zero or one candidate
        return switch (candidates.size()) {
            case 0  -> up;                                    // no moves. we're dead, start moving to the sky in preparation
            case 1  -> candidates.keySet().iterator().next(); // take the only possible move
            default -> chooseBest(board, candidates);
        };

    }

    private Direction chooseBest(ParsedBoard board, Map<Direction, List<Strat.StratResult>> candidates) {

        // How are we going to choose?
        List<Strat> strats = List.of(new RandomStrat().weighted(1));

        // Calculate scores for each choice
        candidates.forEach((dir, results) -> {
            results.addAll(allStratResults(strats, board.me.head.move(dir)));
        });

        // Do our best!
        System.out.println(candidates);
        Direction direction = chooseBestDirection(candidates);
        return direction;
    }

    private Collection<Strat.StratResult> allStratResults(List<Strat> strats, Coord start) {
        return strats.stream()
                .map(strat -> strat.scoreGivenStart(start))
                .collect(Collectors.toList());
    }

    private Direction chooseBestDirection(Map<Direction, List<Strat.StratResult>> candidates) {
        return candidates.entrySet().stream()
                .max(Comparator.comparing(
                        entry -> entry.getValue().stream().mapToDouble(Strat.StratResult::score).sum()))
                .map(Map.Entry::getKey)
                .orElse(up);  // we don't expect to end up here (surely there is one with a best score?!) but need to handle this case anyway
    }

    private Map<Direction, List<Strat.StratResult>> possibleMoves(ParsedBoard board) {

        // EnumMap knows all possible keys at compilation time and is implemented as an array lookup w/o any hashing
        EnumMap<Direction, List<Strat.StratResult>> directionMap = new EnumMap<>(Direction.class);

        for (Direction direction : values()) {
            if (board.isSafe(board.me.head.move(direction))){
                directionMap.put(direction, new ArrayList<>());
            }
        }

        return directionMap;
    }
}
