package edu.wm.cs.cs301.guimemorygame.model;

public class CharacterGamePiece implements GamePiece {
	private final Character symbol;
	private boolean visible;
	public CharacterGamePiece(char s) { 
		this.symbol = s; 
		this.visible = false;
	}
	@Override
	public Character getSymbol() {
		
		return symbol;
	}
	@Override
	public void setVisible(boolean v) {
		this.visible = v;
	}
	@Override
	public boolean isvisible() {
		return visible;
	}
	@Override
	public boolean equals(GamePiece other) {
		if (this == other) {
			return true;
		} else {
			return false;
		}
	}
	
}
