package models;

import java.util.Hashtable;
import java.util.List;







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
    private List<String> playlists;
    private List<String> rises;
    private List<String> follow;
    private Hashtable<String, Integer> historical;
    
    
	/**
	 * @param id 
	 * @param login : pour la connexion
	 * @param password
	 * @param pseudo : le pseudo visible par tout le monde
	 * @param email
	 * @param description : description du compte
	 * @param photo : id
	 * @param playlists : List de playlists (une playlist contient une liste d'ID de music)
	 * @param rises : Liste d'ID de compte
	 * @param follow : Liste d'ID d'artiste que le compte follow
	 * @param historical : Liste de music id déjà écoutée
	 */
	public Account(String id, String login, String password, String pseudo, String email, String description, String photo, 
				   List< String > playlists, List<String> rises, List<String> follow, Hashtable<String, Integer> historical) {
		super();
		this._id = id;
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
		this.email = email;
		this.description = description;
		this.photo = photo;
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

	public List<String> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<String> playlists) {
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

	public Hashtable<String,Integer> getHistorical() {
		return historical;
	}

	public void setHistorical(Hashtable<String, Integer> historical) {
		this.historical = historical;
	}
	
 
}
