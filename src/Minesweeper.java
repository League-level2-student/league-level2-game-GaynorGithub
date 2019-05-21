import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minesweeper {
	JFrame frame;
	static final int TILE_WIDTH = 50;
	static int SIDES = Integer.parseInt(JOptionPane.showInputDialog("Please select a row length"));
	GamePanel control;
	
	
	
	//Constructor
	public Minesweeper() {
		frame = new JFrame("Minesweeper");
		control = new GamePanel();
	}
	
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.setup();
	}
	
	//creates frame and general setup
		void setup() {
			frame.add(control);
			frame.addKeyListener(control);
			frame.addMouseListener(control);
			frame.setVisible(true);
			frame.add(control);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setPreferredSize(new Dimension(SIDES*TILE_WIDTH,SIDES*TILE_WIDTH));
			frame.pack();
		}
	
	
	
}
