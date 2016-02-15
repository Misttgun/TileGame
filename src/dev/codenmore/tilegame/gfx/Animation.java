package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Classe qui definit et gere les animations.
 * 
 * @author maurel
 *
 */
public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;

	/**
	 * Constructeur de l'animation.
	 * 
	 * @param speed
	 *            (vitesse en millisecondes)
	 * @param frames
	 *            (le tableau d'image de l'animation)
	 */
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	/**
	 * Methode qui mets a jour l'animation.
	 */
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) index = 0;
		}
	}

	/**
	 * Methode qui recupere la frame actuelle de l'animation.
	 * 
	 * @return l'image de l'animation
	 */
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
