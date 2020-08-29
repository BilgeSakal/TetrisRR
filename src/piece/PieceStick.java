package piece;

import java.util.ArrayList;

public class PieceStick extends Piece {

	@Override
	public void generatePiece() {
		piecePoints.add(new BoardPoint(boardwidth / 2, 0));
		piecePoints.add(new BoardPoint(boardwidth / 2, 1));
		piecePoints.add(new BoardPoint(boardwidth / 2, 2));
		piecePoints.add(new BoardPoint(boardwidth / 2, 3));

	}

	@Override
	protected Object clone() {
		Piece pieceClone = new PieceL();
		pieceClone.setPiecePoints((ArrayList<BoardPoint>) this.piecePoints.clone());
		return pieceClone;
	}

}
