package lol.gilliard.battlesnakejava;

public interface MoveStrategy {
    Direction bestDirection(Requests.GameState gameState);
}
