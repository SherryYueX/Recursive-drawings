import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {

	private int quadrant;

	private int n;

	public FibonacciSquare(int x, int y, int n, int quadrant) {
		super(x, y, fib(n) * 30, Color.RED);
		this.n = n;
		this.quadrant = quadrant;
		shapes = new Shape[1];
		this.level++;
	}
	
	/*
	 * @param {int} - the nth fibonacci number
	 */
	protected static int fib(int n) {

		int[] fibList = new int[20];

		if (n <= 1)
			return n;
		else if (fibList[n] != 0) {
			return fibList[n];
		} else {
			int fib = fib(n - 2) + fib(n - 1);
			fibList[n] = fib;
			return fib;
		}

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);

		// if( isElementsNull(shapes) ){
		// // Draw the 1st Fibonacci Square
		// g.drawRect(x, y, size, size);
		// g.drawArc(x - size, y, 2 * size, 2 * size, 0, 90);
		// }

		// if( !isElementsNull(shapes) ) {
		if (quadrant == 2) {
			g.drawRect(x, y, size, size);
			g.drawArc(x, y, 2 * size, 2 * size, 90, 90);

		} else if (quadrant == 3) {
			g.drawRect(x, y, size, size);
			g.drawArc(x, y - size, 2 * size, 2 * size, 180, 90);
		} else if (quadrant == 4) {
			g.drawRect(x, y, size, size);
			g.drawArc(x - size, y - size, 2 * size, 2 * size, 270, 90);
		} else {
			g.drawRect(x, y, size, size);
			g.drawArc(x - size, y, 2 * size, 2 * size, 0, 90);
		}
		if (shapes[0] != null) {
			shapes[0].draw(g);
		}
		// }

		// else if (quadrant == 2) {
		// g.drawArc(x, y, 2 * size, 2 * size, 90, 90);
		// } else if (quadrant == 3) {
		// g.drawArc(x, y - size, 2 * size, 2 * size, 180, 90);
		// } else {
		// g.drawArc(x - size, y - size, 2 * size, 2 * size, 270, 90);
		// }

	}

	/*
	 * size = last shape's size
	 * fib(nextN) = current shape's size
	 */
	public Shape[] createChild() {
		int newQuadrant;
		int newX;
		int newY;
		int nextN;

		nextN = n + 1;
		if (quadrant == 1) {// create child with a quadrant = 2
			newX = x - fib(nextN) * 30;
			newY = y;
			newQuadrant = 2;
		} else if (quadrant == 2) {// create child with a quadrant = 3
			newX = x;
			newY = y + size;
			newQuadrant = 3;
		} else if (quadrant == 3) {// create child with a quadrant = 4
			newX = x + size;
			newY = y + size - fib(nextN) * 30;
			newQuadrant = 4;
		} else {// create child with a quadrant = 1
			newX = x + size - fib(nextN) * 30;
			newY = y - fib(nextN) * 30;
			newQuadrant = 1;
		}
		// }
		this.level++;

		shapes[0] = new FibonacciSquare(newX, newY, nextN, newQuadrant);
		return shapes;
	}


}
