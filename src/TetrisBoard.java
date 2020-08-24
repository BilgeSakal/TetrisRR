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

	public TetrisBoard(int boardWidht, int boardLength) {
		setBoardWidht(boardWidht);
		setBoardLenght(boardLength);
		board = new boolean[boardWidht][boardLength];
	}

	public boolean isRowFull(int rowNumber) {
		for (int i = 0; i < boardWidht; ++i) {
			if (!board[rowNumber][i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isRowEmpty(int rowNumber) {
		for (int i = 0; i < boardWidht; ++i) {
			if (board[rowNumber][i]) {
				return false;
			}
		}
		return true;
	}

	public void deleteRow(int rowNumber) {
		for (int i = 0; i < boardWidht; ++i) {
			board[rowNumber][i] = false;
		}
	}

	public void placePiece(Piece piece) {
		// TODO implement this method
	}

	public void collapseRows() {
		// TODO implement this method
	}

	public boolean isOutOfBounds(Piece piece) {
		// TODO implement this method
		return false;
	}

	public boolean isHit(Piece piece) {
		// TODO implement this method
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

}
