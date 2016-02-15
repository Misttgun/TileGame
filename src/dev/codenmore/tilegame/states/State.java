package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;

/**
 * Classe mere des differents states (etats) du jeu.
 * 
 * @author maurel
 *
 */
public abstract class State {

	protected Handler handler;

	/**
	 * Constructeur du state (etat)
	 * 
	 * @param handler
	 */
	public State(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Methode qui mets a jour le state (etat)
	 */
	public abstract void tick();

	/**
	 * Methode qui gere le rendu du state (etat)
	 * 
	 * @param g
	 */
	public abstract void render(Graphics g);

}
