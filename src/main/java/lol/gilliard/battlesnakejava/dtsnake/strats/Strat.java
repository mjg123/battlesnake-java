package lol.gilliard.battlesnakejava.dtsnake.strats;

import lol.gilliard.battlesnakejava.Coord;

public abstract class Strat {
    double weight = 1;

    public final Strat weighted(double weight){
        this.weight = weight;
        return this;
    }

    public final StratResult scoreGivenStart(Coord start){
        return new StratResult(this.getClass().getSimpleName(),this.score(start) * weight);
    }

    protected abstract double score(Coord start);

    public record StratResult(String name, double score) {
    }
}
