/**
 * 
 */
package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

/**
 * Classe qui definit mon menu aide ou options.
 * 
 * @author maurel
 *
 */
public class HelpMenuState extends MenuState {

	private String msg1 = "Instructions : ";
	private String msg2 = "Jeu - Touches directionnelles ou les touches Z, Q, S et D pour diriger";
	private String msg3 = "le joueur. Touche espace pour mettre le jeu en pause. ";
	private String msg4 = "Menu - Touches directionnelles ou les touches Z et S vous deplacer";
	private String msg5 = "dans les menus. Utiliser la touche enter pour valider votre choix";
	private String msg6 = "et la touche echap pour quitter le menu actuel.";

	/**
	 * Constructeur du menu aide.
	 * 
	 * @param handler
	 */
	public HelpMenuState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		getInput();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(224, 224, 224));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		g.setColor(Color.RED);

		// Dessin des options du menu.
		g.setFont(font2);
		g.drawString(msg1, 10, 80);

		g.setColor(Color.BLACK);
		g.setFont(font3);
		g.drawString(msg2, 10, 150);
		g.drawString(msg3, 10, 190);
		g.drawString(msg4, 10, 270);
		g.drawString(msg5, 10, 310);
		g.drawString(msg6, 10, 350);
	}

	@Override
	protected void getInput() {
		if (handler.getKeyManager().echap.keyStateDown) {
			handler.getStateManager().getStates().push(new MainMenuState(handler));
		}
	}

}
