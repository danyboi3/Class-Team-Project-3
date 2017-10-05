package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

import edu.cuny.brooklyn.cisc3120.project.game.GameBoard;

public class ShotGun extends Gun {

	private GameBoard board;

	private int spread = 1;

	public ShotGun(GameBoard b) {
		board = b;
	}

	@Override
	public int getSpread() {
		return spread;
	}

	@Override
	public boolean withinShootingArea(int xGuess, int yGuess) {
		int[][] board = this.board.getBoard();

		if (xGuess < 0 || yGuess < 0) {
			return false;
		}

		for (int i = xGuess - spread; i <= xGuess + spread; i++) {
			for (int j = yGuess - spread; j <= yGuess + spread; j++) {

				if (board.length > j && board[j].length > i && board[j][i] == 'X')
					return true;

			}
		}

		return false;

	}

}
