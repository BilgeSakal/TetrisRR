import java.util.Random;

public class Piece {
	
	private static int numOfSquares = 4;
	
	private static TetrisShapesEnum pieceShape;
	private static int variant;
	
	private Square squares[] = new Square[numOfSquares];
	
	/**
	 * This constructor creates a shape and its variant randomly.
	 * 
	 * @param width    the width of the Tetris board
	 */
	public Piece(int width) {
		Random rand = new Random();
		int r = rand.nextInt(5);
		switch (r) {
		case 0:
			pieceShape = TetrisShapesEnum.SQUARED;
			variant = 0;
			squares[0] = new Square(0, width / 2);
			squares[1] = new Square(0, width / 2 + 1);
			squares[2] = new Square(1, width / 2);
			squares[3] = new Square(1, width / 2 + 1);
			break;
		case 1:
			pieceShape = TetrisShapesEnum.STICKED;
			variant = rand.nextInt(2);
			switch (variant) {
			case 0:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(1, width / 2);
				squares[2] = new Square(2, width / 2);
				squares[3] = new Square(3, width / 2);
				break;
			case 1:
				squares[0] = new Square(0, width / 2 - 1);
				squares[1] = new Square(0, width / 2);
				squares[2] = new Square(0, width / 2 + 1);
				squares[3] = new Square(0, width / 2 + 2);
				break;
			}
			break;
		case 2:
			pieceShape = TetrisShapesEnum.ZSHAPED;
			variant = rand.nextInt(2);
			switch (variant) {
			case 0:
				squares[0] = new Square(0, width / 2 - 1);
				squares[1] = new Square(0, width / 2);
				squares[2] = new Square(1, width / 2);
				squares[3] = new Square(1, width / 2 + 1);
				break;
			case 1:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(1, width / 2 - 1);
				squares[2] = new Square(1, width / 2);
				squares[3] = new Square(2, width / 2 - 1);
				break;
			}
			break;
		case 3:
			pieceShape = TetrisShapesEnum.SSHAPED;
			variant = rand.nextInt(2);
			switch (variant) {
			case 0:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(0, width / 2 + 1);
				squares[2] = new Square(1, width / 2);
				squares[3] = new Square(1, width / 2 - 1);
				break;
			case 1:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(1, width / 2);
				squares[2] = new Square(1, width / 2 + 1);
				squares[3] = new Square(2, width / 2 + 1);
				break;
			}
			break;
		case 4:
			pieceShape = TetrisShapesEnum.PYRAMIDED;
			variant = rand.nextInt(4);
			switch (variant) {
			case 0:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(1, width / 2 - 1);
				squares[2] = new Square(1, width / 2);
				squares[3] = new Square(1, width / 2 + 1);
				break;
			case 1:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(1, width / 2);
				squares[2] = new Square(1, width / 2 + 1);
				squares[3] = new Square(2, width / 2);
				break;
			case 2:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(0, width / 2 - 1);
				squares[2] = new Square(0, width / 2 + 1);
				squares[3] = new Square(1, width / 2);
				break;
			case 3:
				squares[0] = new Square(0, width / 2);
				squares[1] = new Square(1, width / 2);
				squares[2] = new Square(1, width / 2 - 1);
				squares[3] = new Square(2, width / 2);
				break;
			}
			break;
		}
	}
	
	/**
	 * This method rotates the shape clockwise 90 degree.
	 */
	public void rotate() {
		switch (pieceShape) {
		case SQUARED:
			break;
		case STICKED:
			switch (variant) {
			case 0:
				break;
			case 1:
				break;
			}
			variant = (variant + 1) % 2;
			break;
		case ZSHAPED:
			switch (variant) {
			case 0:
				break;
			case 1:
				break;
			}
			variant = (variant + 1) % 2;
			break;
		case SSHAPED:
			switch (variant) {
			case 0:
				break;
			case 1:
				break;
			}
			variant = (variant + 1) % 2;
			break;
		case PYRAMIDED:
			switch (variant) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
			variant = (variant + 1) % 4;
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
	
	// GETTERS AND SETTERS
	
	public Square[] getSquares() {
		return squares;
	}
}
