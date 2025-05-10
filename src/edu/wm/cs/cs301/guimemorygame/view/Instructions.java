package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Instructions extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private final CancelAction cancelAction;
	private JEditorPane editorPane;
	
	public Instructions(MemoryGameFrame view) {
		super(view.getFrame(), "Instructions", true);
		this.cancelAction = new CancelAction();
		
		add(createMain(), BorderLayout.CENTER);
		add(createButton(), BorderLayout.SOUTH);
		 
		pack();
		setLocation(500, view.getFrame().getLocation().x);
		setVisible(true);
	}
	
	private JPanel createMain() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
		String instructions = "<html><p> HOW TO PLAY MEMORY GAME.</p>"
				+ "<p> Click on the boxes marked with '?' to turn them over. </p>"
				+ "<p> Get two in a row to make a match. </p>"
				+ "<p> How quickly can you find all the matches? Play to find out! </p>";
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setContentType("text/html");
		editorPane.setText(instructions);
		JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setPreferredSize(new Dimension(600, 480));
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}
	
	private JPanel createButton() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		
		InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelAction");
		ActionMap actionMap = panel.getActionMap();
		
		return panel;
	}
	
	private class CancelAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			dispose();
		}
		
	}

}
