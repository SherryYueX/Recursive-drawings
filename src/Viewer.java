import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Viewer extends JPanel implements View {

	private DrawingModel model;

	public Viewer() {
		setBackground(Color.WHITE);
	}

	@Override
	public void update(DrawingModel m) {
		this.model = m;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw the shapes
		if (model != null) {
			for (Shape s : model.getShapes()) {
				s.draw(g);
			}
		}
	}

}
