package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

import edu.cuny.brooklyn.cisc3120.project.game.GameBoard;

public class Rifle extends Gun {

	private GameBoard board;

	public Rifle(GameBoard b) {
		board = b;
	}

	@Override
	public void shoot() {
		// TODO
	}

	@Override
	public boolean withinShootingArea(int xGuess, int yGuess) {
		int[][] board = this.board.getBoard();

		if (xGuess >= board.length && yGuess >= board[0].length) {
			return false;
		}

		return board[xGuess][yGuess] == 'X';
	}

}
