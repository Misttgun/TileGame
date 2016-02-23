package dev.codenmore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe qui gere les touches dans le jeu.
 * 
 * @author maurel
 *
 */
public class KeyManager implements KeyListener {

	// Liste des touches du jeu.
	public Map<Key, Integer> keys = new HashMap<Key, Integer>();

	// Declaration des touches du jeu.
	public Key up, down, left, right, enter, space, q, z, s, d, echap;

	/**
	 * Constructeur du KeyManager
	 */
	public KeyManager() {
		// Initialisation des touches.
		up = new Key();
		down = new Key();
		left = new Key();
		right = new Key();
		enter = new Key();
		space = new Key();
		q = new Key();
		z = new Key();
		s = new Key();
		d = new Key();
		echap = new Key();

		// Ajout a la liste des touches du jeu.
		keys.put(up, KeyEvent.VK_UP);
		keys.put(down, KeyEvent.VK_DOWN);
		keys.put(left, KeyEvent.VK_LEFT);
		keys.put(right, KeyEvent.VK_RIGHT);
		keys.put(enter, KeyEvent.VK_ENTER);
		keys.put(space, KeyEvent.VK_SPACE);
		keys.put(q, KeyEvent.VK_Q);
		keys.put(s, KeyEvent.VK_S);
		keys.put(z, KeyEvent.VK_Z);
		keys.put(d, KeyEvent.VK_D);
		keys.put(echap, KeyEvent.VK_ESCAPE);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int code = event.getKeyCode();
		for (Key v : keys.keySet()) {
			if (keys.get(v) == code) {
				if (!v.keyStateDown) {
					final Key key = v;
					key.lastKeyState = key.keyStateDown;
					key.isTappedDown = true;
					key.isPressedDown = false;
					key.keyStateDown = true;

					if (key.keyStateDown) {
						key.isPressedDown = true;
						key.isTappedDown = false;
					}
					break;
				} else
					break;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		for (Key k : keys.keySet()) {
			if (keys.get(k) == event.getKeyCode()) {
				k.lastKeyState = k.keyStateDown;
				k.isPressedDown = false;
				k.isTappedDown = false;
				k.keyStateDown = false;
				break;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// Ignore. Used for sending Unicode character mapped as a system input.
	}
}
