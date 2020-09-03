package tetris;

import java.util.Arrays;

import piece.BoardPoint;
import piece.Piece;

public class TetrisBoard {

	private static final int DEFAULT_BOARD_WIDHT = 12;
	private static final int DEFAULT_BOARD_LENGHT = 12;

	private int boardLenght;
	private int boardWidht;
	private boolean board[][];

	public TetrisBoard() {
		this(DEFAULT_BOARD_WIDHT, DEFAULT_BOARD_LENGHT);
	}

	public TetrisBoard(int boardLength, int boardWidht) {
		setBoardWidht(boardWidht);
		setBoardLenght(boardLength);
		board = new boolean[boardLength][boardWidht];
	}

	/**
	 * Checks if the row that specified whit {@code rowNumber} is full.
	 * 
	 * @param rowNumber to be check if it is full.
	 * @return {@code true} if row is full, {@code false} otherwise.
	 */
	public boolean isRowFull(int rowNumber) {
		for (int i = 0; i < boardWidht; ++i) {
			if (!board[rowNumber][i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the row that specified with {@code rowNumber} is empty.
	 * 
	 * @param rowNumber to be check if it is empty.
	 * @return {@code true} if row is empty, {@code false} otherwise.
	 */
	public boolean isRowEmpty(int rowNumber) {
		for (int i = 0; i < boardWidht; ++i) {
			if (board[rowNumber][i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Deletes the row that specified with {@code rowNumber}.
	 * 
	 * @param rowNumber to be deleted.
	 */
	public void deleteRow(int rowNumber) {
		for (int i = 0; i < boardWidht; ++i) {
			board[rowNumber][i] = false;
		}
	}

	/**
	 * Places the {@code piece} on the board.
	 * 
	 * @param piece to be placed.
	 */
	public void placePiece(Piece piece) {
		for (BoardPoint p : piece.getPiecePoints()) {
			board[p.getX()][p.getY()] = true;
		}
	}

	/**
	 * Collapses all the empty rows.
	 */
	public void collapseRows() {
		for (int i = boardLenght - 1; i > 0; --i) {
			if (isRowEmpty(i)) {
				collapseRow(i);
			}
		}
	}

	/**
	 * Replaces the row that specified with {@code rowNubmer} with the row above.
	 * 
	 * @param rowNumber to be collapsed
	 */
	private void collapseRow(int rowNumber) {
		board[rowNumber] = Arrays.copyOf(board[rowNumber - 1], board.length);
	}

	/**
	 * Checks if the {@code piece} out of bounds (left - right).
	 * 
	 * @param piece to be checked.
	 * @return {@code true} if the {@code piece} out of bounds, {@code false}
	 *         otherwise.
	 */
	public boolean isOutOfBounds(Piece piece) {
		for (BoardPoint p : piece.getPiecePoints()) {
			if (p.getY() > boardWidht - 1 || p.getY() < 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the {@code piece} overlap with any block on the board.
	 * 
	 * @param piece to be checked.
	 * @return {@code true} if the {@code piece} overlap with any block on the
	 *         board, {@code false} otherwise.
	 */
	public boolean isHit(Piece piece) {
		for (BoardPoint p : piece.getPiecePoints()) {
			if (board[p.getY()][p.getX()]) {
				return true;
			}
		}
		return false;
	}

	// GETTERS AND SETTERS

	public int getBoardLenght() {
		return boardLenght;
	}

	public void setBoardLenght(int boardLenght) {
		this.boardLenght = boardLenght;
	}

	public int getBoardWidht() {
		return boardWidht;
	}

	public void setBoardWidht(int boardWidht) {
		this.boardWidht = boardWidht;
	}

	public boolean[][] getBoard() {
		return board;
	}

}
