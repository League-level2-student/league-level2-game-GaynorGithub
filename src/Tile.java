import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Tile {
	int x;
	int y;
	int num;
	JLabel label;
	int bombsAround;
	int type;
	
	//Constructor
	public Tile(int type) {
		this.x = x;
		this.y = y;
		label = new JLabel("Nice.");
		int bombsAround = 0;
		this.type = type;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);;
		g.drawRect(x, y, Minesweeper.TILE_WIDTH, Minesweeper.TILE_WIDTH);
		//g.fill3DRect(x, y, Minesweeper.TILE_WIDTH, Minesweeper.TILE_WIDTH, true);
		g.setColor(Color.black);
		g.drawString(String.valueOf(num), x + 25, y + 25);
		
	}
}
