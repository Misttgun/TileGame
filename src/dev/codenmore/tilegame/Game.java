package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.states.StateManager;

/**
 * Classe qui gere le jeu
 * 
 * @author maurel
 *
 */
public class Game implements Runnable {

	private Display display;
	private int width;
	private int height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	private State gameState;
	@SuppressWarnings("unused")
	private State menuState;

	// Input
	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	/**
	 * Constructeur du jeu
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	/**
	 * Methode qui initialise le jeu
	 */
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		StateManager.setState(gameState);
	}

	/**
	 * Methode qui mets a jour le jeu a chaque tour de boucle
	 */
	private void tick() {
		keyManager.tick();

		if (StateManager.getState() != null) {
			StateManager.getState().tick();
		}
	}

	/**
	 * Methode qui gere l'affichage du jeu
	 */
	private void render() {
		// Creation des Buffer (3)
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		// Creation du dessin
		g = bs.getDrawGraphics();

		// Nettoyage de l'affichage
		g.clearRect(0, 0, width, height);

		// Debut dessin
		if (StateManager.getState() != null) {
			StateManager.getState().render(g);
		}

		// Fin dessin
		bs.show();
		g.dispose();
	}

	/* @see java.lang.Runnable#run() */
	public void run() {
		init();

		// Nombre de fois que nous voulons appeler tick() par secondes
		int fps = 60;

		// Temps max en nanosecondes pour executer tick() et render()
		double timePerTick = 1000000000 / fps;

		// Temps necessaire avant de rapeller tick() et render()
		double delta = 0;

		// Horloge de l'ordi en nanosecondes a chaque tour de boucle
		long now;

		// Horloge de l'ordi en nanosecondes au dernier tour de boucle
		long lastTime = System.nanoTime();

		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	/**
	 * Methode qui demarre le thread
	 */
	public synchronized void start() {
		if (running) return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Methode qui arrete le thread
	 */
	public synchronized void stop() {
		if (!running) return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Getters Setters

	/**
	 * @return the keyManager
	 */
	public KeyManager getKeyManager() {
		return keyManager;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the gameCamera
	 */
	public GameCamera getGameCamera() {
		return gameCamera;
	}

}
