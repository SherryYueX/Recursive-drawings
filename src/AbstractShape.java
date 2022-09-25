import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShape implements Shape {
	// location of the shape
	protected int x, y;
	// color of the shape
	protected Color color;
	// size of the shape
	protected int size;
	//Shape array
	protected Shape[] shapes;
	
	protected int level = 0;
	
	public AbstractShape(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y; 
		this.size = size;
		this.color = color;
	}
	
	public boolean addLevel() {
		// base case
		if(isElementsNull(shapes)) {
			//check if can create a child array
			if(size > 25 && size < 600 && x > 1 && x < 1300 && y > 1 && y < 900){
				// check eligibility of creating a FibonacciSquare child 
				if(size > 250 && x < 600)
					return false;
				shapes = createChild();
				return true;
			}else
				return false;
		}else {
			boolean canAddLevel = true;
			for(Shape s: shapes) {
				canAddLevel = s.addLevel();
			}
			
			return canAddLevel;
		}
	}
	
	public boolean removeLevel() {
		  if ( isElementsNull(shapes) ) {
			  return false;
		  } else {
			  boolean canRemove = false;
			  for(Shape s: shapes) {
				  if ( isElementsNull(s.getChildren()) ) {
					  
					  // if it reaches the most current level's children array
					  for(int i = 0; i < shapes.length; i++) {
						  shapes[i] = null;
					  }
					  return true;
					  
				  } else {
					  // ¡ý¡ý " = canRemove || " is the reason why it didn't work!!!
//					  canRemove = canRemove || s.removeLevel();
					  canRemove = s.removeLevel();
				  }
			  }
			  return canRemove;
		  }
	}
	
	public boolean resetAll() {
		if( !isElementsNull(shapes) ) {
			for(int i = 0; i < shapes.length; i++) {
				shapes[i] = null;
			}
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * check the condition of the shape array
	 */
	public boolean isElementsNull(Shape[] shapes) {
		for(Shape s: shapes) {
			if(s != null) {
				return false;
			}
		}
		return true;
	}
	
//	public int getX() {
//		return x;
//	}
//	public int getY() {
//		return y;
//	}
	public Shape[] getChildren() {
		return shapes;
	}
	
	public boolean contains(int x, int y) {
		if(x == this.x && y == this.y) {
			return true;
		}
		else
			return false;
	}

	public int getLevel(Shape s) {
		if(s == null)
			return level;
		else if(s.getChildren()[0] == null)
			return 1;
		else
			return 1 + getLevel (s.getChildren()[0]);
		
	}
	public String toString() {
		return String.format(getClass() + ": (x,y) = (%d,%d), color = (%d, %d, %d), level = %d", x, y, 
				color.getRed(), color.getBlue(), color.getGreen(), getLevel(shapes[0]));
	}

}
