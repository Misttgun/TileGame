/**
 * 
 */
package dev.codenmore.tilegame.input;

/**
 * Classe qui gere les touches du jeu.
 * 
 * @author maurel
 *
 */
public class Key {

	// Variables qui gerent les etats de la touche.
	public boolean keyStateDown;
	public boolean lastKeyState;

	public boolean isTappedDown;
	public boolean isPressedDown;

	/**
	 * Methode qui reinitialise la touche.
	 */
	public void reset() {
		this.keyStateDown = false;
		this.isTappedDown = false;
		this.isPressedDown = false;
		this.lastKeyState = false;
	}
}
