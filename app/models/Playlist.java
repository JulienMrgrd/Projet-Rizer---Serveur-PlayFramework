package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Playlist {
	
	@JsonProperty("_id")
	public String _id;
	private String accountId; 
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
	public Playlist(String account, List<String> listMusics, String name, String description) {
		super();
		this.accountId=account;
		this.listMusics = listMusics;
		this.name = name;
		this.description = description;
	}
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String get_id() {
		return _id;
	}

	
	
}
