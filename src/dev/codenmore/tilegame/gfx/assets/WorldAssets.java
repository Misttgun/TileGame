package dev.codenmore.tilegame.gfx.assets;

import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;

/**
 * Classe qui gere les assets (images) du monde (map ou niveau).
 * 
 * @author maurel
 *
 */
public class WorldAssets {

	// Variables qui definissent la taille des grilles dans le spritesheet
	private static final int width = 32;
	private static final int height = 32;

	// Declaration des images sur le spritesheet
	public static BufferedImage player, dirt, grass, stone, tree;

	/**
	 * Methode qui initialise le spritesheet
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width * 2, height * 2);
	}

}
