package piece;

import enums.TetrisDirectionsEnum;

public abstract class Piece {

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
	public void rotate(TetrisDirectionsEnum direction) {
		// TODO bütün parçalar için ortak bir rotate yazabiliriz bence. parçanýn x ve y
		// lerinin orta noktasýný bulup onun etrafýnda 90 derece döndürebiliriz bütün
		// noktalarý.
	}

	public Piece move(TetrisDirectionsEnum direction) {
		// TODO implement this method
		return null;
	}

}
