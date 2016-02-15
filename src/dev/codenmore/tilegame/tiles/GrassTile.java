package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

/**
 * Classe qui definit l'herbe dans le jeu.
 * 
 * @author maurel
 *
 */
public class GrassTile extends Tile {

	/**
	 * Constructeur de l'herbe.
	 * 
	 * @param id
	 */
	public GrassTile(int id) {
		super(Assets.grass, id);
	}

}
