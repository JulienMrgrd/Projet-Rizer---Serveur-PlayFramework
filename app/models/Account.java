package models;

import java.util.List;

import org.jongo.marshall.jackson.oid.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Account {

	@JsonProperty("_id")
	public String _id;
    private String photo;
    private String surname;
    private String forename;
    private String email;
    private String password;
    private String description;
    private List< Playlist > playlists;
    private List<Integer> rises;
    private List<Integer> follow;
    private List<Integer> historical;
    
    
	/**
	 * @param id 
	 * @param photo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param login
	 * @param description : description du compte
	 * @param playlists : List de playlists (une playlist contient une liste d'ID de music)
	 * @param rises : Liste d'ID de compte
	 * @param follow : Liste d'ID d'artiste que le compte follow
	 * @param historical : Liste de music id déjà écoutée
	 */
	public Account(String id, String photo, String surname, String forename,
			String email, String password, String description, List< Playlist > playlists,
			List<Integer> rises, List<Integer> follow, List<Integer> historical) {
		super();
		this._id = id;
		this.photo = photo;
		this.surname = surname;
		this.forename = forename;
		this.email = email;
		this.password = password;
		this.description = description;
		this.playlists = playlists;
		this.rises = rises;
		this.follow = follow;
		this.historical = historical;
	}
	
	public Account(){ }
	
	public String getId() {
		return _id;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List< Playlist > getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List< Playlist > playlists) {
		this.playlists = playlists;
	}
	public List<Integer> getRises() {
		return rises;
	}
	public void setRises(List<Integer> rises) {
		this.rises = rises;
	}
	public List<Integer> getFollow() {
		return follow;
	}
	public void setFollow(List<Integer> follow) {
		this.follow = follow;
	}
	public List<Integer> getHistorical() {
		return historical;
	}
	public void setHistorical(List<Integer> historical) {
		this.historical = historical;
	}
    
 
}
