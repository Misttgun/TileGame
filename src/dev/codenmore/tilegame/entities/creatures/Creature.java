package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;

/**
 * Classe mere qui definit les creature du jeu (monstre, humain, etc).
 * 
 * @author maurel
 *
 */
public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;

	protected int health;
	protected float speed;
	protected float xMove, yMove;
	protected int numSteps;

	/**
	 * Direction dans laquelle la creature se deplace. 0 (haut), 1 (bas), 2 (gauche) et 3 (droite).
	 */
	protected int movingDir = 1;

	/**
	 * Constructeur de la creature.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param handler
	 */
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		numSteps = 0;
	}

	/**
	 * Methode qui permet de deplacer la creature sur l'ecran.
	 */
	public void move() {
		if (x < 0) {
			x = 0;
		} else if (x > (handler.getWorld().getWidth() * Tile.TILEWIDTH)) {
			x = handler.getWorld().getWidth() - 1 * Tile.TILEWIDTH;
		}

		if (y < 0) {
			y = 0;
		} else if (y > (handler.getWorld().getHeight() * Tile.TILEHEIGHT)) {
			y = handler.getWorld().getHeight() * Tile.TILEHEIGHT;
		}

		if (!checkEntityCollisions(xMove, 0f)) {
			moveX();
			numSteps += 1;
		}
		if (!checkEntityCollisions(0f, yMove)) {
			moveY();
			numSteps += 1;
		}
		
		
	}

	/**
	 * Methode qui deplace la creature sur l'axe horizontal.
	 */
	public void moveX() {
		// Deplacement a droite
		if (xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			movingDir = 3;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			// Deplacement a gauche
		} else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			movingDir = 2;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}

	/**
	 * Methode qui deplace la creature sur l'axe vertical.
	 */
	public void moveY() {
		// Deplacement en haut
		if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			movingDir = 0;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			// Deplacement en bas
		} else if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			movingDir = 1;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	/**
	 * Methode qui verifie s'il y a collision avec la tile.
	 * 
	 * @param x
	 * @param y
	 * @return vrai s'il y a collision
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	// Getters Setters

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @param xMove
	 *            the xMove to set
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * @param yMove
	 *            the yMove to set
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
