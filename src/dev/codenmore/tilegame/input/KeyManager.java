package dev.codenmore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe qui gere les touches dans le jeu.
 * 
 * @author maurel
 *
 */
public class KeyManager implements KeyListener {

	public Key up, down, left, right, enter;

	/**
	 * Constructeur du KeyManager.
	 */
	public KeyManager() {
		init();
	}

	/**
	 * Methode qui initialise les touches du jeu et les ajoute a la liste des touches.
	 */
	public void init() {
		up = new Key();
		down = new Key();
		left = new Key();
		right = new Key();
		enter = new Key();
	}

	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}

	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Methode qui verifie si la touche est appuye.
	 * 
	 * @param keyCode
	 * @param isPressed
	 */
	public void toggleKey(int keyCode, boolean isPressed) {
		if (keyCode == KeyEvent.VK_UP) {
			up.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			down.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			left.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			right.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_ENTER) {
			enter.toggle(isPressed);
		}

	}

}
