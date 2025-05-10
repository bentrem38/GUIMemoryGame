package edu.wm.cs.cs301.guimemorygame.model;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.wm.cs.cs301.guimemorygame.view.MemoryGameFrame;

public class PlayAgain extends JFrame{
	public MemoryGameModel model;
	private JButton playAgain;
	private MemoryGameFrame mgf;
	private JButton exit;
	
	public PlayAgain(MemoryGameFrame mgf) {
        this.mgf = mgf;
		setTitle("Play Again");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		exit = new JButton("exit");
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mgf.shutdown();
				dispose();
				
			}
		});
		
		playAgain = new JButton("Play again");
		playAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mgf.getFrame().dispose();
				new MemoryGameFrame(new MemoryGameModel());
				dispose();
			}
		});
		
		
		add(exit);
		add(playAgain);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}