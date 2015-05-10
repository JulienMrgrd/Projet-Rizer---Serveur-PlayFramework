package models;

import java.util.List;

import org.jongo.marshall.jackson.oid.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Account {

	@JsonProperty("_id")
	public String _id;
    private String photo;
    private String login;
    private String password;
    private String pseudo;
    private String email;
    private String description;
    private List< Playlist > playlists;
    private List<String> rises;
    private List<String> follow;
    private List<String> historical;
    
    
	/**
	 * @param id 
	 * @param photo : url
	 * @param login : pour la connexion
	 * @param password
	 * @param pseudo : le pseudo visible par tout le monde
	 * @param email
	 * @param description : description du compte
	 * @param playlists : List de playlists (une playlist contient une liste d'ID de music)
	 * @param rises : Liste d'ID de compte
	 * @param follow : Liste d'ID d'artiste que le compte follow
	 * @param historical : Liste de music id déjà écoutée
	 */
	public Account(String id, String photo, String login, String password, String pseudo, String email, String description, 
			List< Playlist > playlists,	List<String> rises, List<String> follow, List<String> historical) {
		super();
		this._id = id;
		this.photo = photo;
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
		this.email = email;
		this.description = description;
		this.playlists = playlists;
		this.rises = rises;
		this.follow = follow;
		this.historical = historical;
	}
	
	public Account(){ }

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	public List<String> getRises() {
		return rises;
	}

	public void setRises(List<String> rises) {
		this.rises = rises;
	}

	public List<String> getFollow() {
		return follow;
	}

	public void setFollow(List<String> follow) {
		this.follow = follow;
	}

	public List<String> getHistorical() {
		return historical;
	}

	public void setHistorical(List<String> historical) {
		this.historical = historical;
	}
	
 
}
