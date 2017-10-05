package edu.cuny.brooklyn.cisc3120.project.game.Target;

import java.util.Random;

public class TriangleTargetShape extends TargetShape {
	public TriangleTargetShape() {

		Random rnd = new Random();

		int w = rnd.nextInt(10) + 2;
		int h = w;

		int[][] targetCells = new int[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < i; j++) {
				targetCells[i][j] = 'X';
			}

			for (int k = i; k < h; k++) {
				targetCells[i][k] = ' ';
			}

		}


		super.setTargetCells(targetCells);
		super.setWidth(w);
		super.setHeight(h);
	}
}
