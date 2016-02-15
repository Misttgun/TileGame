package dev.codenmore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Classe qui gere l'affiche du jeu.
 * 
 * @author maurel
 *
 */
public class Display {

	private JFrame frame;
	private Canvas canvas;

	private String title;
	private int width;
	private int height;

	/**
	 * Constructeur de l'affichage du jeu
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	/**
	 * Methode qui genere la fenetre d'affichage du jeu
	 */
	private void createDisplay() {
		// Creation de la frame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Creation du canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		// Ajout du canvas a la frame
		frame.add(canvas);
		frame.pack();
	}
	
	// Getters Setters

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}

	

}
