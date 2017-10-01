package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

import edu.cuny.brooklyn.cisc3120.project.game.GameBoard;

public class ShotGun extends Gun {

	private GameBoard board;

	public ShotGun(GameBoard b) {
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

		for (int i = xGuess - 1; i <= xGuess + 1; i++) {
			for (int j = yGuess - 1; j <= yGuess + 1; j++) {

				if (board[i][j] == 'X')
					return true;

			}
		}

		return false;

	}

}
