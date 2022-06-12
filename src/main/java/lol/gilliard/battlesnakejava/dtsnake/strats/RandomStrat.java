package lol.gilliard.battlesnakejava.dtsnake.strats;

import lol.gilliard.battlesnakejava.Coord;

import java.util.Random;

public class RandomStrat extends Strat {

    private final Random rand = new Random();

    @Override
    public double score(Coord start) {
        return rand.nextDouble();
    }
}
