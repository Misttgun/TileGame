package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
/**
 * Classe qui definit la pierre dans le jeu.
 * 
 * @author maurel
 *
 */
public class RockTile extends Tile {
	/**
	 * Constructeur de la pierre.
	 * 
	 * @param id
	 */
	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
