package lol.gilliard.battlesnakejava;

public record Coord(int x, int y) {
    public Coord right(){return new Coord(x+1, y);}
    public Coord left(){return new Coord(x-1, y);}
    public Coord up(){return new Coord(x, y+1);}
    public Coord down(){return new Coord(x, y-1);}

    public Coord move(Direction dir) {
        return switch (dir) {
            case right -> right();
            case left -> left();
            case up -> up();
            case down -> down();
        };
    }
}
