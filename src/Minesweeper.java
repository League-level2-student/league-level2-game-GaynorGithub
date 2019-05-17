import java.awt.Dimension;

import javax.swing.JFrame;

public class Minesweeper {
	JFrame frame;
	final static int HEIGHT = 500; 
	final static int WIDTH = 500;
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
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
	        frame.pack();
		}
	
	
	
}
