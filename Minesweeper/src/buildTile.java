import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class buildTile{

	private JButton[][] tiles;
	private static boolean isBomb;
	private int rows;
	private int cols;

	public buildTile(int size){
		tiles = new JButton[size][size];
		rows = size;
		cols = size;
	}

	private void init(){

		// 0.199 to 1
		//99 to 496 bombs to tiles

		JFrame frame = new JFrame("TileTest");
		frame.setSize(500, 500);
		JPanel p = new JPanel(new GridLayout(10,10));
		int randNum;
		for(int i = 0; i < tiles.length; i++) {

			for(int j = 0; j < tiles[i].length; j++) {

				tiles[i][j] = new JButton();
				tiles[i][j].addActionListener(new Listener());
				randNum = (int)(Math.random() * (9) + 1);
				if(randNum <= 6){
					tiles[i][j].setBackground(Color.LIGHT_GRAY);
					setBombStatus(tiles[i][j], false);
				}
				else{
					tiles[i][j].setBackground(Color.RED);
					//setTileLoc(tiles[i][j].getLocation(), i, j);
					setBombStatus(tiles[i][j], true);
				}
				p.add(tiles[i][j]);

			}

		}
		frame.add(p);
		tiles[0][4].setBackground(Color.BLACK);
		//frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		boolean running = true;

		//run(); 
	}
	
	/*
	public String getTileLoc(){
		int rowCount = 0;
		int colCount = 0;

	}
	*/
	
	public void setTileLoc(Point point, int x, int y){
		point.x = x;
		point.y = y;
	}

	public boolean getBombStatus(){
		return isBomb;
	}

	public void setBombStatus(JButton button, boolean status){
		isBomb = status;
	}

	public static void main(String[] args){

		buildTile bt = new buildTile(10);
		bt.init();
		//bt.getBombStatus();

	}

	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			//System.out.println(getTileLoc());
			//tiles[][].setColor(Color.BLACK);
		}


	}
}
