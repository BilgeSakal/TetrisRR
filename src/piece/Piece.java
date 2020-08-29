package piece;

import java.util.ArrayList;

import enums.TetrisDirectionsEnum;

public abstract class Piece {

	public static int boardwidth = 12;
	protected ArrayList<BoardPoint> piecePoints;

	public Piece() {
		piecePoints = new ArrayList<BoardPoint>();
		generatePiece();
	}

	/**
	 * This method determines if there is at least one negative value at y
	 * coordinate or not. This method assists the constructor of this class.
	 * 
	 * @return boolean result
	 */
	public boolean isThereNegativeAtY() {
		for (int i = 0; i < piecePoints.size(); ++i) {
			if (piecePoints.get(i).getY() < 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Generates piecePoint array.
	 */
	public abstract void generatePiece();

	/**
	 * Rotates the copy of "Piece" and returns rotated "Piece" object.
	 * 
	 * @param direction direction of the rotation RIGHT means clockwise LEFT means
	 *                  counter clockwise
	 * 
	 * @return 90 degrees rotated "Piece" object
	 */
	public Piece rotate(TetrisDirectionsEnum direction) { // TODO TEST IT
		Piece newPiece = null;
		try {
			newPiece = (Piece) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		double xWeight = 0;
		double yWeight = 0;
		for (int i = 0; i < piecePoints.size(); ++i) {
			xWeight += piecePoints.get(i).getX();
			yWeight += piecePoints.get(i).getY();
		}
		xWeight /= piecePoints.size();
		yWeight /= piecePoints.size();

		for (int i = 0; i < piecePoints.size(); ++i) {
			double x = piecePoints.get(i).getX();
			double y = piecePoints.get(i).getY();
			x -= xWeight;
			y -= yWeight;

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

			newPiece.piecePoints.set(i, new BoardPoint((int) x, (int) y));
		}
		return newPiece;
	}

	/**
	 * Moves the copy of "Piece" and returns moved "Piece" object.
	 * 
	 * @param direction direction of the rotation
	 * @return 90 degrees moved "Piece" object
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
			for (BoardPoint point : newPiece.piecePoints) {
				point.incrementY();
			}
			break;
		case LEFT:
			for (BoardPoint point : newPiece.piecePoints) {
				point.decrementX();
			}
			break;
		case RIGHT:
			for (BoardPoint point : newPiece.piecePoints) {
				point.incrementX();
			}
			break;
		}
		return newPiece;
	}

	// GETTERS AND SETTERS

	public ArrayList<BoardPoint> getPiecePoints() {
		return piecePoints;
	}

	protected void setPiecePoints(ArrayList<BoardPoint> piecePoints) {
		this.piecePoints = piecePoints;
	}

}
