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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((follow == null) ? 0 : follow.hashCode());
		result = prime * result
				+ ((historical == null) ? 0 : historical.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result
				+ ((playlists == null) ? 0 : playlists.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		result = prime * result + ((rises == null) ? 0 : rises.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (follow == null) {
			if (other.follow != null)
				return false;
		} else if (!follow.equals(other.follow))
			return false;
		if (historical == null) {
			if (other.historical != null)
				return false;
		} else if (!historical.equals(other.historical))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (playlists == null) {
			if (other.playlists != null)
				return false;
		} else if (!playlists.equals(other.playlists))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		if (rises == null) {
			if (other.rises != null)
				return false;
		} else if (!rises.equals(other.rises))
			return false;
		return true;
	}
	
 
}
