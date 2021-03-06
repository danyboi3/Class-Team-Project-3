package edu.cuny.brooklyn.cisc3120.project.game;

import edu.cuny.brooklyn.cisc3120.project.game.Target.PointTargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Target.RectangleTargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Target.TargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Target.TriangleTargetShape;
import edu.cuny.brooklyn.cisc3120.project.game.Weapon.Gun;
import edu.cuny.brooklyn.cisc3120.project.game.Weapon.Rifle;
import edu.cuny.brooklyn.cisc3120.project.game.Weapon.ShotGun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class TargetGame {

	private static Logger logger = LoggerFactory.getLogger(TargetGame.class);
	private final int GAME_TARGET_AREA_WIDTH = 80;
	private final int GAME_TARGET_AREA_HEIGHT = 25;
	GameBoard gameBoard;      // having its own dimension: cells
	GameDisplay gameDisplay;  // having its own dimension: cells to characters
	private Gun gun;
	private Random rng;
	private Scanner in;

	public TargetGame() {
		gameBoard = new GameBoard(GAME_TARGET_AREA_HEIGHT, GAME_TARGET_AREA_WIDTH);
		gameDisplay = new GameDisplay(gameBoard);
		rng = new Random();
		in = new Scanner(System.in);
		in.useDelimiter("(\\p{javaWhitespace}|,)+");
	}

	public void play() {
		boolean won = false;

		Random rnd = new Random();

		int r = rnd.nextInt(3);
		int j = rnd.nextInt(2);

		if (r == 0) {
			setTarget(new PointTargetShape());
			logger.debug("using point target");
		} else if (r == 1) {
			setTarget(new TriangleTargetShape());
			logger.debug("using triangle target");
		} else {
			setTarget(new RectangleTargetShape());
			logger.debug("using rectange target");
		}
		if (j == 0) {
			gun = new Rifle(gameBoard);
			logger.debug("using rifle gun");
		} else {
			gun = new ShotGun(gameBoard);
			logger.debug("using shotgun gun");
		}

		gameBoard.plotBorder();
		gameBoard.writeText(0, GAME_TARGET_AREA_HEIGHT - 1, "Enter your target position (x, y):");
		while (!won) {
			gameDisplay.draw();

			int xGuess = in.nextInt();
			int yGuess = in.nextInt();
			logger.debug("Player guessed x = " + xGuess + ", y = " + yGuess + ".");
			boolean hit = targetHit(xGuess, yGuess);
			showHit(xGuess, yGuess, gun.getSpread());
			if (hit) {
				gameBoard.plotBorder();
				gameBoard.writeText(0, GAME_TARGET_AREA_HEIGHT - 1, "You won. Game over.");
				won = true;
			} else {
				gameBoard.plotBorder();
				gameBoard.writeText(0, GAME_TARGET_AREA_HEIGHT - 1, "Try again. Enter your target position (x, y): ");
			}
			gameDisplay.draw();
		}
	}

	private void showHit(int x, int y, int spread) {
		logger.debug(x + " " + y + " " + spread);
		for(int i = x - spread; i <= x + spread; ++i) {
			for(int j = y - spread; j <= y + spread; ++j) {
				gameBoard.writeText(i, j, "O");
			}
		}
	}

	private void setTarget(TargetShape target) {
		int x = rng.nextInt(GAME_TARGET_AREA_WIDTH - 2);
		int y = rng.nextInt(GAME_TARGET_AREA_HEIGHT - 2);
		gameBoard.setTarget(x, y, target);
	}

	private boolean targetHit(int xGuess, int yGuess) {
		return gun.withinShootingArea(xGuess, yGuess);
	}
}
