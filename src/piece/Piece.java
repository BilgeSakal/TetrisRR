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
		Piece newPiece = null;
		try {
			newPiece = (Piece) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		double xWeight = 0;
		double yWeight = 0;
		for (int i = 0; i < piecePoints.length; ++i) {
			xWeight += (double) piecePoints[i].getX();
			yWeight += (double) piecePoints[i].getY();
		}
		xWeight /= piecePoints.length;
		yWeight /= piecePoints.length;
		
		for (int i = 0; i < piecePoints.length; ++i) {
			double x = (double) piecePoints[i].getX();
			double y = (double) piecePoints[i].getY();
			x -= xWeight; y -= yWeight;
			
			double temp = x;
			switch (direction) {
			case LEFT:
				x = -y;
				y = temp;
				break;
			case RIGHT:
				x = y;
				y = -temp;
				break;
			default:
				break;
			}
			
			x += xWeight;
			y += yWeight;
			
			newPiece.piecePoints[i] = new BoardPoint((int) x, (int) y);
		}
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
	
	public BoardPoint[] getPiecePoints() {
		return piecePoints;
	}

}
