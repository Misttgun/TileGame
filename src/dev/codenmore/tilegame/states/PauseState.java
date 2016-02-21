/**
 * 
 */
package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

/**
 * Classe qui definit et gere le menu pause dans le jeu.
 * 
 * @author maurel
 *
 */
public class PauseState extends MenuState {

	// Listes des options du menu.
	private String[] options = { "Resume", "Options", "Quit" };
	private int currentSelection = 0;

	/**
	 * Constructeur du menu pause.
	 * 
	 * @param handler
	 */
	public PauseState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		getInput();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(255, 153, 153));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection) {
				g.setColor(Color.BLUE);
			} else {
				g.setColor(Color.WHITE);
			}
			g.drawLine(Game.WIDTH/2, 0, Game.WIDTH/2, Game.HEIGHT);

			// Dessin des options du menu.
			g.setFont(font);
			g.drawString(options[i], Game.WIDTH / 2 - g.getFontMetrics().stringWidth(options[i])/2, 100 + i * 150);
		}
	}

	@Override
	protected void getInput() {
		if (handler.getKeyManager().up.keyStateDown && !handler.getKeyManager().up.lastKeyState) {
			currentSelection--;
			if (currentSelection < 0) {
				currentSelection = options.length - 1;
			}
			handler.getKeyManager().up.lastKeyState = true;

		} else if (handler.getKeyManager().down.keyStateDown && !handler.getKeyManager().down.lastKeyState) {
			currentSelection++;
			if (currentSelection > options.length - 1) {
				currentSelection = 0;
			}
			handler.getKeyManager().down.lastKeyState = true;
		}
		if (handler.getKeyManager().enter.keyStateDown) {
			if (currentSelection == 0) {
				handler.getStateManager().getStates().push(new Level1State(handler));
			} else if (currentSelection == 1) {

			} else if (currentSelection == 2) {
				System.exit(0);
			}
		}
	}

}
