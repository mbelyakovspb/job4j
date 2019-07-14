package ru.job4j.chess;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

public class Bishop extends Figure {
    public Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        int deltaX = dest.x - source.x < 0 ? -1 : 1;
        int deltaY = dest.y - source.y < 0 ? -1 : 1;
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            for (int index = 1; index <= steps.length; index++) {
                int x = source.x + (index + 1) * deltaX;
                int y = source.y + (index + 1) * deltaY;
                steps[index - 1] = Cell.values()[8 * y + x];
            }
        } else {
            throw new ImpossibleMoveException("Фигура не может так ходить!");
        }
        return steps;
    }

    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
