package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    public boolean isG(Cell source, Cell dest) {

        boolean  result = false;

        if (dest == step(source.x + 1, source.y - 2)
                || dest == step(source.x - 1, source.y - 2)
                || dest == step(source.x + 1, source.y + 2)
                || dest == step(source.x - 1, source.y + 2)
                || dest == step(source.x + 2, source.y - 1)
                || dest == step(source.x + 2, source.y + 1)
                || dest == step(source.x - 2, source.y - 1)
                || dest == step(source.x - 2, source.y + 1)) {
            result = true;
        }
        return result;
    }

    private Cell step(int x, int y) {
        Cell rst = Cell.A1;
        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                rst = cell;
                break;
            }
        }
        return rst;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

        if (!isG(source, dest)) {
            throw new ImpossibleMoveException("Impossible Move Exception");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
