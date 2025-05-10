package edu.wm.cs.cs301.guimemorygame.view;
import edu.wm.cs.cs301.guimemorygame.Main;
import edu.wm.cs.cs301.guimemorygame.controller.InputLeaderboard;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import edu.wm.cs.cs301.guimemorygame.model.*;

public class MemoryGameFrame {
	
	private final JFrame frame;
	public MemoryGameModel model;
	public static int difficulty = 0;
	private final MemoryGameGridPanel memorygameGridPanel;
	private static JLabel turnCounterLabel;
	
	public MemoryGameFrame(MemoryGameModel model) {
		this.model = model;
		difficulty = getDifficulty();
		if (difficulty == 0) {
            InputLeaderboard inputLeaderboard = new InputLeaderboard();
            inputLeaderboard.InputLeaderboard();
            inputLeaderboard.getUsername();
        } 
		this.memorygameGridPanel = new MemoryGameGridPanel(model, this);
		this.frame = createGUI();
		new LeaderboardDialog(this);
		if (getDifficulty() == 0) {
			new Instructions(this);
		}
		
	}
	
	public void getLeaderboard() {
		new LeaderboardDialog(this);
	}
	
	public static int getDifficulty() {
		return difficulty;
	}
	
	public static String getDifficultyString() {
		if (difficulty == 0 || difficulty == 2) {
			return "normal";
		} else if (difficulty == 1){
			return "easy";
		} else { return "hard";}
	}
	public void setDifficulty(int j) {
		if (difficulty != j) {
			difficulty = j; }
			frame.dispose();
			new MemoryGameFrame(this.model = new MemoryGameModel());
		
	}
	private JFrame createGUI() {
		JFrame frame = new JFrame("Memory Game");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setJMenuBar(createMenu());
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				shutdown();
			}
		});
		frame.add(createTitle(), BorderLayout.NORTH);
		frame.add(memorygameGridPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		System.out.println("Frame size: " + frame.getSize());
		
		return frame;
	}
	
	private JMenuBar createMenu() {
		JMenuBar menu = new JMenuBar();
		JMenu difficultyMenu = new JMenu("Difficulty");
		JMenu instructionsMenu = new JMenu("Instructions");
		JMenu exitMenu = new JMenu("Exit");
		menu.add(exitMenu);
		menu.add(difficultyMenu);
		menu.add(instructionsMenu);
		
		JMenuItem exitItem = new JMenuItem("Exit Game");
		exitItem.addActionListener(event -> shutdown());
		exitMenu.add(exitItem);
		
		JMenuItem instructionsItem = new JMenuItem("Instructions");
		instructionsItem.addActionListener(event -> new Instructions(this));
		instructionsMenu.add(instructionsItem);
		
		JMenuItem HardItem = new JMenuItem("Hard");
		HardItem.addActionListener(event -> setDifficulty(3)); MemoryGameGridPanel.resetTurns();
		difficultyMenu.add(HardItem);
		
		JMenuItem MediumItem = new JMenuItem("Medium");
		MediumItem.addActionListener(event -> setDifficulty(2));MemoryGameGridPanel.resetTurns();
		difficultyMenu.add(MediumItem);
		
		JMenuItem EasyItem = new JMenuItem("Easy");
		EasyItem.addActionListener(event -> setDifficulty(1));MemoryGameGridPanel.resetTurns();
		difficultyMenu.add(EasyItem);
		
		return menu;
	}
	
	private JPanel createTitle() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
		
		InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "cancelAction");
		ActionMap actionMap = panel.getActionMap();
		actionMap.put("cancelAction", new CancelAction());
		turnCounterLabel = new JLabel("Turns: 0");
        panel.add(turnCounterLabel);
	
	JLabel label = new JLabel("Memory Game");
	panel.add(label);
	
	return panel;
	}
	
	public static void updateTurnCounter(int turns) {
		turnCounterLabel.setText("Turns: "+ turns);
	}
	
	public void shutdown() {
		frame.dispose();
		System.exit(0);
	}
	
	public void repaintMemoryGameGridPanel() {
		memorygameGridPanel.repaint();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	private class CancelAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent events) {
			shutdown();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
