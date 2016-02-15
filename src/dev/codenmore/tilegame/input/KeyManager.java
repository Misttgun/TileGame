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

	private boolean[] keys;
	public boolean up, down, left, right;

	/**
	 * Constructeur du KeyManager.
	 */
	public KeyManager() {
		keys = new boolean[256];
	}

	/**
	 * Methode qui mets a jour les touches du claviers.
	 */
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
