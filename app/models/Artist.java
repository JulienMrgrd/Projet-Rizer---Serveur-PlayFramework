package models;

import java.util.List;

public class Artist extends Account{

    private List<String> library; //id album
    private List<String> followers; //id compte
    private List<String> news;
    private String biography;
    
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
	 * @param library : List d'ID d'albums
	 * @param followers : List d'ID de compte
	 * @param news : List de news d'artiste
	 * @param biography
	 */
	public Artist(String id, String photo, String login, String password, String pseudo, String email, String description, 
			List< Playlist > playlists,	List<String> rises, List<String> follow, List<String> historical, List<String> library,
			List<String> followers, List<String> news, String biography) {
		
		super(id, photo, login, password, pseudo, email, description, playlists, rises, follow, historical);
		this.library = library;
		this.followers = followers;
		this.news = news;
		this.biography = biography;
	}
	
	public Artist(){
		super();
	}
	
	public List<String> getLibrary() {
		return library;
	}
	public void setLibrary(List<String> library) {
		this.library = library;
	}
	public List<String> getFollowers() {
		return followers;
	}
	public void setFollowers(List<String> followers) {
		this.followers = followers;
	}
	public List<String> getNews() {
		return news;
	}
	public void setNews(List<String> news) {
		this.news = news;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
    

    
}
