package piece;

import enums.TetrisDirectionsEnum;

public abstract class Piece {

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
	public void rotate(TetrisDirectionsEnum direction) {
		// TODO b�t�n par�alar i�in ortak bir rotate yazabiliriz bence. par�an�n x ve y
		// lerinin orta noktas�n� bulup onun etraf�nda 90 derece d�nd�rebiliriz b�t�n
		// noktalar�.
	}

	public Piece move(TetrisDirectionsEnum direction) {
		// TODO implement this method
		return null;
	}

}
