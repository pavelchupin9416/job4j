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
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    public boolean isDiagonal(Cell source, Cell dest) {

        boolean  result =  (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) ? true : false;
        return result;
    }


    public boolean isStraight(Cell source, Cell dest) {

        boolean  result =  (Math.abs(source.x - dest.x) == 0 || Math.abs(source.y - dest.y) == 0) ? true : false;
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
        if (!isDiagonal(source, dest) && !isStraight(source, dest)) {
            throw new ImpossibleMoveException("Impossible Move Exception");
        }
        Cell[] steps = new Cell[0];
        if (isDiagonal(source, dest)) {
            steps = new Cell[Math.abs(source.x - dest.x)];
            int deltaX = (source.x - dest.x > 0) ? -1 : 1;
            int deltaY = (source.y - dest.y > 0) ? -1 : 1;
            for (int i = 0; i < steps.length; i++) {
                steps[i] = step(source.x + deltaX * (i + 1), source.y + deltaY * (i + 1));
            }
        }

        if (isStraight(source, dest)) {
        int deltaX = 0;
        int deltaY = 0;
        int stp = 0;
        if (source.x - dest.x != 0) {
            stp = Math.abs(source.x - dest.x);
            deltaX = (source.x - dest.x > 0) ? -1 : 1;
        } else {
            stp = Math.abs(source.y - dest.y);
            deltaY = (source.y - dest.y > 0) ? -1 : 1;
        }
         steps = new Cell[stp];

        for (int i = 0; i < steps.length; i++) {
            steps[i] = step(source.x + deltaX * (i + 1), source.y + deltaY * (i + 1));
        }
       }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
