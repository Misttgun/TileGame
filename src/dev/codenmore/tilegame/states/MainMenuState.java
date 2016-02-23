/**
 * 
 */
package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

/**
 * Classe qui definit et gere le menu principal du jeu.
 * 
 * @author maurel
 *
 */
public class MainMenuState extends MenuState {

	// Listes des options du menu.
	private String[] options = { "Start", "Help", "Quit" };
	private int currentSelection = 0;

	/**
	 * Constructeur du state (etat) menu
	 * 
	 * @param handler
	 */
	public MainMenuState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		getInput();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(102, 255, 255));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.WHITE);
			}

			// Dessin des options du menu.
			g.setFont(font1);
			g.drawString(options[i], Game.WIDTH / 2 - g.getFontMetrics().stringWidth(options[i]) / 2, 100 + i * 150);
		}
	}

	/**
	 * Methode qui recupere les informations du clavier afin de naviguer le menu.
	 */
	protected void getInput() {

		if ((handler.getKeyManager().up.keyStateDown && !handler.getKeyManager().up.lastKeyState)
				|| (handler.getKeyManager().z.keyStateDown && !handler.getKeyManager().z.lastKeyState)) {
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
			handler.getKeyManager().up.lastKeyState = true;
			handler.getKeyManager().z.lastKeyState = true;

		} else if ((handler.getKeyManager().down.keyStateDown && !handler.getKeyManager().down.lastKeyState)
				|| (handler.getKeyManager().s.keyStateDown && !handler.getKeyManager().s.lastKeyState)) {
			currentSelection++;
			if (currentSelection > options.length - 1) {
				currentSelection = 0;
			}
			handler.getKeyManager().down.lastKeyState = true;
			handler.getKeyManager().s.lastKeyState = true;
		}
		
		// Condition qui gere la touche enter
		if (handler.getKeyManager().enter.keyStateDown) {
			if (currentSelection == 0) {
				handler.getStateManager().getStates().push(new Level1State(handler));
			} else if (currentSelection == 1) {
				handler.getStateManager().getStates().push(new HelpMenuState(handler));
			} else if (currentSelection == 2) {
				System.exit(0);
			}
		}
	}

}
