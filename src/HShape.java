import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class HShape extends AbstractShape {

	public HShape(int x, int y, int size) {
		super(x, y, size, Color.GREEN);
		shapes = new Shape[7];
		this.level 	++;
	}
	@Override
	public void draw(Graphics g) {
		
		if( !isElementsNull(shapes) ){
			for(int i = 0; i < shapes.length; i++) {
				shapes[i].draw(g);
			}
		} else {
		
		// draw the last shape
		for ( int i = 0 ; i < 9 ; i++ ) {
			if( i < 3 ) {
				if(i == 1) {
//					g.setColor(Color.WHITE);
//					g.fillRect(x + i * (size / 3), y, (size / 3), (size / 3));
				}
				else {
					g.setColor(color);
					g.fillRect(x + i * (size / 3), y, (size / 3), (size / 3));
				}
				
			}
			else if( i < 6 ) {
				
				g.fillRect(x + (i - 3) * (size / 3), y + (size / 3), (size / 3), (size / 3));
				
			}
			else {
				
				if( i == 7 ) {
				}
				else {
					g.setColor(color);
					g.fillRect(x + (i - 6) * (size / 3), y + 2 * (size / 3), (size / 3), (size / 3));
				}
			}
			
		}
		}
	}
	
	public Shape[] createChild() {
		int childX;
		int childY;
		
//		int childSize = size / 3;
//		int index = 0;
//		for(int row = 0; row < 3; row++) {
//			for(int col = 0; col < 3; col++) {
//				int xChild = x + childSize * col;
//				int yChild = y + childSize * row;
//				if(!(row == 0 && col == 1) && !(row == 2 && col == 1)) {
//					shapes[index] = new HShape(xChild, yChild, childSize);
//					index++;
//				}
//			}
//			
//		}
		
		// create 7 children for one HShape
		
		for(int i = 0; i < 7; i++) {
			if(i < 2) {
				childY = y;
				if(i == 0) {
					childX = x;
				}
				else{
					childX = x + 2 * (size / 3);
				}
			}
			else if(i < 5) {
				childY = y + (size / 3);
				childX = x + (i - 2) * (size / 3);
			}
			else {
				childY = y + 2 * (size / 3);
				if(i == 5) {
					childX = x;
				}
				else{
					childX = x + 2 * (size / 3);
				}
			}
			shapes[i] = new HShape(childX, childY, size / 3);
		}
		this.level ++;
		return shapes;
	}


}
