package tetris;

import java.util.Random;

import enums.TetrisDirectionsEnum;
import piece.Piece;

public class TetrisBrain {

	private static final Random RANDOM = new Random();

	private Piece curPiece;
	private Piece nextPiece;
	private TetrisBoard tetrisBoard;
	private DropTimer dropTimer;
	private int boardWidth;
	private int boardHeight;

	/**
	 * 
	 * @param direction move direction
	 */
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
		// TODO notify front-end
	}

	/**
	 * 
	 * @param piece     to be moved.
	 * @param direction move direction.
	 * @return new piece that moved in the given direction.
	 */
	private Piece ghostMove(final Piece piece, TetrisDirectionsEnum direction) {
		return piece.move(direction);
	}

	/**
	 * 
	 * @param piece to be checked if it is out of bounds (left-right bounds).
	 * @return {@code true} if <b>piece</b> is out of bounds, {@code false}
	 *         otherwise.
	 */
	private boolean isOutOfBounds(Piece piece) {
		return tetrisBoard.isOutOfBounds(piece);
	}

	private void placePiece(Piece piece) {
		tetrisBoard.placePiece(piece);
		if (isGameFinished()) {
			finishGame();
		} else {
			checkRows();
		}
	}

	private void finishGame() {
		// TODO implement this method
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
		tetrisBoard.deleteRow(rowNumber);
	}

	public void rotatePiece(TetrisDirectionsEnum direction) {
		curPiece.rotate(direction);
	}

	public Piece getRandomPiece() {
		Piece randomPiece = Piece.getRandomPiece();
		int randomRotate = RANDOM.nextInt(4);
		for (int i = 0; i < randomRotate; ++i) {
			randomPiece = randomPiece.rotate(TetrisDirectionsEnum.RIGHT);
		}
		while (randomPiece.isThereNegativeAtY()) {
			randomPiece = randomPiece.move(TetrisDirectionsEnum.DOWN);
		}
		return randomPiece;
	}

	public boolean isHit(final Piece piece) {
		return tetrisBoard.isHit(piece);
	}

	public boolean isGameFinished() {
		// TODO implement this method
		return false;
	}

	public boolean isRowFull(int rowNumber) {
		return tetrisBoard.isRowFull(rowNumber);
	}

	public boolean isRowEmpty(int rowNumber) {
		return tetrisBoard.isRowEmpty(rowNumber);
	}

	public void collapseRows() {
		tetrisBoard.collapseRows();
	}

}
