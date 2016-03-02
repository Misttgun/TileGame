package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.assets.PlayerAssets;

/**
 * Classe qui definit le joueur.
 * 
 * @author maurel
 *
 */
public class Player extends Creature {

	private Animation animDown, animUp, animLeft, animRight;

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
		animDown = new Animation(500, PlayerAssets.player_down);
		animUp = new Animation(500, PlayerAssets.player_up);
		animLeft = new Animation(500, PlayerAssets.player_left);
		animRight = new Animation(500, PlayerAssets.player_right);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();

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

		if (handler.getKeyManager().up.keyStateDown || handler.getKeyManager().z.keyStateDown) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down.keyStateDown || handler.getKeyManager().s.keyStateDown) {
			yMove = speed;
		}
		if (handler.getKeyManager().left.keyStateDown || handler.getKeyManager().q.keyStateDown) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right.keyStateDown || handler.getKeyManager().d.keyStateDown) {
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
