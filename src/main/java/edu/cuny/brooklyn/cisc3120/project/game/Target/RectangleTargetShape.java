package edu.cuny.brooklyn.cisc3120.project.game.Target;

import java.util.Random;

public class RectangleTargetShape extends TargetShape {
	public RectangleTargetShape() {
		
		Random rnd = new Random();
		
		int w = rnd.nextInt(10) + 2;
		int h = rnd.nextInt(10) + 2;
		
		int[][] targetCells = new int[w][h];
		
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				targetCells[i][j] = 'X';
			}
		}
		
		
		super.setTargetCells(targetCells);
		super.setWidth(w);
		super.setHeight(h);
	}
}
