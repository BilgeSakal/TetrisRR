package piece;

import java.util.ArrayList;

public class PieceSquare extends Piece {

	@Override
	public void generatePiece() {
		piecePoints.add(new BoardPoint(0, 0));
		piecePoints.add(new BoardPoint(1, 0));
		piecePoints.add(new BoardPoint(0, 1));
		piecePoints.add(new BoardPoint(1, 1));
	}

	@Override
	protected Object clone() {
		Piece pieceClone = new PieceL();
		pieceClone.setPiecePoints((ArrayList<BoardPoint>) this.piecePoints.clone());
		return pieceClone;
	}

}
