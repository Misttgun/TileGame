package dev.codenmore.tilegame.gfx;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;

/**
 * Classe qui gere la camera du jeu.
 * 
 * @author maurel
 *
 */
public class GameCamera {

	private Handler handler;

	/* Variables qui permettent de changer la position sur les axes. Si xOffset = 10, l'image est
	 * depalcee vers la gauche (-10). Si xOffset = -10, l'image est deplacee vers la droite (+10).
	 * Meme chose pour yOffset... */
	private float xOffset;
	private float yOffset;

	/**
	 * Constructeur de la camera.
	 * 
	 * @param handler
	 * @param xOffset
	 * @param yOffset
	 */
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	/**
	 * Methode qui verifie les espaces blanc sur l'ecran du jeu.
	 */
	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}

		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}

	/**
	 * Methode qui permet de centrer la camera sur une entite (joueur, monstre, etc).
	 * 
	 * @param e
	 *            (entite)
	 */
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}

	/**
	 * Methode qui permet de deplacer la camera.
	 * 
	 * @param xAmt
	 * @param yAmt
	 */
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	// Getters Setters

	/**
	 * @return the xOffset
	 */
	public float getxOffset() {
		return xOffset;
	}

	/**
	 * @param xOffset
	 *            the xOffset to set
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	/**
	 * @return the yOffset
	 */
	public float getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset
	 *            the yOffset to set
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
