import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	
	TileManager mana;
	Tile[] tiles = new Tile[Minesweeper.SIDES*Minesweeper.SIDES];
	Tile activeTile;
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Color grass = new Color(102, 209, 73);
	Color grass2 = new Color(80, 163, 57);
	Random rand = new Random();
	
	//Constructor
	public GamePanel() {
		//mana = new TileManager();
		setLayout(new GridLayout(Minesweeper.SIDES, Minesweeper.SIDES));
		int tile = 0;
		for (int row = 0; row < Minesweeper.SIDES; row++) {
			for (int col = 0; col < Minesweeper.SIDES; col++) {
				tiles[tile] = new Tile(rand.nextInt(2), row, col);
				System.out.println(tiles[tile].type);
				add(tiles[tile].label);
				tiles[tile].label.addMouseListener(this);
				tiles[tile].label.setHorizontalAlignment(JLabel.CENTER);
				tiles[tile].label.setVerticalAlignment(JLabel.CENTER);
				//tiles[i].label.setText("" + i);
				tiles[tile].label.setBorder(border);
				tile++;
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		//mana.draw(g);
	}
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//mana.tileClicked(e.getX(), e.getY());
		JLabel label = (JLabel) e.getSource();
		for (int i = 0; i < tiles.length; i++) {
			if(tiles[i].label == label) {
				activeTile = tiles[i];
				if(tiles[i].type == 1 && !tiles[i].clicked) {
					tiles[i].label.setText("Bomb");
					tiles[i].clicked = true;
				}
				else if(tiles[i].type == 0 && !tiles[i].clicked) {
					if(tiles[i].row + tiles[i].col>0 && tiles[i-1].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].row + tiles[i].col<Minesweeper.SIDES*2 && tiles[i+1].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].row > 0 && tiles[i-Minesweeper.SIDES].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].row>0 && tiles[i].col>0 && tiles[i-1-Minesweeper.SIDES].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].col<Minesweeper.SIDES && tiles[i].row>0 && tiles[i+1-Minesweeper.SIDES].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].row<Minesweeper.SIDES && tiles[i].col>0 && tiles[i-1+Minesweeper.SIDES].type == 1) {
						tiles[i].bombsAround++;
					}
					if( tiles[i].row<Minesweeper.SIDES && tiles[i+Minesweeper.SIDES].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].row<Minesweeper.SIDES && tiles[i].col<Minesweeper.SIDES && tiles[i+1+Minesweeper.SIDES].type == 1) {
						tiles[i].bombsAround++;
					}
					if(tiles[i].bombsAround>0) {
						tiles[i].label.setText("" + tiles[i].bombsAround);
					}
					tiles[i].clicked = true;
				}
				
				
			}
			
		}
		System.out.println(activeTile.label.getText());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
