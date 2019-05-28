
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Button extends JButton{

	private boolean bombStatus;
	private boolean isClicked;
	private boolean clickListener;
	
	private int pointX;
	private int pointY;
	
	public Button(int pointX, int pointY) {
		super();
		bombStatus = false;
		isClicked = false;
		clickListener = false;
		
		this.pointX = pointX;
		this.pointY = pointY;
		
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
	
	public void setClickListener(boolean status) {
		this.clickListener = true;
	}
	
	public boolean getClickListener() {
		return this.clickListener;
	}
	
	public int getPointX() {
		return this.pointX;
	}
	
	public int getPointY() {
		return this.pointY;
	}

	public void actionPerformed(int button1) {
		System.out.println(this.pointX + " " + this.pointY);
		
	}

	public void setBackground(Icon newIcon) {
		
		
	}

}
