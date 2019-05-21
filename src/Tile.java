import java.awt.Color;
import java.awt.Graphics;

public class Tile {
	int x;
	int y;
	int num;
	
	//Constructor
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(x, y, Minesweeper.TILE_WIDTH, Minesweeper.TILE_WIDTH);
		//g.fill3DRect(x, y, Minesweeper.TILE_WIDTH, Minesweeper.TILE_WIDTH, true);
		g.setColor(Color.black);
		g.drawString(String.valueOf(num), x + 25, y + 25);
	}
}
