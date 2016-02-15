package dev.codenmore.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;

/**
 * Classe qui gere nos entites dans le jeu.
 * 
 * @author maurel
 *
 */
public class EntityManager {

	private Handler handler;
	private Player player;
	private List<Entity> entities;
	
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};

	/**
	 * Constructeur de l'entity manager.
	 * 
	 * @param handler
	 * @param player
	 */
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<>();
		addEntity(player);
	}

	/**
	 * Methode qui mets a jour l'entity manager.
	 */
	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
		
		entities.sort(renderSorter);
	}

	/**
	 * Methode qui gere le rendu de l'entity manager.
	 * 
	 * @param g
	 *            (graphique)
	 */
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}

	/**
	 * Methode qui ajoute une entite au jeu.
	 * 
	 * @param e
	 *            (entite)
	 */
	public void addEntity(Entity e) {
		entities.add(e);
	}

	// Getters Setters

	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * @param handler
	 *            the handler to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
