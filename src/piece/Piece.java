package piece;

import enums.TetrisDirectionsEnum;

public abstract class Piece {
	
	public static int boardwidth = 12;
	protected BoardPoint[] piecePoints;

	public Piece() {
		generatePiece();
	}

	/**
	 * piecePoints arrayini olu�turmak i�in
	 */
	public abstract void generatePiece();

	/**
	 * 
	 * @param direction
	 */
	public Piece rotate(TetrisDirectionsEnum direction) {
		// TODO b�t�n par�alar i�in ortak bir rotate yazabiliriz bence. par�an�n x ve y
		// lerinin orta noktas�n� bulup onun etraf�nda 90 derece d�nd�rebiliriz b�t�n
		// noktalar�.
		
		// The center of the rotation is zero's index
		
		// TODO Hen�z tamamlanmad�, �zerinde d���n�yorum.
		// Not: (0,0) orjinin etraf�ndaki bir noktan�n 90 derece saat y�n�ne d�nd�rmesi 
		// form�l� (x,y) => (-y,x)
		Piece newPiece = this;
		switch (direction) {
		case LEFT:
			break;
		case RIGHT:
			for (int i = 1; i < piecePoints.length; ++i) {
				int xDistance = piecePoints[0].getX() - piecePoints[i].getX();
				int yDistance = piecePoints[0].getY() - piecePoints[i].getY();
				piecePoints[i].decrementX(xDistance);
				piecePoints[i].decrementY(yDistance);
				//int newX = 
			}
			break;
		}
		return newPiece;
	}

	public Piece move(TetrisDirectionsEnum direction) {
		Piece newPiece = this;
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
