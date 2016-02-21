package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.World;

/**
 * Classe qui definit le state (etat) du niveau 1 du jeu.
 * 
 * @author maurel
 *
 */
public class Level1State extends State {

	private World world;

	/**
	 * Constructeur du gameState. Initialise le joueur et le monde (niveau).
	 * 
	 * @param handler
	 */
	public Level1State(Handler handler) {
		super(handler, handler.getStateManager());
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
