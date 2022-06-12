package lol.gilliard.battlesnakejava.dtsnake.board;

import lol.gilliard.battlesnakejava.Coord;
import lol.gilliard.battlesnakejava.Requests;

import static lol.gilliard.battlesnakejava.Requests.GameState;

// TODO: can this be a record?
public class ParsedBoard {
    public Snake me;

    int width, height;
    private final CellContent[][] cellContents;

    public ParsedBoard(GameState gameState) {

        width = gameState.board().width();
        height = gameState.board().height();

        cellContents = createCellContents(gameState);

        me = new Snake(gameState.you());

    }

    private CellContent[][] createCellContents(GameState state) {
        CellContent[][] contents = new CellContent[state.board().width()][state.board().height()];

        // add other snakes
        for (Requests.Battlesnake snake : state.board().snakes()) {
            for (Coord coord : snake.body()) {
                contents[coord.x()][coord.y()] = CellContent.otherBody;
            }
            contents[snake.head().x()][snake.head().y()] = CellContent.otherHead;
        }

        // add myself
        for (Coord coord : state.you().body()) {
            contents[coord.x()][coord.y()] = CellContent.myBody;
        }
        contents[state.you().head().x()][state.you().head().y()] = CellContent.myHead;


        // add food
        for (Coord coord : state.board().food()) {
            contents[coord.x()][coord.y()] = CellContent.food;
        }

        return contents;
    }

    public boolean isSafe(Coord coord) {
        return isInBounds(coord) && cellContents[coord.x()][coord.y()] == null;
    }

    private boolean isInBounds(Coord coord) {
        return coord.x() >= 0 && coord.y() >= 0 && coord.x() < width && coord.y() < height;
    }
}
