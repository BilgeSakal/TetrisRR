package piece;

public class DoubleBoardPoint {

	private double x;
	private double y;

	public DoubleBoardPoint(double x, double y) {
		setX(x);
		setY(y);
	}

	public void incrementX() {
		setX(x + 1);
	}
	
	public void incrementX(double n) {
		setX(x + n);
	}

	public void decrementX() {
		setX(x - 1);
	}
	
	public void decrementX(double n) {
		setX(x - n);
	}

	public void incrementY() {
		setY(y + 1);
	}
	
	public void incrementY(double n) {
		setY(y + n);
	}
	
	public void decrementY() {
		setY(y - 1);
	}
	
	public void decrementY(double n) {
		setY(y - n);
	}

	// GETTERS AND SETTERS

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
