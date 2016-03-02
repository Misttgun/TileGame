/**
 * 
 */
package dev.codenmore.tilegame.entities.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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

		// Mouvements
		AIMove();
		move();
	}

	private void AIMove() {

		if (numSteps <= 100) {
			xMove = -speed;
		} else {
			xMove = speed;
		}

		if (numSteps >= 300) {
			numSteps = -100;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

	/**
	 * Methode recupere l'animation actuelle du joueur.
	 * 
	 * @return l'image de l'animation
	 */
	private BufferedImage getCurrentAnimationFrame() {
		if (movingDir == 2) {
			if (xMove < 0) {
				return animLeft.getCurrentFrame();
			} else {
				return animLeft.getCurrentFrame(1);
			}
		} else if (movingDir == 3) {
			if (xMove > 0) {
				return animRight.getCurrentFrame();
			} else {
				return animRight.getCurrentFrame(1);
			}
		} else if (movingDir == 0) {
			if (yMove < 0) {
				return animUp.getCurrentFrame();
			} else {
				return animUp.getCurrentFrame(1);
			}
		} else if (movingDir == 1) {
			if (yMove > 0) {
				return animDown.getCurrentFrame();
			} else {
				return animDown.getCurrentFrame(1);
			}
		}
		return null;
	}

}
