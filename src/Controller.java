import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Controller extends MouseAdapter implements MouseListener,ActionListener{
	private DrawingModel model = new DrawingModel();
	private Viewer panel = new Viewer();
	private JRadioButton add;
	private JRadioButton remvove;
	private JButton reset;
	private TextViewer tv = new TextViewer();
	
	public Controller(DrawingModel model, Viewer panel) {
		this.model = model;
		this.panel = panel;
	}
	
	//set the two radio buttons
	public void setRadioButtons(JRadioButton add, JRadioButton remove){
		this.add = add;
		this.remvove = remove;
	}
	
	//set the reset button
	public void setResetButton(JButton b){
		this.reset = b;
	}
	
	public void actionPerformed(ActionEvent e) {
		model.reset();
		panel.repaint();
	}
	
	//decide if the model should operate adding or removing one level
	public boolean isAdding() {
		boolean isAdding = false;
		if(add.isSelected()) {
			isAdding = true;
		}else {
			isAdding = false;
		}
		return isAdding;
	}
	
	public void mousePressed(MouseEvent e) {
//		System.out.println("add one level? " + model.addLevel());
//		System.out.println("remove one level? " + model.removeLevel());
		int x = e.getX();
		int y = e.getY();
//		System.out.println(x + "  " + y);
		if(x > 700 && x < 1240 && y > 170 && y < 710) {
			x = 700;
			y = 170;
		}else if(x < 650 && x > 0 && y > 50 && y < 800) {
			x = 350;
			y = 300;
		}
		 if( isAdding() ) {
			 if( model.addLevel(x, y) ) {
				panel.repaint();
				tv.displayInfo();
				tv.update(model);
			 }
			 else {
				 JOptionPane.showMessageDialog(panel, "Cannot be adding levels anymore!", null, JOptionPane.ERROR_MESSAGE);
				 return;
			 }
		 }
		 if( !isAdding() ) {
			 if(model.removeLevel(x, y)) {
				panel.repaint();
				tv.displayInfo();
				tv.update(model);
			 }
			 else {
				 JOptionPane.showMessageDialog(panel, "Cannot be removing levels anymore!", null, JOptionPane.ERROR_MESSAGE);
				 return;
			 }
		 }
		 
	}

	
}
