package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.exception.*;

public class Board {

    Figure[] figures = new Figure[32];

    private int counter = 0;

    public void add(Figure figure) {
        this.figures[counter++] = figure;
    }

    public int findByFigure(Cell source) {
        int result = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position.equals(source)) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean move(Cell source, Cell dest)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int findBy = this.findByFigure(source);
        if (findBy == -1) {
            throw new FigureNotFoundException("Такой фигуры не существует в этой ячейке!");
        }
        Cell[] steps = this.figures[findBy].way(source, dest);
        for (Cell cell : steps) {
            if (findByFigure(cell) != -1) {
                throw new OccupiedWayException("Движение фигуры заблокировано другой фигурой на ее пути!");
            }
        }
        this.figures[findBy] = this.figures[findBy].copy(dest);
        return true;
    }
}
