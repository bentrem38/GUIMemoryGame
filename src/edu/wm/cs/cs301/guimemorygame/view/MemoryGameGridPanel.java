package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.wm.cs.cs301.guimemorygame.controller.InputLeaderboard;
import edu.wm.cs.cs301.guimemorygame.controller.Leaderboard;
import edu.wm.cs.cs301.guimemorygame.model.GamePiece;
import edu.wm.cs.cs301.guimemorygame.model.LeaderboardDialog;
import edu.wm.cs.cs301.guimemorygame.model.MemoryGameModel;
import edu.wm.cs.cs301.guimemorygame.model.PlayAgain;

public class MemoryGameGridPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JButton[][] tiles;
    public static int turns = 0;
    private MemoryGameModel model;
    private JButton firstClickedButton;
    private JButton secondClickedButton;
    private MemoryGameFrame memoryGameFrame;

    public MemoryGameGridPanel(MemoryGameModel model, MemoryGameFrame memoryGameFrame) {
        this.model = model;
        this.memoryGameFrame = memoryGameFrame;
        makePanel();
    }

    private void makePanel() {
        int row = model.maximumRows;
        int col = model.columnCount;
        setLayout(new GridLayout(row, col));
        tiles = new JButton[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                JButton button = new JButton("?");
                button.setPreferredSize(new Dimension(50, 50));
                tiles[i][j] = button;
                add(button);
                final int ii = i;
                final int jj = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(button, ii, jj);
                    }
                });
            }
        }
    }

    public static void resetTurns() {
    	turns = 0;
    }
    
    private void handleButtonClick(JButton button, int row, int col) {
    	if (firstClickedButton == null || secondClickedButton == null) {
    	if (!model.getBoard()[row][col].isvisible()) {
            model.getBoard()[row][col].setVisible(true);
            button.setText(String.valueOf(model.getBoard()[row][col].getSymbol()));

            if (firstClickedButton == null) {
                firstClickedButton = button;
            } else {
                secondClickedButton = button;
                if (!model.getBoard()[getButtonRow(firstClickedButton)][getButtonCol(firstClickedButton)].getSymbol().equals(model.getBoard()[getButtonRow(secondClickedButton)][getButtonCol(secondClickedButton)].getSymbol())) {
                	MemoryGameFrame.updateTurnCounter(turns+=1);
                	new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                hideButtons();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } else {
                	firstClickedButton = null;
                    secondClickedButton = null;
                    MemoryGameFrame.updateTurnCounter(turns+=1);
                    if (finishedGame()) {
                    	while (InputLeaderboard.getUsername() == "null") {
                    	} 
                    	if (InputLeaderboard.getUsername() != "null") {
                    		if (MemoryGameFrame.getDifficulty() == 0) {
                    			memoryGameFrame.setDifficulty(2);
                    		}
                    		Leaderboard.addToLB(MemoryGameFrame.getDifficultyString(), InputLeaderboard.getUsername(), turns);
                            new PlayAgain(memoryGameFrame);
                            }
                        }
                    	
                    	}
                    }
                }}
            }

    private void hideButtons() {
        firstClickedButton.setText("?");
        secondClickedButton.setText("?");
        model.getBoard()[getButtonRow(firstClickedButton)][getButtonCol(firstClickedButton)].setVisible(false);
        model.getBoard()[getButtonRow(secondClickedButton)][getButtonCol(secondClickedButton)].setVisible(false);
        firstClickedButton = null;
        secondClickedButton = null;
    }

    private boolean finishedGame() {
    	for (int i=0; i<model.maximumRows;i++) {
        	for (int j=0; j<model.columnCount;j++) {
        		if (!model.getBoard()[i][j].isvisible()) {
        			return false;
        		} 
        	}
        }
    	return true;
    }
    
    private int getButtonRow(JButton button) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == button) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getButtonCol(JButton button) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == button) {
                    return j;
                }
            }
        }
        return -1;
    }
}