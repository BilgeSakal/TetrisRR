package piece;

public class PieceL extends Piece {
	
	/*
	 *    X
	 *    X
	 *    X X
	 */

	@Override
	public void generatePiece() {
		piecePoints[0] = new BoardPoint(boardwidth / 2, 0);
		piecePoints[1] = new BoardPoint(boardwidth / 2, 1);
		piecePoints[2] = new BoardPoint(boardwidth / 2, 2);
		piecePoints[3] = new BoardPoint(boardwidth / 2 + 1, 2);
	}

}
