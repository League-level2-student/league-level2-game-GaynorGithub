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
		for (int i = 0; i < tiles.length; i++) {
			
			tiles[i] = new Tile(rand.nextInt(2));
			add(tiles[i].label);
			tiles[i].label.addMouseListener(this);
			tiles[i].label.setHorizontalAlignment(JLabel.CENTER);
			tiles[i].label.setVerticalAlignment(JLabel.CENTER);
			tiles[i].label.setText("" + i);
			tiles[i].label.setBorder(border);
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
				if(tiles[i-1].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i+1].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i-Minesweeper.SIDES].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i-1-Minesweeper.SIDES].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i+1-Minesweeper.SIDES].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i-1+Minesweeper.SIDES].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i+Minesweeper.SIDES].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i+1+Minesweeper.SIDES].type == 2) {
					tiles[i].bombsAround++;
				}
				if(tiles[i].bombsAround==0) {
					tiles[i].label.setText("Bomb");
				}
				if(tiles[i].bombsAround>0) {
					tiles[i].label.setText("" + tiles[i].bombsAround);
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
