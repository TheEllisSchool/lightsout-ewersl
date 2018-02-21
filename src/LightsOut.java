import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.EventQueue; 
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.UIManager;



public class LightsOut extends JFrame {
	
	private static final int GRIDSIZE = 10; 
	
	LightButton [] [] lightBoard = new LightButton [GRIDSIZE] [GRIDSIZE]
			
	
	
	Public lightsOut () {
		
	}
	
	private void initGUI() {
		JPanel titlePanel = new JPanel(); 
		add(titlePanel, BorderLayout.PAGE_START);
		titlePanel.setBackground(Color.BLACK);
		JLabel titleLabel = new JLabel("Lights Out! ");
			titlePanel.add(titleLabel); 
			titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
			Font titleFont = new Font ("Georgia", Font.BOLD, 50);
			titleLabel.setForeground (Color.WHITE);
			titleLabel.setFont(titleFont);
			
			//center panel 
			JPanel centerPanel = new JPanel (); 
			centerPanel.setLayout (new GridLayout (GRIDSIZE, GRIDSIZE)) ; 
			add (centerPanel, BorderLayout.CENTER) ; 
			for (int r=0; r < GRIDSIZE; r++) {
				for (int c= 0; c < GRIDSIZE; c++) {
					terrain[r][c] = new LightButton (r, c);
					terrain[r][c].addActionListener(new ActionListener () {
						@Override
						public void actionPerformed (ActionEvent e) {
							LightButton button = (LightButton) e.getSource (); 
							int row = button.getRow (); 
							int col = button.getCol (); 
							clickedTerrain (row, col);
						}
						
					} ); 
					centerPanel.add(terrain[r][c]); 
				}
			}
		}

	public void buttonClicked(int r, int c) {
	
	} 
	
	public void boardSetup()
	
	Private void promptForNewGame (message); 
	String message= "new game"; 
	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
            		new LightsOut();
            }   
        });	
}
