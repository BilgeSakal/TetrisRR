package piece;

import java.util.ArrayList;

public class PieceStick extends Piece {

	@Override
	public void generatePiece() {
		piecePoints.add(new BoardPoint(0, 0));
		piecePoints.add(new BoardPoint(0, 1));
		piecePoints.add(new BoardPoint(0, 2));
		piecePoints.add(new BoardPoint(0, 3));

	}

	@Override
	protected Object clone() {
		Piece pieceClone = new PieceL();
		pieceClone.setPiecePoints((ArrayList<BoardPoint>) this.piecePoints.clone());
		return pieceClone;
	}

}
