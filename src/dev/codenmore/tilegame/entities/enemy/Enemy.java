/**
 * 
 */
package dev.codenmore.tilegame.entities.enemy;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Creature;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.assets.EnemyAssets;

/**
 * Classe qui definit un ennemi dans le jeu.
 * 
 * @author maurel
 *
 */
public class Enemy extends Creature {

	private Animation animDown, animUp, animLeft, animRight;

	/**
	 * Constructeur de l'ennemi.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		// Declaration de la collision box de l'enemi.
		bounds.x = 6;
		bounds.y = 38;
		bounds.width = 56;
		bounds.height = 26;

		// Animations
		animDown = new Animation(500, EnemyAssets.enemy_down);
		animUp = new Animation(500, EnemyAssets.enemy_up);
		animLeft = new Animation(500, EnemyAssets.enemy_left);
		animRight = new Animation(500, EnemyAssets.enemy_right);

	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animDown.getCurrentFrame(1), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

}
