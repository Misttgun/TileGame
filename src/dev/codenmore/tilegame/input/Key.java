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

	// Declaration de la variable bouton appuye
	private boolean pressed = false;

	// Declaration de la variable nombre d'appuis
	private int numTimesPressed = 0;

	/**
	 * Methode qui retourne le nombre de fois qu'une touche est appuye
	 * 
	 * @return le nombre d'appuis
	 */
	public int getNumTimesPressed() {
		return numTimesPressed;
	}

	/**
	 * Methode qui verifie si la touche est appuye
	 * 
	 * @return true si le bouton est appuye
	 */
	public boolean isPressed() {
		return pressed;
	}

	/**
	 * Methode qui appuie la touche
	 * 
	 * @param isPressed
	 */
	public void toggle(boolean isPressed) {
		pressed = isPressed;
		if (pressed) {
			numTimesPressed++;
		}
	}
}
