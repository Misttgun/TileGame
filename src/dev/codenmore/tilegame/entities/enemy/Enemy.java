/**
 * 
 */
package dev.codenmore.tilegame.entities.enemy;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Creature;

/**
 * Classe qui definit un ennemi dans le jeu.
 * 
 * @author maurel
 *
 */
public class Enemy extends Creature {

	/**
	 * Constructeur de l'ennemi.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

	}

}
