package edu.wm.cs.cs301.guimemorygame.controller;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InputLeaderboard extends JFrame{
	
	private JTextField input;
	private JButton enter;
	private static String username;
	
	public void InputLeaderboard() {
		setTitle("Username Input");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		input = new JTextField(12);
		enter = new JButton("Enter");
		
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validUsername(input.getText())) {
					username = input.getText();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "username must not have spaces in name");
				}
				
			}
		});
		add(input);
		add(enter);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private boolean validUsername(String input) {
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			 @Override
			 public void run() {
				 InputLeaderboard lb = new InputLeaderboard();
			 }
		 });
		 return getUsername();
	}
}
