import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	
	TileManager mana;
	Tile[] tiles = new Tile[Minesweeper.SIDES*Minesweeper.SIDES];
	Tile activeTile;
	static final int BOMB = 1;
	Border border = BorderFactory.createLineBorder(Color.GRAY);
	Color grass = new Color(102, 209, 73);
	Color dirt = new Color(207, 131, 91);
	Color red = new Color(255,0,0);
	Random rand = new Random();
	JLabel label;
	JLabel label2;
	int totalBombs;
	boolean valuesAssigned = false;
	
	
	//Constructor
	public GamePanel() {
		//mana = new TileManager();
		
		//add(label = new JLabel("Total Bombs: " + totalBombs));
		JPanel panel = new JPanel();
		setLayout(new GridLayout(Minesweeper.SIDES, Minesweeper.SIDES));
		totalBombs = 0;
		int tile = 0;
		for (int row = 0; row < Minesweeper.SIDES; row++) {
			for (int col = 0; col < Minesweeper.SIDES; col++) {
				tiles[tile] = new Tile(rand.nextInt(6), row, col);
				add(tiles[tile].label);
				if(tiles[tile].type == 1) {
					totalBombs++;
				}
				tiles[tile].label.addMouseListener(this);
				tiles[tile].label.setHorizontalAlignment(JLabel.CENTER);
				tiles[tile].label.setVerticalAlignment(JLabel.CENTER);
				//tiles[i].label.setText("" + i);
				tiles[tile].label.setBorder(border);
				tiles[tile].label.setOpaque(true);
				tiles[tile].label.setBackground(grass);
				repaint();
				tile++;
			}
		}
		System.out.println(totalBombs);
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
		if(e.getButton() == MouseEvent.BUTTON1) {
			JLabel label = (JLabel) e.getSource();
			for (int i = 0; i < tiles.length; i++) {
				if(tiles[i].label == label) {
					System.out.println(label);
					activeTile = tiles[i];
					if(tiles[i].type == BOMB && !tiles[i].clicked) {
						tiles[i].label.setText("Bomb");
						tiles[i].clicked = true;
						tiles[i].label.setOpaque(true);
						tiles[i].label.setBackground(red);
						JOptionPane.showMessageDialog(null, "You Lost!");
						System.exit(0);
						repaint();
						//totalBombs++;
					}
					else if(tiles[i].type != BOMB && !tiles[i].clicked) {
						if((tiles[i].row + tiles[i].col>0) && (tiles[i-1].row == tiles[i].row) && (tiles[i-1].type == BOMB)) { 
							tiles[i].bombsAround++;
						}
						if(tiles[i].row+1 + tiles[i].col+1<Minesweeper.SIDES*2 && (tiles[i+1].row == tiles[i].row) && tiles[i+1].type == BOMB) { //Tile directly to the right
							tiles[i].bombsAround++;
						}
						if(tiles[i].row > 0 && tiles[i-Minesweeper.SIDES].type == BOMB) { //Directly above clicked tile
							tiles[i].bombsAround++;
						}
						if(tiles[i].row>0 && tiles[i].col>0 && tiles[i-1-Minesweeper.SIDES].type == BOMB) { //Above and to the left of clicked tile
							tiles[i].bombsAround++;
						}
						if(tiles[i].col<Minesweeper.SIDES && tiles[i].row>0 && (tiles[i-Minesweeper.SIDES+1].row != tiles[i].row) && tiles[i+1-Minesweeper.SIDES].type == BOMB) { //Above and to the right of clicked tile
							tiles[i].bombsAround++;
						}
						if(tiles[i].row+1<Minesweeper.SIDES && tiles[i].col>0 && tiles[i-1+Minesweeper.SIDES].type == BOMB) {
							tiles[i].bombsAround++;
						}
						if( tiles[i].row+1<Minesweeper.SIDES && tiles[i+Minesweeper.SIDES].type == BOMB) {
							tiles[i].bombsAround++;
						}
						if(tiles[i].row+1<Minesweeper.SIDES && tiles[i].col+1<Minesweeper.SIDES && tiles[i+1+Minesweeper.SIDES].type == BOMB) {
							tiles[i].bombsAround++;
						}
						if(tiles[i].bombsAround>0) {
							tiles[i].label.setText("" + tiles[i].bombsAround);
							tiles[i].label.setOpaque(true);
							tiles[i].label.setBackground(dirt);
							repaint();
						}
						if(tiles[i].bombsAround==0) {
							tiles[i].label.setOpaque(true);
							tiles[i].label.setBackground(dirt);
							repaint();
						}
						tiles[i].clicked = true;
					}
					
					
				}
				
			}
			//System.out.println(activeTile.label.getText());
		}
		if( e.getButton() == MouseEvent.BUTTON3) {
			JLabel label = (JLabel) e.getSource();
			for (int i = 0; i < tiles.length; i++) {
				if(tiles[i].label == label) {
					if(!tiles[i].flagged && !tiles[i].clicked) {
						tiles[i].label.setOpaque(true);
						tiles[i].label.setBackground(Color.orange);
						tiles[i].flagged = true;
						if(tiles[i].type == 1) {
							totalBombs--;
							System.out.println(totalBombs);
							if(totalBombs == 0) {
								JOptionPane.showMessageDialog(null, "Congratulations, You Win!");
							}
						}
					}
					else if(tiles[i].flagged && !tiles[i].clicked) {
						tiles[i].label.setOpaque(true);
						tiles[i].label.setBackground(grass);
						tiles[i].flagged = false;
						if(tiles[i].type == 1) {
							totalBombs++;
						}
					}
				}
			}
				
		}
		
		
		
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
