package edu.cuny.brooklyn.cisc3120.project.game.Target;

public abstract class TargetShape {
	private int[][] targetCells;
	private int width;
	private int height;

	public TargetShape() {
		targetCells = null;
	}

	public int[][] getTargetCells() {
		return targetCells;
	}

	public void setTargetCells(int[][] targetCells) {
		this.targetCells = targetCells;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		width = w;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		height = h;
	}
}
