package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.assets.WorldAssets;

/**
 * Classe qui definit la terre (sol) dans le jeu.
 * 
 * @author maurel
 *
 */
public class DirtTile extends Tile {
	/**
	 * Constructeur de la terre (sol, boue).
	 * 
	 * @param id
	 */
	public DirtTile(int id) {
		super(WorldAssets.dirt, id);
	}

}
