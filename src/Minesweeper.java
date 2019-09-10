import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Minesweeper {
	JFrame frame;
	static final int TILE_WIDTH = 50;
	static int SIDES = Integer.parseInt(JOptionPane.showInputDialog("Please select a row length greater than 4"));
	GamePanel panel;
	JPanel panel2;
	JButton button;
	
	
	
	
	//Constructor
	public Minesweeper() {
		frame = new JFrame("Minesweeper");
		panel = new GamePanel();
		panel2 = new JPanel();
		button = new JButton("Restart");
		
	}
	
	public static void main(String[] args) {
		Minesweeper minesweeper = new Minesweeper();
		minesweeper.setup();
	}
	
	//creates frame and general setup
		void setup() {
			
			String intro = "";
			
			intro+="Welcome to Minesweeper!\n";
			intro+="Left click to uncover tiles. It will either be blank, display a number, or be a bomb.\n";
			intro+="The number refers to the amount of bombs around that tile\n";	
			intro+="Blank tiles are safe in all eight directions\n";
			intro+="Uncovering a bomb will result in an instant loss\n";
			intro+="To mark a possible bomb, right click. This will place a flag\n";
			intro+="When all the bombs have been flagged, the game will end.\n";
			JOptionPane.showMessageDialog(null, intro);
			panel2.add(button);
			if(button.getModel().isPressed())
		    System.out.println("the button is pressed");
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
