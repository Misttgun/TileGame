package dev.codenmore.tilegame.states;

/**
 * Classe qui gere les differents etats du jeu.
 * 
 * @author maurel
 *
 */
public class StateManager {

	private static State currentState = null;

	/**
	 * @return the currentState
	 */
	public static State getState() {
		return currentState;
	}

	/**
	 * @param currentState
	 *            the currentState to set
	 */
	public static void setState(State currentState) {
		StateManager.currentState = currentState;
	}

}
