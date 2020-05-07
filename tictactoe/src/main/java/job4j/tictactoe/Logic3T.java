package job4j.tictactoe;

import java.util.function.Predicate;
import java.util.*;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    public boolean isWinner(Predicate<Figure3T> predicate) {
        boolean winner;
        winner = this.fillBy(predicate, this.table.length - 1, 0, -1, 1)
                || this.fillBy(predicate, 0, 0, 1, 1);
        if(!winner) {
        for (int i = 0; i < this.table.length; i++) {
            if (this.fillBy(predicate, i, 0, 0, 1)
                    || this.fillBy(predicate, 0, i, 1, 0)) {
                winner = true;
                break;
            }
        }}
        return winner;
    }


    public boolean hasGap() {
        return !(this.table.length * this.table.length
                == Arrays.stream(this.table).flatMap(Arrays::stream).takeWhile(i->i.hasMarkO() || i.hasMarkX()).count());
    }
}
