package lol.gilliard.battlesnakejava.dtsnake.board;

import lol.gilliard.battlesnakejava.Coord;
import lol.gilliard.battlesnakejava.Requests;

public class Snake {
    public Coord head;
    public Coord[] body;

    public Snake(Requests.Battlesnake you) {
        head = you.head();
        body = you.body();
    }
}
