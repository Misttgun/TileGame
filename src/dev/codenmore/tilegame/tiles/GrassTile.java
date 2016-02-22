package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.assets.WorldAssets;

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
		super(WorldAssets.grass, id);
	}

}
