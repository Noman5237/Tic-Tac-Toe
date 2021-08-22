package game.tictactoe.models;

import game.tictactoe.models.states.CellState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
	
	private Board board;
	
	@BeforeEach
	void setUp() {
		this.board = new Board();
	}
	
	@ParameterizedTest (name = "set board[{0}][{1}] = {2} and assert board[{0}][{1}] == {2}")
	@CsvSource ({
			"1, 2, X",
			"2, 1, O",
			"0, 1, X",
			"0, 0, O"
	})
	void testGetNSetCellState(int x, int y, CellState cellState) {
		this.board.setCellState(x, y, cellState);
		assertEquals(cellState, this.board.getCellState(x, y));
	}
	
	@Test
	@DisplayName ("all cell states of initial board is empty")
	void testBoardIsEmptyAtStart() {
		for (int y = 0; y < Board.SIZE; y++) {
			for (int x = 0; x < Board.SIZE; x++) {
				assertEquals(CellState.EMPTY, this.board.getCellState(x, y));
			}
		}
	}
	
	@Test
	@DisplayName ("board status")
	void testBoardStatus() {
	
	}
}
