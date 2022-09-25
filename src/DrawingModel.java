import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawingModel {
	private static final int hX = 700;
	private static final int hY = 170;
	private static final int fX = 350;
	private static final int fY = 300;
	private static final int hSize = 540;
	private static final int fSize = 1;
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();

	
	public DrawingModel(){
		FibonacciSquare fS = new FibonacciSquare(fX, fY, fSize, 1);
		HShape hS = new HShape(hX, hY, hSize);
		addShape(fS);
		addShape(hS);
		
	}
	/**
	 * Adds a view to the list of views in the model
	 */
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	/**
	 * Updates all of the views following a change in the model
	 */
	public void updateAll() {
		for (View v : views) {
			v.update(this);
		}
	}

	/**
	 * Adds a square to the list of squares
	 */
	public void addShape(Shape s) {
		shapes.add(s);
		// Show it
		updateAll();
	}

	/**
	 * Returns the list of the shapes
	 */
	public List<Shape> getShapes() {
		return shapes;
	}
	
	
	public boolean addLevel(int x, int y) {
		//check if can be added one level
		boolean canAdd = false;
		for(Shape s: shapes) {
			if(s.contains(x, y))
				canAdd = canAdd || s.addLevel();
		}
		return canAdd;
		
	}
	public boolean removeLevel(int x, int y) {
		
		boolean canRemove = false;
		for(Shape s: shapes) {
			if( s.contains(x, y) ) {
				canRemove = s.removeLevel();
			}
		}
		return canRemove;
	}
	
	// reset the shapes
	public boolean reset() {
		
		boolean canRemove = false;
		for(Shape s: shapes) {
			canRemove = s.resetAll();
		}
		return canRemove;
	}

}
