import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid extends JFrame{

	private static int gridWidth;
	private static int gridHeight;
	private static JButton[][] buttons;
	
	public static void main(String[] args){
		Grid grid = new Grid(400, 400);
		grid.grid();

	}
	
	public Grid(int gridWidth, int gridHeight) {
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.buttons = new JButton[gridWidth][gridHeight];
	}
	
	public static JFrame grid() {
		
		boolean isClicked;
		boolean isBomb;
		
		JFrame frame = new JFrame("Minesweeper");
		frame.setSize(gridWidth, gridHeight);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		
		JPanel panel = new JPanel(new GridLayout(8, 8));
		panel.setSize(800, 800);
		
		//ClickListener click = new ClickListener();
		
		for(int i = 0; i < gridWidth; i+=50) {
			for(int j = 0; j < gridHeight; j+=50) {
				int randNum = (int)(Math.random() + 1);
				buttons[i][j] = new JButton();
				panel.add(buttons[i][j]);
				if(randNum == 0) {
					isBomb = false;
				}
				else {
					isBomb = true;
					buttons[i][j].setName("b");
				}
				buttons[i][j].setBounds(i, j, 49, 49);
				//buttons[i][j].addActionListener(click);
				buttons[i][j].setBackground(Color.GRAY);
				buttons[i][j].setBackground(Color.LIGHT_GRAY);
				buttons[i][j].setVisible(true);
				frame.add(panel);
			}
		}
		
		//frame.add(panel);

		return frame;
	}
	/*
	public static JButton isClicked(JButton button){
		if(button.){
			
		}
	}
	*/

}