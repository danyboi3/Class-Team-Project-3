package edu.cuny.brooklyn.cisc3120.project.game;

import edu.cuny.brooklyn.cisc3120.project.game.Target.TargetShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameBoard {
	private static Logger logger = LoggerFactory.getLogger(GameBoard.class);
	int[][] boardCells;
	private int width;
	private int height;

	public GameBoard(int height, int width) {
		this.width = width;
		this.height = height;

		boardCells = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				boardCells[i][j] = ' ';
			}
		}
	}

	public int[][] getBoard() {
		return boardCells;
	}

	public void setTarget(int x, int y, TargetShape target) {
		for (int i = 0; i < target.getWidth() && x + i < boardCells[0].length; i++) {
			for (int j = 0; j < target.getHeight() && y + j < boardCells.length; j++) {
				logger.debug("placing target point at " + (y + j) + " " + (x + i));
				boardCells[y + j][x + i] = target.getTargetCells()[i][j];
			}
		}
	}

	public void plotBorder() {
		for (int i = 0; i < width; i++) {
			boardCells[0][i] = '-';
			boardCells[height - 1][i] = '-';
		}
		for (int i = 0; i < height; i++) {
			boardCells[i][0] = '|';
			boardCells[i][width - 1] = '|';
		}
	}

	public void writeText(int x, int y, String text) {
		if (x >= width || y < 0 || y >= height) {
			logger.debug("Text is outside of the displaying area.");
			return;
		}
		for (int i = 0; i < text.length(); i++) {
			if (x + i < 0) {
				logger.debug("Character " + text.charAt(i) + " in the text is outside of the displaying area.");
			} else {
				boardCells[y][x + i] = text.charAt(i);
			}
		}
	}
}
