package dev.codenmore.tilegame;

import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.worlds.World;

/**
 * Classe qui permet de
 * 
 * @author maurel
 *
 */
public class Handler {

	private Game game;
	private World world;

	/**
	 * Constructeur du handler.
	 * 
	 * @param game
	 */
	public Handler(Game game) {
		this.game = game;
	}

	/**
	 * Methode qui recupere la camera du jeu.
	 * 
	 * @return la camera du jeu
	 */
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	/**
	 * Methode qui recupere le keymanager du jeu.
	 * 
	 * @return le keymanager du jeu
	 */
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	/**
	 * Methode qui recupere la largeur du jeu.
	 * 
	 * @return la largeur du jeu
	 */
	public int getWidth() {
		return game.getWidth();
	}

	/**
	 * Methode qui recupere la hauteur du jeu.
	 * 
	 * @return la hauteur du jeu
	 */
	public int getHeight() {
		return game.getHeight();
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game
	 *            the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world
	 *            the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}
}
