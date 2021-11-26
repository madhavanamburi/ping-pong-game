import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame;
	JButton[] buttons;
	JPanel titlePanel;
	JPanel buttonsPanel;
	JLabel textLabel;
	boolean player1Turn;
	int j = 0;
	
	TicTacToe(){
		
		textLabel = new JLabel();
		textLabel.setText("Tic-Tac-Toe");
		textLabel.setForeground(Color.MAGENTA);
		textLabel.setBackground(new Color(25, 25, 25));
		textLabel.setOpaque(true);
		textLabel.setHorizontalAlignment(JTextField.CENTER);
		textLabel.setFont(new Font("Ink free", Font.BOLD, 50));
		
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 600, 100);
		titlePanel.add(textLabel);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(3, 3));
		

		buttons = new JButton[9];
		
		for(int i=0; i<9; i++) {
			
			buttons[i] = new JButton();
			buttons[i].setFocusable(false);
			buttons[i].setFont(new Font("Ink free", Font.BOLD, 70));
			buttons[i].addActionListener(this);
			buttonsPanel.add(buttons[i]);
		}
		
		frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLocationRelativeTo(null);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonsPanel);
		frame.setVisible(true);

		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource() == buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText() == "") {
						j++;
						buttons[i].setText("X");
						buttons[i].setForeground(Color.RED);
						player1Turn = false;
						textLabel.setText("O turn");

						check();
					}
				}
				else {
					if(buttons[i].getText() == "") {
						j++;
						buttons[i].setText("O");
						buttons[i].setForeground(Color.BLUE);
						player1Turn = true;
						textLabel.setText("X turn");

						check();
					}
				}
				
			}
			if(j==9 && ((textLabel.getText()=="X turn") || (textLabel.getText()=="O turn"))){
				for(int k=0; k<9; k++) {
					buttons[k].setEnabled(false);
				}					
				textLabel.setText("Game Over!");
				
			}
			
		}
		
		
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0){
			
			player1Turn = true;
			textLabel.setText("X turn");
		}
		else {
			player1Turn = false;
			textLabel.setText("O turn");

		}
	}
	
	public void check() {
		
//		-------------------- X possibilities ---------------------
		
		if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			
			xWins(0, 1, 2);
		}
		if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			
			xWins(3, 4, 5);
		}
		if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
	
			xWins(6, 7, 8);
		}
		if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			
			xWins(0, 3, 6);
		}
		if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			
			xWins(1, 4, 7);
		}
		if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			
			xWins(2, 5, 8);
		}
		if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			
			xWins(0, 4, 8);
		}
		if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			
			xWins(2, 4, 6);
		}
		
//		-------------------- O possibilities ---------------------
		
		if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			
			oWins(0, 1, 2);
		}
		if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			
			oWins(3, 4, 5);
		}
		if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
	
			oWins(6, 7, 8);
		}
		if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			
			oWins(0, 3, 6);
		}
		if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			
			oWins(1, 4, 7);
		}
		if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			
			oWins(2, 5, 8);
		}
		if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
			
			oWins(0, 4, 8);
		}
		if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
			
			oWins(2, 4, 6);
		}
	}
	
	public void xWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textLabel.setText("X Wins");
	}
	
	public void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textLabel.setText("O Wins");
	}
	
	
	
}
