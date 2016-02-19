package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.StateManager;

/**
 * Classe qui gere le jeu
 * 
 * @author maurel
 *
 */
public class Game implements Runnable {

	private Display display;
	public static int WIDTH = 800;
	public static int HEIGHT = WIDTH * 9 / 16;
	public static String TITLE = "Rain";

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	private StateManager stateManager;

	// Input
	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	/**
	 * Constructeur du jeu
	 */
	public Game() {
		keyManager = new KeyManager();
	}

	/**
	 * Methode qui initialise le jeu
	 */
	private void init() {
		display = new Display(TITLE, WIDTH, HEIGHT);
		display.getCanvas().addKeyListener(keyManager);
		display.getCanvas().requestFocus();
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		stateManager = new StateManager(handler);
	}

	/**
	 * Methode qui mets a jour le jeu a chaque tour de boucle
	 */
	private void tick() {
		if (stateManager.getStates().peek() != null) {
			stateManager.tick();
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
		g.clearRect(0, 0, WIDTH, HEIGHT);

		// Debut dessin
		if (stateManager.getStates().peek() != null) {
			stateManager.render(g);
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

			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}

			try {
				Thread.sleep((long) ((lastTime - System.nanoTime() + timePerTick) / 1000000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			render();

			if (timer >= 1000000000) {
				// System.out.println("Ticks and Frames: " + ticks);
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
		return WIDTH;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * @return the gameCamera
	 */
	public GameCamera getGameCamera() {
		return gameCamera;
	}

}
