package edu.cuny.brooklyn.cisc3120.project.game.Weapon;

public abstract class Gun {
	private int spread;

	public abstract int getSpread();

	public abstract boolean withinShootingArea(int xGuess, int yGuess);
}
