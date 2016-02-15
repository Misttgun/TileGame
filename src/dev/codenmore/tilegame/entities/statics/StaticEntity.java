package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

/**
 * Classe qui definit et gere les entites qui ne se deplacent pas (arbres, pierres, etc).
 * 
 * @author maurel
 *
 */
public abstract class StaticEntity extends Entity {

	/**
	 * Constructeur de l'entite statique.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
