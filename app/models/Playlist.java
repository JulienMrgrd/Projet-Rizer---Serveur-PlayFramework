package models;

import java.util.List;

public class Playlist {
	
	private List<String> listMusics;
	private String name;
	private String description;
	
	public Playlist(){}
	
	/**
	 * 
	 * @param listMusics liste d'ID de Music
	 * @param name
	 * @param description
	 */
	public Playlist(List<String> listMusics, String name, String description) {
		super();
		this.listMusics = listMusics;
		this.name = name;
		this.description = description;
	}
	
	public List<String> getListMusics() {
		return listMusics;
	}
	public void setListMusics(List<String> listMusics) {
		this.listMusics = listMusics;
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
