package piece;

public class PieceL extends Piece {
	
	/*
	 *    1      1 0 2    1 2        1
	 *    0      3          0    2 0 3
	 *    2 3               3
	 */

	@Override
	public void generatePiece() {
		super.generatePiece();
		switch (r) {
		case 0:
			piecePoints[0] = new BoardPoint(boardwidth / 2, 1);
			piecePoints[1] = new BoardPoint(boardwidth / 2, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2, 2);
			piecePoints[3] = new BoardPoint(boardwidth / 2 + 1, 2);
			break;
		case 1:
			piecePoints[0] = new BoardPoint(boardwidth / 2, 0);
			piecePoints[1] = new BoardPoint(boardwidth / 2 - 1, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2 + 1, 0);
			piecePoints[3] = new BoardPoint(boardwidth / 2 - 1, 1);
			break;
		case 2:
			piecePoints[0] = new BoardPoint(boardwidth / 2, 1);
			piecePoints[1] = new BoardPoint(boardwidth / 2 - 1, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2, 0);
			piecePoints[3] = new BoardPoint(boardwidth / 2, 2);
			break;
		case 3:
			piecePoints[0] = new BoardPoint(boardwidth / 2, 1);
			piecePoints[1] = new BoardPoint(boardwidth / 2 + 1, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2 - 1, 1);
			piecePoints[3] = new BoardPoint(boardwidth / 2 + 1, 1);
			break;
		}
	}

}
