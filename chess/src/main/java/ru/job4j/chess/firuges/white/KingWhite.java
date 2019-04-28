package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite implements Figure {
    private final Cell position;

    public KingWhite(final Cell position) {
        this.position = position;
    }

    public boolean isSquare(Cell source, Cell dest) {

        boolean  result =  (Math.abs(source.x - dest.x) == 1 || Math.abs(source.y - dest.y) == 1) ? true : false;
        return result;
    }



    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

        if (!isSquare(source, dest)) {
            throw new ImpossibleMoveException("Impossible Move Exception");
        }

        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
