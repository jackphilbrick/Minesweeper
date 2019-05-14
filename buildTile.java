import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
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

		// 0.199 to 1
		//99 to 496 bombs to tiles

		JFrame frame = new JFrame("TileTest");
		frame.setSize(500, 500);
		JPanel p = new JPanel(new GridLayout(10,10));
		int randNum;
		for(int i = 0; i < tiles.length; i++) {

			for(int j = 0; j < tiles[i].length; j++) {

				tiles[i][j] = new Button();
				tiles[i][j].addActionListener(new Listener());
				randNum = (int)(Math.random() * (9) + 1);
				if(randNum <= 6){
					tiles[i][j].setBackground(Color.LIGHT_GRAY);
					tiles[i][j].setBombStatus(false);
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
		
		tiles[0][0].setBackground(Color.BLACK);
		//System.out.print(tiles[0][1].getBackground());
		
		// Bomb checker ***
		
		
		//frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		boolean running = true;

		while(running == true) {
			Scanner console = new Scanner(System.in);
			System.out.print("Please enter a the coordinates for the tile you want clicked");
			String input = console.nextLine();
			int row = Integer.parseInt(input.substring(0, input.indexOf(" ")));
			int column = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
			
			if(tiles[row][column].getBombStatus() == true) {
				tiles[row][column].setBackground(Color.CYAN);
				System.out.println("Game Over");
				running = false;
			}
			else if(tiles[row][column].getIsClicked() == true) {
				System.out.println("You've already clicked this tile");
			}
			else {
				tiles[row][column].setBackground(Color.GRAY);
				tiles[row][column].setIsClicked(true);
			}
		}
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