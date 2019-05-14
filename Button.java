
import javax.swing.*;
public class Button extends JButton{

	private boolean bombStatus;
	private boolean isClicked;
	
	public Button() {
		super();
		bombStatus = false;
		isClicked = false;
	}
	
	public void setBombStatus(boolean status) {
		this.bombStatus = status;
	}
	
	public boolean getBombStatus() {
		return this.bombStatus;
	}
	
	public void setIsClicked(boolean status) {
		this.isClicked = status;
	}
	
	public boolean getIsClicked() {
		return this.isClicked;
	}

}
