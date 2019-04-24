import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid extends JFrame{

	private static int gridWidth;
	private static int gridHeight;
	private static JButton[][] buttons;
	
	public static void main(String[] args){
		Grid grid = new Grid(800, 800);
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
		
		//JPanel panel = new JPanel();
		for(int i = 0; i < gridWidth; i+=50) {
			for(int j = 0; j < gridHeight; j+=50) {
				int randNum = (int)(Math.random() + 1);
				buttons[i][j] = new JButton();
				if(randNum == 0) {
					isBomb = false;
				}
				else {
					isBomb = true;
					buttons[i][j].setName("b");
				}
				buttons[i][j].setBounds(i, j, 49, 49);
				frame.add(buttons[i][j]);
			}
		}
		
		//frame.add(panel);
		frame.pack();
		return frame;
	}

}
