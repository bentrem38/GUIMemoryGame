package edu.wm.cs.cs301.guimemorygame.model;

public interface GamePiece {
	public boolean equals(GamePiece other);
	public void setVisible(boolean v);
	public boolean isvisible();
	public Character getSymbol();
}
