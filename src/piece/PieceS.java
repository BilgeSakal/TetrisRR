package piece;

import java.util.Random;

public class PieceS extends Piece {
	
	/*
	 *      0 1    1
	 *    2 3      0 2
	 *               3
	 */

	@Override
	public void generatePiece() {
		Random random = new Random();
		int r = random.nextInt(4);
		switch (r) {
		case 0:
			piecePoints[0] = new BoardPoint(boardwidth / 2, 0);
			piecePoints[1] = new BoardPoint(boardwidth / 2 + 1, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2 - 1, 1);
			piecePoints[3] = new BoardPoint(boardwidth / 2, 1);
			break;
		case 1:
			piecePoints[0] = new BoardPoint(boardwidth / 2, 1);
			piecePoints[1] = new BoardPoint(boardwidth / 2, 0);
			piecePoints[2] = new BoardPoint(boardwidth / 2 + 1, 1);
			piecePoints[3] = new BoardPoint(boardwidth / 2 + 1, 2);
			break;
		}
	}

}
