package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;

	/**
	 * Constructeur du spridesheet
	 * 
	 * @param sheet
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	/**
	 * Methode qui coupe le spritesheet et qui le permet d'afficher separement
	 * les differentes images de ce dernier.
	 * 
	 * @param x
	 *            (position horizontale)
	 * @param y
	 *            (position verticale)
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}

}
