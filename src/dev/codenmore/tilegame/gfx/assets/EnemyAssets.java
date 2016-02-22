/**
 * 
 */
package dev.codenmore.tilegame.gfx.assets;

import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;

/**
 * Classe qui gere les assets (images) de l'ennemi.
 * 
 * @author maurel
 *
 */
public class EnemyAssets {

	// Variables qui definissent la taille des grilles dans le spritesheet
	private static final int width = 32;
	private static final int height = 32;

	// Declaration des images sur le spritesheet
	public static BufferedImage[] enemy_down, enemy_up, enemy_left, enemy_right;

	/**
	 * Methode qui initialise le spritesheet
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		enemy_down = new BufferedImage[3];
		enemy_up = new BufferedImage[3];
		enemy_left = new BufferedImage[3];
		enemy_right = new BufferedImage[3];

		enemy_down[0] = sheet.crop(0, height * 3, width, height);
		enemy_down[1] = sheet.crop(width, height * 3, width, height);
		enemy_down[2] = sheet.crop(width * 2, height * 3, width, height);

		enemy_left[0] = sheet.crop(0, height * 4, width, height);
		enemy_left[1] = sheet.crop(width, height * 4, width, height);
		enemy_left[2] = sheet.crop(width * 2, height * 4, width, height);

		enemy_right[0] = sheet.crop(0, height * 5, width, height);
		enemy_right[1] = sheet.crop(width, height * 5, width, height);
		enemy_right[2] = sheet.crop(width * 2, height * 5, width, height);

		enemy_up[0] = sheet.crop(0, height * 6, width, height);
		enemy_up[1] = sheet.crop(width, height * 6, width, height);
		enemy_up[2] = sheet.crop(width * 2, height * 6, width, height);
	}
}
