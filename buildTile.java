import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class buildTile{

	private Button[][] tiles;
	private int rows;
	private int cols;
	
	public buildTile(int size){
		tiles = new Button[size][size];
		rows = size;
		cols = size;
	}

	private void init(){

		int cleanCountTotal = 0;
		
		// 0.199 to 1
		//99 to 496 bombs to tiles

		JFrame frame = new JFrame("TileTest");
		frame.setSize(500, 500);
		JPanel p = new JPanel(new GridLayout(10,10));
		int randNum;
		for(int i = 0; i < tiles.length; i++) {

			for(int j = 0; j < tiles[i].length; j++) {

				tiles[i][j] = new Button(i, j);
				tiles[i][j].addActionListener(new Listener());
				randNum = (int)(Math.random() * (9) + 1);
				if(randNum <= 6){
					tiles[i][j].setBackground(Color.LIGHT_GRAY);
					tiles[i][j].setBombStatus(false);
					cleanCountTotal++;
				}
				else{
					tiles[i][j].setBackground(Color.RED);
					//setTileLoc(tiles[i][j].getLocation(), i, j);
					tiles[i][j].setBombStatus(true);
				}
				p.add(tiles[i][j]);

			}

		}
		frame.add(p);
		
		//tiles[0][0].setBackground(Color.BLACK);
		//System.out.print(tiles[0][1].getBackground());
		
		// Bomb checker ***
		
		
		//frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		boolean running = true;

		//int devTrack = devTest(cleanCountTotal);
		
		for(int i = 0; i < rows; i++) {
			for(int k = 0; k < cols; k++) {
				while(running == true) {
					Scanner console = new Scanner(System.in);
					System.out.print("Please enter a the coordinates for the tile you want clicked");
					String input = console.nextLine();
					String command = input.substring(0, input.indexOf(" "));
					String coordinates = input.substring(input.indexOf(" ") + 1);
					int row = Integer.parseInt(coordinates.substring(0, coordinates.indexOf(" ")));
					int column = Integer.parseInt(coordinates.substring(coordinates.indexOf(" ") + 1));
					
					
					if(command.equals("flag")) {
						tiles[row][column].setBackground(Color.GREEN);
					}
					else {
						if(tiles[row][column].getBombStatus() == true) {
							tiles[row][column].setBackground(Color.CYAN);
							System.out.println("Game Over");
							running = false;
						}
						else if(tiles[row][column].getIsClicked() == true) {
							System.out.println("You've already clicked this tile");

							// Use these methods to get the X and Y location of any button on the grid
							System.out.println(tiles[i][k].getPointX());
							System.out.println(tiles[i][k].getPointY());
						}
						else {
							String numNeighborBombs = click(row, column);
							tiles[row][column].setText(numNeighborBombs);
							tiles[row][column].setIsClicked(true);
							cleanCountTotal--;
							System.out.println(cleanCountTotal);
							System.out.println(numNeighborBombs);
						}
					}
					if(cleanCountTotal == 0) {
						System.out.println("You found all the bombs!");
						System.out.println("You win!");
						running = false;
						
					}
				}
			}
		}
		
		//run(); 
	}
	
	public String click(int r, int c) {
		String numNeighborBombs = "";
		ArrayList<Button> neighbors = new ArrayList<Button>();
		int count = 0;
		
		if(r == 0) {
			if(c == 0) {
				neighbors.add(tiles[r][c+1]);
				neighbors.add(tiles[r+1][c+1]);
				neighbors.add(tiles[r][c+1]);
			}
			else if(c == cols-1) {
				neighbors.add(tiles[r][c-1]);
				neighbors.add(tiles[r+1][c-1]);
				neighbors.add(tiles[r+1][c]);
			}
			else {
				neighbors.add(tiles[r][c+1]);
				neighbors.add(tiles[r+1][c+1]);
				neighbors.add(tiles[r][c+1]);
				neighbors.add(tiles[r+1][c-1]);
				neighbors.add(tiles[r][c-1]);
			}
		}
		else if(c == 0) {
			if(r == rows-1) {
				neighbors.add(tiles[r-1][c]);
				neighbors.add(tiles[r-1][c+1]);
				neighbors.add(tiles[r][c+1]);
			}
			else {
				neighbors.add(tiles[r-1][c]);
				neighbors.add(tiles[r-1][c+1]);
				neighbors.add(tiles[r][c+1]);
				neighbors.add(tiles[r+1][c+1]);
				neighbors.add(tiles[r+1][c]);
			}
		}
		
		else if(r == rows-1) {
			if(c == cols-1) {
				neighbors.add(tiles[r-1][c]);
				neighbors.add(tiles[r-1][c-1]);
				neighbors.add(tiles[r][c-1]);
			}
			else {
				neighbors.add(tiles[r][c-1]);
				neighbors.add(tiles[r-1][c-1]);
				neighbors.add(tiles[r-1][c]);
				neighbors.add(tiles[r-1][c+1]);
				neighbors.add(tiles[r][c+1]);
			}
		}
		else if(c == cols-1) {
			neighbors.add(tiles[r-1][c]);
			neighbors.add(tiles[r-1][c-1]);
			neighbors.add(tiles[r][c-1]);
		}
		
		else {
			neighbors.add(tiles[r-1][c-1]);
			neighbors.add(tiles[r-1][c]);
			neighbors.add(tiles[r-1][c+1]);
			neighbors.add(tiles[r][c+1]);
			neighbors.add(tiles[r+1][c+1]);
			neighbors.add(tiles[r+1][c]);
			neighbors.add(tiles[r+1][c-1]);
			neighbors.add(tiles[r][c-1]);
			
		}
		
		for(int i = 0; i < neighbors.size(); i++) {
			if(neighbors.get(i).getBombStatus()) {
				count++;
			}
		}
		numNeighborBombs = count + "";
		return numNeighborBombs;
	}
	
	/*
	public int devTest(int cleanTileCount) {
		for(int i = 0; i < rows; i++) {
			for(int k = 0; k < cols-1; k++) {
				if(tiles[i][k].getBombStatus() == false) {
					tiles[i][k].setBackground(Color.GRAY);
					cleanTileCount--;
				}
			}
		}
		return cleanTileCount;
	}
	*/
	
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