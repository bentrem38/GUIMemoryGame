package edu.wm.cs.cs301.guimemorygame;

import javax.swing.SwingUtilities;

import edu.wm.cs.cs301.guimemorygame.view.MemoryGameFrame;
import edu.wm.cs.cs301.guimemorygame.model.MemoryGameModel;
public class Main implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
		

	}

	@Override
	public void run() {
		new MemoryGameFrame(new MemoryGameModel());
		
	}

}
