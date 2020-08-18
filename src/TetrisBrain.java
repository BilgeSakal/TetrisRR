
public class TetrisBrain {

	private Piece curPiece;
	private Piece nextPiece;
	private TetrisBoard tetrisBoard;
	private DropTimer dropTimer;
	private int boardWidth;
	private int boardHeight;

	public void movePiece(TetrisDirectionsEnum direction) {
		Piece ghostPiece = ghostMove(curPiece, direction);
		if (isOutOfBounds(ghostPiece)) {
			return;
		} else if (isHit(ghostPiece)) {
			placePiece(curPiece);
			curPiece = nextPiece;
			nextPiece = getRandomPiece();
		} else {
			curPiece = ghostPiece;
		}
		// notify fronten
	}

	private Piece ghostMove(Piece piece, TetrisDirectionsEnum direction) {
		return null;
	}

	private boolean isOutOfBounds(Piece piece) {
		return false;
	}

	private void placePiece(Piece piece) {
		// add the piece to the board
		if (isGameFinished()) {
			finishGame();
		} else {
			checkRows();
		}
	}

	private void finishGame() {

	}

	private void checkRows() {
		for (int rowNumber = boardHeight - 1; rowNumber >= 0; --rowNumber) {
			if (isRowFull(rowNumber)) {
				deleteRow(rowNumber);
			}
		}
		collapseRows();
	}

	public void deleteRow(int rowNumber) {
	}

	public void rotatePiece(TetrisDirectionsEnum direction) {
	}

	public Piece getRandomPiece() {
		return null;
	}

	public boolean isHit(final Piece piece) {
		return false;
	}

	public boolean isGameFinished() {
		return false;
	}

	public boolean isRowFull(int rowNumber) {
		return false;
	}

	public boolean isRowEmpty(int rowNumber) {
		return false;
	}

	public void collapseRows() {
	}

}
