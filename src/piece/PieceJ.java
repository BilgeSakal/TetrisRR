package piece;

import java.util.ArrayList;

public class PieceJ extends Piece {

	@Override
	public void generatePiece() {
		piecePoints.add(new BoardPoint(0, 0));
		piecePoints.add(new BoardPoint(0, 1));
		piecePoints.add(new BoardPoint(-1, 2));
		piecePoints.add(new BoardPoint(0, 2));

	}

	@Override
	protected Object clone() {
		Piece pieceClone = new PieceJ();
		pieceClone.setPiecePoints((ArrayList<BoardPoint>) this.piecePoints.clone());
		return pieceClone;
	}

}
