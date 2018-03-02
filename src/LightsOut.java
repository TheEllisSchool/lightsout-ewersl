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
	
	private static final int GRIDSIZE = 3; 
	
	
	LightButton [] [] lightBoard = new LightButton [GRIDSIZE] [GRIDSIZE]; 
		
	public LightsOut () {
		initGUI ();
		
		setTitle ("Lights Out!"); 
		setSize(500, 500); 
		setResizable(false); 
		pack(); 
		setLocationRelativeTo (null); 
		
		setVisible(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
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
					lightBoard[r][c] = new LightButton ( r, c);
					lightBoard[r][c].addActionListener(new ActionListener () {
						@Override
						public void actionPerformed (ActionEvent e) {
							LightButton button = (LightButton) e.getSource (); 
							int row = button.getRow (); 
							int col = button.getCol (); 
			
							buttonClicked (row, col);
						}
						
					} ); 
					centerPanel.add(lightBoard[r][c]); 
				}
			}
			boardSetUp(); 
		}
	public void boardSetUp () {
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c= 0; c < GRIDSIZE; c++) {
				lightBoard[r][c].reset(); 
			}
		}
		lightBoard [1][1].toggle();
		//randomClicks (); 
	}

	public void buttonClicked(int r, int c) {
	lightBoard [r][c].toggle (); 
	
	if (check (r, c+ 1)) {
		lightBoard [r] [c+1].toggle(); 
	}
	
	if (check (r, c- 1)) {
		lightBoard [r] [c-1].toggle(); 
	}
		
	if (check (r- 1, c)) {
		lightBoard [r-1] [c].toggle(); 
	}
	
	if (check (r+ 1, c)) {
		lightBoard [r+1] [c].toggle(); 
	}
	
	if (lightBoard [r][c].getisOn() == false && lightBoard [0] [0].getisOn() && lightBoard [0] [1].getisOn()
			&& lightBoard [0][2].getisOn() && lightBoard [1] [0].getisOn() && lightBoard [1] [1].getisOn() && lightBoard [1] [2].getisOn() && lightBoard [2] [0].getisOn() && lightBoard [2] [1].getisOn() && lightBoard [2] [2].getisOn()) {
		String message = "you won!" ; 
		promptForNewGame(message);
	}
} 

 public boolean check (int r, int c) {
	if (r > -1 && r < GRIDSIZE && c > -1 && c < GRIDSIZE) {
		return true; 
		
		} else {
			return false; 
		}
	}
 
	public void randomClicks() {
		Random rand = new Random (); 
		int pickRow; 
		int pickCol; 
		for (int i = 0; i < 3; i++) {
			pickRow = rand.nextInt(GRIDSIZE); 
			pickCol= rand.nextInt(GRIDSIZE);
			buttonClicked (pickRow, pickCol);
		}
	
} 
 

	public void promptForNewGame (String message) { 
		int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			boardSetUp();
		} else {
			System.exit(0);
		}
	}
	
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
}
