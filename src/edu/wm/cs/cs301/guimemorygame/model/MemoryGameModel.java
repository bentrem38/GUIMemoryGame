package edu.wm.cs.cs301.guimemorygame.model;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.wm.cs.cs301.guimemorygame.controller.Alphabet;
import edu.wm.cs.cs301.guimemorygame.controller.ArabicAlphabet;
import edu.wm.cs.cs301.guimemorygame.view.MemoryGameFrame;
import edu.wm.cs.cs301.guimemorygame.model.GamePiece;

public class MemoryGameModel {
	private final GamePiece[][] board;
	public int columnCount, maximumRows;
	
	public MemoryGameModel() {
		MemoryGameDifficulty();
		this.board = new GamePiece[maximumRows][columnCount];
		int j = 0;
		Character[] list = Boardstring();
		
		for (int i = 0; i < maximumRows; i++) {
			for (int k = 0; k < columnCount; k++) {
				board[i][k] = new CharacterGamePiece(list[j]);
				j++;
			}
		}
	} 

	
	public Character[] Boardstring() {
	    int num_of_l;

	    if (maximumRows == 3) {
	        num_of_l = 6;
	    } else if (maximumRows == 4) {
	        num_of_l = 14;
	    } else if (maximumRows == 7) {
	        num_of_l = 28;
	    } else {
	        throw new IllegalArgumentException("Invalid row value: " + maximumRows);
	    }
	    
	    char[] alpha = new ArabicAlphabet().toCharArray();
	    Character[] n_alpha = new Character[num_of_l*2];
	    System.out.println(alpha);
	    for (int i=0; i < num_of_l; i++) {
	    	n_alpha[i*2] = alpha[i];
	    	n_alpha[i*2+1] = alpha[i];
	    }
	    
	    List<Character> o_alpha = Arrays.asList(n_alpha);
	    Collections.shuffle(o_alpha);
	    o_alpha.toArray(n_alpha);
	    return n_alpha;
	} 
	
	public GamePiece[][] getBoard() {
		return board;
	}
	
	
	
	public void MemoryGameDifficulty() {
		int mode = MemoryGameFrame.getDifficulty();
		
		if (mode == 2) {
			this.columnCount = 7;
			this.maximumRows = 4;
		} else if (mode == 3) {
			this.columnCount = 8;
			this.maximumRows = 7;
		} else if (mode == 0) {
			this.columnCount = 7;
			this.maximumRows = 4;
		} else if (mode == 1) {
			this.columnCount = 4;
			this.maximumRows = 3;
		}
    }
	}