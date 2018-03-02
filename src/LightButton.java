import java.awt.Color;

import javax.swing.JButton;

public class LightButton extends JButton {
	private static int SIZE = 50; 
	boolean isOn= false; 
	
	int row; 
	int col; 
	
	public LightButton(int r, int c) {
		isOn = false; 
		setBackground (Color.BLUE);
		row = r;
		col= c; 
		
	}
	
	public int getRow () {
		return row; 
	}
	
	public int getCol () {
		return col;
	}
	
	public boolean getisOn () {
		return isOn; 
	}
	
	public void toggle () {
		if (isOn == false) {
			isOn= true; 
			setBackground (Color.WHITE); 
		} else {
			isOn = false; 
			setBackground(Color.BLUE); 
		}
			
		
	}
	
	public void reset () {
		isOn= false; 
	}
}
