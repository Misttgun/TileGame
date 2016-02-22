package dev.codenmore.tilegame.entities.statics;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.assets.WorldAssets;
import dev.codenmore.tilegame.tiles.Tile;

/**
 * Classe qui definit un arbre dans le jeu.
 * 
 * @author maurel
 *
 */
public class Tree extends StaticEntity {

	/**
	 * Constructeur de l'arbre.
	 * 
	 * @param handler
	 * @param x
	 * @param y
	 */
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH * 2, Tile.TILEHEIGHT * 2);

		bounds.x = width/4;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width/2;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(WorldAssets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
