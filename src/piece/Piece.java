package piece;

import java.util.Random;

import enums.TetrisDirectionsEnum;

public abstract class Piece {
	
	public static int boardwidth = 12;
	protected int r = -1;
	protected BoardPoint[] piecePoints;

	public Piece() {
		generatePiece();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * piecePoints arrayini oluþturmak için
	 */
	public void generatePiece() {
		Random random = new Random();
		int r = random.nextInt(4);
	}

	/**
	 * 
	 * @param direction
	 */
	public Piece rotate(TetrisDirectionsEnum direction) {
		// TODO  Henüz test etmedim, test edilmesi gerekiyor, yanlýþ olabilir.
		Piece newPiece = null;
		try {
			newPiece = (Piece) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		// STEP 0: Find distances to make future operations simply.
		int xDistance = piecePoints[0].getX();
		int yDistance = piecePoints[0].getY();
		
		for (int i = 1; i < piecePoints.length; ++i) {
			// STEP 1: Subtract the points to rotate them from the origin.
			piecePoints[i].decrementX(xDistance);
			piecePoints[i].decrementY(yDistance);
			
			// STEP 2: Rotate from origin.
			// For  90 degrees clockwise, (x,y) -> (-y,x)
			// For 270 degrees clockwise, (x,y) -> (y,-x), (or 90 degrees counter clockwise)
			int temp = piecePoints[i].getX();
			switch (direction) {
			case LEFT:
				piecePoints[i].setX(-temp);
				piecePoints[i].setY(piecePoints[i].getX());
				break;
			case RIGHT:
				piecePoints[i].setX(-piecePoints[i].getY());
				piecePoints[i].setY(temp);
				break;
			default:
				break;
			}
			
			// STEP 3: Turn them to the real points using addition operation.
			piecePoints[i].incrementX(xDistance);
			piecePoints[i].incrementY(yDistance);
		}
		return newPiece;
	}

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
