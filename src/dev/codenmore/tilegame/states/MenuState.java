package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

/**
 * Classe qui definit les states (etats) du ou des menus
 * 
 * @author maurel
 *
 */
public class MenuState extends State {

	// Listes des options du menu.
	private String[] options = { "Start", "Help", "Quit" };
	private int currentSelection = 0;

	/**
	 * Constructeur du state (etat) menu
	 * 
	 * @param handler
	 * @param stateManager
	 */
	public MenuState(Handler handler, StateManager stateManager) {
		super(handler, stateManager);
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
			g.setFont(new Font("Arial", Font.PLAIN, 70));
			g.drawString(options[i], Game.WIDTH / 2 - 80, 100 + i * 150);
		}
	}

	/**
	 * Methode qui recupere les informations du clavier afin de naviguer le menu.
	 */
	private void getInput() {

		if (handler.getKeyManager().up.isPressed()) {
			currentSelection--;
			System.out.println(handler.getKeyManager().up.getNumTimesPressed());
			if (currentSelection < 0) {
				currentSelection = 0;
			}

		} else if (handler.getKeyManager().down.isPressed()) {
			currentSelection++;
			if (currentSelection > options.length -1) {
				currentSelection = options.length - 1;
			}
		}
		if (handler.getKeyManager().enter.isPressed()) {
			if (currentSelection == 0) {
				stateManager.getStates().push(new Level1State(handler, stateManager));
			} else if (currentSelection == 1) {

			} else if (currentSelection == 2) {
				System.exit(0);
			}
		}
	}

}
