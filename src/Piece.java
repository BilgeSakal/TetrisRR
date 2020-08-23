
public class Piece {
	
	private static int numOfSquares = 4;
	
	Square squares[] = new Square[numOfSquares];
		
	public void rotate(TetrisShapesEnum shape) {
		switch (shape) {
		case SQUARED:
			break;
		case STICKED:
			//TODO
			break;
		case ZSHAPED:
			//TODO
			break;
		case SSHAPED:
			//TODO
			break;
		case PYRAMIDED:
			//TODO
			break;
		}
	}

	public Piece move(TetrisDirectionsEnum direction) {
		switch (direction) {
		case DOWN:
			for (int i = 0; i < numOfSquares; ++i) {
				squares[i].moveDown();
			}
			break;
		case LEFT:
			for (int i = 0; i < numOfSquares; ++i) {
				squares[i].moveLeft();
			}
			break;
		case RIGHT:
			for (int i = 0; i < numOfSquares; ++i) {
				squares[i].moveRight();
			}
			break;
		}
		return this;
	}
}
