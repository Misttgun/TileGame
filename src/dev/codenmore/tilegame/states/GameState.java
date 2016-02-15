package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.World;

/**
 * Classe qui definit les states (etats) du jeu (niveaux, combats, etc).
 * 
 * @author maurel
 *
 */
public class GameState extends State {

	private World world;

	/**
	 * Constructeur du gameState. Initialise le joueur et le monde (niveau).
	 * 
	 * @param handler
	 */
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
