package piece;

public class PieceT extends Piece {
	
	/*
	 *    X
	 *    X X
	 *    X
	 */

	@Override
	public void generatePiece() {
			piecePoints[0] = new BoardPoint(boardwidth / 2, 1);
			piecePoints[1] = new BoardPoint(boardwidth / 2, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2 + 1, 1);
			piecePoints[3] = new BoardPoint(boardwidth / 2, 2);
	}

}
