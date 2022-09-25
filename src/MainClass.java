import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainClass {

	private static Random rand = new Random();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			createApplication();
		});
	}

	private static void createApplication() {
		JFrame frame = new JFrame("HW4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300, 900);
		// create the model and view
		DrawingModel model = new DrawingModel();
		Viewer panel = new Viewer();
		model.addView(panel);
		panel.update(model);
		frame.add(panel);
		
		// set font
		Font font = new Font("Courier", Font.BOLD | Font.ITALIC, 20);
		
		// button "Reset"
		JButton reset = new JButton();
		reset.setText("Reset");
		reset.setFont(font);
		reset.setForeground(Color.magenta);
		
		// button "Remove"
		JRadioButton remove = new JRadioButton("Remove");
		remove.setFont(font);
		remove.setForeground(Color.magenta);
		
		// button "Add"
		JRadioButton add = new JRadioButton("Add");
		add.setFont(font);
		add.setForeground(Color.magenta);
		
		// top Panel
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.cyan);
		northPanel.add(add);
		northPanel.add(remove);
		northPanel.add(reset);
		frame.add(northPanel, BorderLayout.NORTH);
		
		// create the button group for two radio buttons
		ButtonGroup bg = new ButtonGroup();
		bg.add(add);
		bg.add(remove);
		add.setSelected(true);
		
		// add the controller to the mains
		Controller c = new Controller(model, panel);
		c.setRadioButtons(add, remove);
		c.setResetButton(reset);
		reset.addActionListener(c);
		panel.addMouseListener(c);
		

		frame.setVisible(true);

		
	}

}
