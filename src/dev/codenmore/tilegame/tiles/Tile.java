package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Classe mere qui definit les tiles dans le jeu (herbe, pierre, terre, etc).
 * 
 * @author maurel
 *
 */
public class Tile {

	/**
	 * Tableau de tiles qui stocke toutes les tiles du jeu.
	 */
	public static Tile[] tiles = new Tile[256];
	
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);

	public static final int TILEWIDTH = 64;
	public static final int TILEHEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;

	/**
	 * Constructeur de la tile
	 * 
	 * @param texture
	 * @param id
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	/**
	 * Methode qui mets a jour la tile
	 */
	public void tick() {

	}

	/**
	 * Methode qui gere le rendu de la tile
	 * 
	 * @param g
	 * @param x
	 * @param y
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	/**
	 * Methode qui verifie si la tile est solide.
	 * 
	 * @return true (si la tile est solide)
	 */
	public boolean isSolid() {
		return false;
	}

	// Getters Setters

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
