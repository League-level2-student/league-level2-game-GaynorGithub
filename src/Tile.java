import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Tile {
	int col;
	int row;
	int num;
	JLabel label;
	int bombsAround;
	int type;
	boolean clicked;
	boolean flagged;
	
	//Constructor
	public Tile(int type, int row, int col) {
		this.row = row;
		this.col = col;
		label = new JLabel("");
		int bombsAround = 0;
		this.type = type;
		clicked = false;
		flagged = false;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);;
		//g.drawRect(x, y, Minesweeper.TILE_WIDTH, Minesweeper.TILE_WIDTH);
		//g.fill3DRect(x, y, Minesweeper.TILE_WIDTH, Minesweeper.TILE_WIDTH, true);
		g.setColor(Color.black);
		//g.drawString(String.valueOf(num), x + 25, y + 25);
		
	}
}
