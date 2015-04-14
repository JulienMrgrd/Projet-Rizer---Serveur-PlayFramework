package models;

import java.util.List;

public class Playlist {
	
	private List<Integer> listSounds;
	private String name;
	private String description;
	
	public Playlist(){}
	
	/**
	 * 
	 * @param listSounds liste d'ID de Sound
	 * @param name
	 * @param description
	 */
	public Playlist(List<Integer> listSounds, String name, String description) {
		super();
		this.listSounds = listSounds;
		this.name = name;
		this.description = description;
	}
	
	public List<Integer> getListSounds() {
		return listSounds;
	}
	public void setListSounds(List<Integer> listSounds) {
		this.listSounds = listSounds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
