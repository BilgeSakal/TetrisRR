
public class Square {
	
	public int x;
	public int y;
	
	/**
	 *  0________
	 *  |       x axis
	 *  |
	 *  |
	 *  |
	 *    y axis
	 * 
	 * @param x    x coordinate of square
	 * @param y    y coordinate of square
	 */
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveRight() {
		++x;
	}
	
	public void moveLeft() {
		--x;
	}
	
	public void moveDown() {
		++y;
	}
}
