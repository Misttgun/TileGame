package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

/**
 * Classe qui definit le joueur.
 * 
 * @author maurel
 *
 */
public class Player extends Creature {

	private Animation animDown, animUp, animLeft, animRight, animStand_down, animStand_up, animStand_left,
			animStand_right;

	/**
	 * Constructeur du joueur.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		// Declaration de la collision box du joueur.
		bounds.x = 16;
		bounds.y = 38;
		bounds.width = 32;
		bounds.height = 26;

		// Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		animStand_down = new Animation(10000, Assets.player_stand_down);
		animStand_up = new Animation(10000, Assets.player_stand_up);
		animStand_left = new Animation(10000, Assets.player_stand_left);
		animStand_right = new Animation(10000, Assets.player_stand_right);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animStand_down.tick();
		animStand_up.tick();
		animStand_left.tick();
		animStand_right.tick();

		// Mouvements
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	/**
	 * Methode qui recupere les informations du clavier afin de deplacer le joueur.
	 */
	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			movingDir = 0;
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			movingDir = 1;
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			movingDir = 2;
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			movingDir = 3;
			xMove = speed;
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
				return animStand_left.getCurrentFrame();
			}
		} else if (movingDir == 3) {
			if (xMove > 0) {
				return animRight.getCurrentFrame();
			} else {
				return animStand_right.getCurrentFrame();
			}
		} else if (movingDir == 0) {
			if (yMove < 0) {
				return animUp.getCurrentFrame();
			} else {
				return animStand_up.getCurrentFrame();
			}
		} else if (movingDir == 1) {
			if (yMove > 0) {
				return animDown.getCurrentFrame();
			} else {
				return animStand_down.getCurrentFrame();
			}
		}
		return null;
	}

}
