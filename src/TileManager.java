import java.awt.Graphics;

public class TileManager {
	
	Tile[][] tiles;
	int adjustment = 25;
	
	public TileManager() {
		int num = 1;
		tiles = new Tile[Minesweeper.SIDES][Minesweeper.SIDES];
		for (int row = 0; row < tiles.length; row++) {
			for (int col = 0; col < tiles.length; col++) {
				//tiles[row][col] = new Tile(col*Minesweeper.TILE_WIDTH, row*Minesweeper.TILE_WIDTH);
				tiles[row][col].num = num;
				num++;
			}
		}
	}
	
	public void draw(Graphics g) {
		for (int row = 0; row < tiles.length; row++) {
			for (int col = 0; col < tiles.length; col++) {
				tiles[row][col].draw(g);
			}
		}
		
	}
	
	public void tileClicked(int x, int y) {
		int rowNum = (int) Math.floor((y-adjustment)/Minesweeper.TILE_WIDTH);
		int colNum = (int) Math.floor(x/Minesweeper.TILE_WIDTH);
		//System.out.println(tiles[row][col].num);
		System.out.println(colNum+" "+x);
		System.out.println(rowNum+" "+y);
		
	}
}
