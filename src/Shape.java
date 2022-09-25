import java.awt.Graphics;
import java.util.List;

public interface Shape {
	
	void draw(Graphics g);
	boolean addLevel();
	boolean removeLevel();
	boolean resetAll();
	Shape[] createChild();
	boolean contains(int x, int y);
	Shape[] getChildren();
	
//	int getX();
//	int getY();
}
