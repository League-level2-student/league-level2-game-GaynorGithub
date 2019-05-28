import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minesweeper {
	JFrame frame;
	static final int TILE_WIDTH = 50;
	static int SIDES = Integer.parseInt(JOptionPane.showInputDialog("Please select a row length"));
	GamePanel panel;
	
	
	
	//Constructor
	public Minesweeper() {
		frame = new JFrame("Minesweeper");
		panel = new GamePanel();
	}
	
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.setup();
	}
	
	//creates frame and general setup
		void setup() {
			frame.add(panel);
			frame.addKeyListener(panel);
			frame.addMouseListener(panel);
			frame.setVisible(true);
			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setPreferredSize(new Dimension(SIDES*TILE_WIDTH,SIDES*TILE_WIDTH));
			frame.pack();
		}
	
	
	
}
