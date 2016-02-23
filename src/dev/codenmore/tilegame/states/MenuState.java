package dev.codenmore.tilegame.states;

import java.awt.Font;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;

/**
 * Classe qui definit et gere les menus du jeu.
 * 
 * @author maurel
 *
 */
public abstract class MenuState extends State {

	// Police des menus.
	protected Font font1 = new Font("Arial", Font.PLAIN, 70);
	protected Font font2 = new Font("Arial", Font.PLAIN, 50);
	protected Font font3 = new Font("Arial", Font.PLAIN, 25);

	/**
	 * Constructeur du state (etat) menu
	 * 
	 * @param handler
	 */
	public MenuState(Handler handler) {
		super(handler, handler.getStateManager());
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {

	}

	/**
	 * Methode qui recupere les informations du clavier afin de naviguer le menu.
	 */
	protected abstract void getInput();

}
