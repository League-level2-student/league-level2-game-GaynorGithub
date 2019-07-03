import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minesweeper {
	JFrame frame;
	static final int TILE_WIDTH = 50;
	static int SIDES = Integer.parseInt(JOptionPane.showInputDialog("Please select a row length greater than 4"));
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
			JOptionPane.showMessageDialog(null, "Welcome to Minesweeper!");
			JOptionPane.showMessageDialog(null, "Left click to uncover tiles. It will either be blank, display a number, or be a bomb.");
			JOptionPane.showMessageDialog(null, "The number refers to the amount of bombs around that tile");	
			JOptionPane.showMessageDialog(null, "Blank tiles are safe in all eight directions");
			JOptionPane.showMessageDialog(null, "Uncovering a bomb will result in an instant loss");
			JOptionPane.showMessageDialog(null, "To mark a possible bomb, right click. This will place a flag");
			JOptionPane.showMessageDialog(null, "When all the bombs have been flagged, the game will end.");
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
