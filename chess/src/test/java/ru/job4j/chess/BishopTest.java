package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.exception.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopTest {
    /**
     * Тест перемещения из H3 в E6.
     */
    @Test
    public void tryMoveBishopFromH3ToE6() {
        Board board = new Board();
        Cell source = Cell.H3;
        Cell dist = Cell.E6;
        board.add(new Bishop(source));
        assertThat(board.move(source, dist), is(true));
    }
    /**
     * Тест выбрасывания исключения OccupiedWayException.
     * При перемещении из H3 в E6 путь перекрыт другой фигурой G4.
     * @throws OccupiedWayException исключение, если путь фигуры перекрыт другой.
     */
    @Test
    public void moveBishopToOccupiedCell() {
        Board board = new Board();
        Cell source = Cell.H3;
        Cell block = Cell.G4;
        Cell dist = Cell.E6;
        board.add(new Bishop(source));
        board.add(new Bishop(block));
        try {
            assertThat(board.move(source, dist), is(true));
        }
        catch (OccupiedWayException exc) {
        }
    }
    /**
     * Тест выбрасывания исключения FigureNotFoundException.
     * Фигуры в ячейке source нет.
     * @throws FigureNotFoundException исключение, если в source не найдена фигура.
     */
    @Test
    public void tryMoveFigureFromEmptyCell() {
        Board board = new Board();
        Cell source = Cell.H3;
        Cell dist = Cell.E6;
        try {
            assertThat(board.move(source, dist), is(true));
        }
        catch (FigureNotFoundException exc) {
        }
    }
    /**
     * Тест выбрасывания исключения ImpossibleMoveException.
     * Пытаемся переместить слона из H3 в G3.
     * @throws ImpossibleMoveException исключение, если фигура не может так ходить.
     */
    @Test
    public void tryIllegalMoveForBishop() {
        Board board = new Board();
        Cell source = Cell.H3;
        Cell dist = Cell.G3;
        board.add(new Bishop(source));
        board.add(new Bishop(dist));
        try {
            assertThat(board.move(source, dist), is(true));
        }
        catch (ImpossibleMoveException exc) {
        }
    }

    @Test
    public void testForWay() {
        Board board = new Board();
        Cell source = Cell.H3;
        Cell dist = Cell.E6;
        board.add(new Bishop(source));
        board.add(new Bishop(dist));
        Cell[] steps = new Cell[]{Cell.E6,Cell.F5, Cell.G4};
        try {
            assertThat((new Bishop(source).way(source, dist)), is(steps));
        } catch (ImpossibleMoveException exception) {}
    }
}