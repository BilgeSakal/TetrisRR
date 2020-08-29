package piece;

public class BoardPoint {

	private int x;
	private int y;

	public BoardPoint(int x, int y) {
		setX(x);
		setY(y);
	}

	public void incrementX() {
		setX(x + 1);
	}

	public void incrementX(int n) {
		setX(x + n);
	}

	public void decrementX() {
		setX(x - 1);
	}

	public void decrementX(int n) {
		setX(x - n);
	}

	public void incrementY() {
		setY(y + 1);
	}

	public void incrementY(int n) {
		setY(y + n);
	}

	public void decrementY() {
		setY(y - 1);
	}

	public void decrementY(int n) {
		setY(y - n);
	}

	// GETTERS AND SETTERS

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
