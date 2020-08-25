package piece;

import enums.TetrisDirectionsEnum;

public abstract class Piece {
	
	public static int boardwidth = 12;
	protected BoardPoint[] piecePoints;

	public Piece() {
		generatePiece();
	}

	/**
	 * piecePoints arrayini oluþturmak için
	 */
	public abstract void generatePiece();

	/**
	 * 
	 * @param direction
	 */
	public Piece rotate(TetrisDirectionsEnum direction) {
		// TODO bütün parçalar için ortak bir rotate yazabiliriz bence. parçanýn x ve y
		// lerinin orta noktasýný bulup onun etrafýnda 90 derece döndürebiliriz bütün
		// noktalarý.
		
		// The center of the rotation is zero's index
		
		// TODO Henüz tamamlanmadý, üzerinde düþünüyorum.
		// Not: (0,0) orjinin etrafýndaki bir noktanýn 90 derece saat yönüne döndürmesi 
		// formülü (x,y) => (-y,x)
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
