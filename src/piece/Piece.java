package piece;

import java.util.Random;

import enums.TetrisDirectionsEnum;

public abstract class Piece {
	
	public static int boardwidth = 12;
	protected BoardPoint[] piecePoints;

	public Piece() {
		Random random = new Random();
		int r = random.nextInt(4);
		piecePoints = new BoardPoint[4];
		generatePiece();
		
		// Rotates the piece randomly.
		for (int i = 0; i < r; ++i) {
			rotate(TetrisDirectionsEnum.RIGHT);
		}
		
		// Fixes the coordinates if there are negative y coordinates.
		while (isThereNegativeAtY()) {
			move(TetrisDirectionsEnum.DOWN);
		}
	}
	
	/**
	 * This method determines if there is at least one negative value at y 
	 * coordinate or not. This method assists the constructor of this class.
	 * 
	 * @return    boolean result
	 */
	private boolean isThereNegativeAtY() {
		for (int i = 0; i < piecePoints.length; ++i) {
			if (piecePoints[i].getY() < 0) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * piecePoints arrayini oluþturmak için
	 */
	public abstract void generatePiece();

	/**
	 * Rotates the copy of "Piece" and returns rotated "Piece" object.
	 * 
	 * @param direction    direction of the rotation
	 *                     RIGHT means clockwise
	 *                     LEFT means counter clockwise
	 *                     
	 * @return             90 degrees rotated "Piece" object
	 */
	public Piece rotate(TetrisDirectionsEnum direction) { // TODO  TEST IT
		// STEP 1: Create new piece.
		Piece newPiece = null;
		try {
			newPiece = (Piece) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		// STEP 2: Change the all integers to double data type.
		int n = piecePoints.length;
		DoubleBoardPoint[] doublePiecePoints = new DoubleBoardPoint[n];
		for (int i = 0; i < n; ++i) {
			doublePiecePoints[i] = new DoubleBoardPoint(piecePoints[i].getX(), piecePoints[i].getY());
		}
		
		// STEP 3: Find center of piece using find averages of all the x and y coordinates.
		double xWeight = 0;
		double yWeight = 0;
		for (int i = 0; i < n; ++i) {
			xWeight += doublePiecePoints[i].getX();
			yWeight += doublePiecePoints[i].getY();
		}
		xWeight /= n;
		yWeight /= n;
		
		// STEP 4: Shift all coordinates with the center of the piece is origin.
		for (int i = 0; i < n; ++i) {
			doublePiecePoints[i].decrementX(xWeight);
			doublePiecePoints[i].decrementY(yWeight);
		}
		
		// STEP 5: Rotate the piece 90 degrees from the origin.
		for (int i = 0; i < n; ++i) {
			double temp = doublePiecePoints[i].getX();
			switch (direction) {
			case LEFT:
				doublePiecePoints[i].setX(-doublePiecePoints[i].getY());
				doublePiecePoints[i].setY(temp);
				break;
			case RIGHT:
				doublePiecePoints[i].setX(doublePiecePoints[i].getY());
				doublePiecePoints[i].setY(-temp);
				break;
			default:
				break;
			}
		}
		
		// STEP 6: Shift all coordinates to the real locations and move those the new piece as integer.
		for (int i = 0; i < n; ++i) {
			doublePiecePoints[i].incrementX(xWeight);
			doublePiecePoints[i].incrementY(yWeight);
			newPiece.piecePoints[i] = new BoardPoint((int)doublePiecePoints[i].getX(), (int)doublePiecePoints[i].getY());
		}
		
		// STEP 7: Return the new piece.
		return newPiece;
	}

	/**
	 * Moves the copy of "Piece" and returns moved "Piece" object.
	 * 
	 * @param direction    direction of the rotation
	 * @return             90 degrees moved "Piece" object
	 */
	public Piece move(TetrisDirectionsEnum direction) {
		Piece newPiece = null;
		try {
			newPiece = (Piece) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		switch (direction) {
		case DOWN:
			for (int i = 0; i < piecePoints.length; ++i) {
				newPiece.piecePoints[i].incrementY();
			}
			break;
		case LEFT:
			for (int i = 0; i < piecePoints.length; ++i) {
				newPiece.piecePoints[i].decrementX();
			}
			break;
		case RIGHT:
			for (int i = 0; i < piecePoints.length; ++i) {
				newPiece.piecePoints[i].incrementX();
			}
			break;
		}
		return newPiece;
	}

}
