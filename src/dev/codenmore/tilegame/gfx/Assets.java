package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	// Variables qui definissent la taille des grilles dans le spritesheet
	private static final int width = 32;
	private static final int height = 32;

	// Declaration des images sur le spritesheet
	public static BufferedImage player, dirt, grass, stone, tree;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_stand_down, player_stand_up,
			player_stand_left, player_stand_right;

	/**
	 * Methode qui initialise le spritesheet
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		player_stand_down = new BufferedImage[1];
		player_stand_up = new BufferedImage[1];
		player_stand_left = new BufferedImage[1];
		player_stand_right = new BufferedImage[1];
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];

		player_stand_down[0] = sheet.crop(width * 5, 0, width, height);
		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 6, 0, width, height);

		player_stand_up[0] = sheet.crop(width * 5, height * 3, width, height);
		player_up[0] = sheet.crop(width * 4, height * 3, width, height);
		player_up[1] = sheet.crop(width * 6, height * 3, width, height);

		player_stand_right[0] = sheet.crop(width * 5, height * 2, width, height);
		player_right[0] = sheet.crop(width * 4, height * 2, width, height);
		player_right[1] = sheet.crop(width * 6, height * 2, width, height);

		player_stand_left[0] = sheet.crop(width * 5, height, width, height);
		player_left[0] = sheet.crop(width * 4, height, width, height);
		player_left[1] = sheet.crop(width * 6, height, width, height);

		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width * 2, height * 2);
	}

}
