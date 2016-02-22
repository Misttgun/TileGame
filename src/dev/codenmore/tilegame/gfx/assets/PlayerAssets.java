package dev.codenmore.tilegame.gfx.assets;

import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;

/**
 * Classe qui gere les assets (images) du joueur.
 * 
 * @author maurel
 *
 */
public class PlayerAssets {
	// Variables qui definissent la taille des grilles dans le spritesheet
	private static final int width = 32;
	private static final int height = 32;

	// Declaration des images sur le spritesheet
	public static BufferedImage[] player_down, player_up, player_left, player_right;

	/**
	 * Methode qui initialise le spritesheet
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		player_down = new BufferedImage[3];
		player_up = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];

		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);
		player_down[2] = sheet.crop(width * 6, 0, width, height);

		player_left[0] = sheet.crop(width * 4, height, width, height);
		player_left[1] = sheet.crop(width * 5, height, width, height);
		player_left[2] = sheet.crop(width * 6, height, width, height);

		player_right[0] = sheet.crop(width * 4, height * 2, width, height);
		player_right[1] = sheet.crop(width * 5, height * 2, width, height);
		player_right[2] = sheet.crop(width * 6, height * 2, width, height);

		player_up[0] = sheet.crop(width * 4, height * 3, width, height);
		player_up[1] = sheet.crop(width * 5, height * 3, width, height);
		player_up[2] = sheet.crop(width * 6, height * 3, width, height);
	}
}
