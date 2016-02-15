package dev.codenmore.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.codenmore.tilegame.Handler;

/**
 * Classe mere qui definit toutes les entites du jeu.
 * 
 * @author maurel
 *
 */
public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	/**
	 * Constructeur de l'entite.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param handler
	 */
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(0, 0, width, height);
	}

	/**
	 * Methode qui mets a jour les entite.
	 */
	public abstract void tick();

	/**
	 * Methode qui gere le rendu de l'entite.
	 * 
	 * @param g
	 */
	public abstract void render(Graphics g);

	/**
	 * Methode qui verifie les collisions de nos entites
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @return vrai s'il y a collision
	 */
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) return true;
		}
		return false;
	}

	/**
	 * Methode qui permet recuperer le rectangle de collision de l'entite.
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @return le rectangle qui definit la zonr de collision de l'entite.
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}

	// Getters Setters

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
