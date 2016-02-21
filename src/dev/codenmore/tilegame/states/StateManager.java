package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.util.Stack;

import dev.codenmore.tilegame.Handler;

/**
 * Classe qui gere les differents etats du jeu.
 * 
 * @author maurel
 *
 */
public class StateManager {

	private Stack<State> states;
	@SuppressWarnings("unused")
	private Handler handler;

	/**
	 * Constructeur du StateManager.
	 * 
	 * @param handler
	 */
	public StateManager(Handler handler) {
		states = new Stack<>();
		this.handler = handler;
		states.push(new MainMenuState(handler));
	}

	/**
	 * Methode qui mets a jour le state manager.
	 */
	public void tick() {
		states.peek().tick();
	}

	/**
	 * Methode qui gere le rendu du state manager.
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		states.peek().render(g);
	}

	// Getters Setters

	/**
	 * @return the states
	 */
	public Stack<State> getStates() {
		return states;
	}

}
