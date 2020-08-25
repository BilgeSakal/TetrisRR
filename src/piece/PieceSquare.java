package piece;

public class PieceSquare extends Piece {
	
	/*
	 *    0 1
	 *    2 3
	 */

	@Override
	public void generatePiece() {
		piecePoints[0] = new BoardPoint(boardwidth / 2, 0);
		piecePoints[1] = new BoardPoint(boardwidth / 2 + 1, 0);
		piecePoints[2] = new BoardPoint(boardwidth / 2, 1);
		piecePoints[3] = new BoardPoint(boardwidth / 2 + 1, 1);
	}

}
