package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;

/**
 * Classe qui definit et gere un monde (niveau, map)
 * 
 * @author maurel
 *
 */
public class World {

	private Handler handler;

	private int width;
	private int height;
	private int spawnX;
	private int spawnY;

	/**
	 * Tableau de 2 dimensions qui represente la carte du monde.
	 */
	private int[][] tiles;

	// Entites
	private EntityManager entityManager;

	/**
	 * Constructeur du monde (niveau) du jeu.
	 * 
	 * @param path
	 *            (url du fichier)
	 * @param handler
	 */
	public World(Handler handler, String path) {
		this.handler = handler;

		entityManager = new EntityManager(handler, new Player(handler, 10, 10));
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Tree(handler, 150, 350));
		entityManager.addEntity(new Tree(handler, 400, 450));

		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	/**
	 * Methode qui mets a jour le monde (niveau).
	 */
	public void tick() {
		entityManager.tick();
	}

	/**
	 * Methode qui gere le rendu du monde (niveau, map).
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}

		// Entites
		entityManager.render(g);
	}

	/**
	 * Methode qui recupere la tile a afficher
	 * 
	 * @param x
	 * @param y
	 * @return la tile trouvee
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.rockTile;
		}

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) return Tile.dirtTile;
		return t;
	}

	/**
	 * Methode qui charge le monde (niveau, map).
	 * 
	 * @param path
	 *            (url du fichier)
	 */
	private void loadWorld(String path) {
		// On recupere le fichier en string
		String file = Utils.loadFileAsString(path);

		// On convertit le fichier en tableau de string
		String[] tokens = file.split("\\s+");

		// On utilise les donnees du tableau pour definir nos variables
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		// Initialisation du tableau de tiles
		tiles = new int[width][height];

		// Remplissange du tableau de tiles
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	// Getters Setters

	/**
	 * @return the spawnX
	 */
	protected int getSpawnX() {
		return spawnX;
	}

	/**
	 * @param spawnX
	 *            the spawnX to set
	 */
	protected void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	/**
	 * @return the spawnY
	 */
	protected int getSpawnY() {
		return spawnY;
	}

	/**
	 * @param spawnY
	 *            the spawnY to set
	 */
	protected void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
