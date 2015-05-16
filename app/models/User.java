package models;

import java.util.List;

public class User extends Account{

    private boolean futurArtist;
    private String musicRizeAlbum;
	private List<String> rizeGet;
    
	/**
 	 * @param id 
	 * @param login : pour la connexion
	 * @param password
	 * @param pseudo : le pseudo visible par tout le monde
	 * @param email
	 * @param description : description du compte
	 * @param photo : id
	 * @param playlists : List d'ID playlists (une playlist contient une liste d'ID de music)
	 * @param rises : Liste d'ID de compte
	 * @param follow : Liste d'ID d'artiste que le compte follow
	 * @param historical : Liste de music id déjà écoutée
	 * @param futurArtist : Pour vérifier si une demande a été effectuée
	 * @param rizeGet : Nombre de rize obtenus
	 */
	public User(String id, String login, String password, String pseudo, String email, String description, String photo, 
			List< String > playlists,	List<String> rises, List<String> follow, List<String> historical, boolean futurArtist,	List<String> rizeGet) {
		
		super(id, login, password, pseudo, email, description, photo, playlists, rises, follow, historical);
		this.futurArtist = futurArtist;
		this.rizeGet = rizeGet;
	}
	
	public User(String login, String password, String pseudo, String mail){
		super(null, login, password, pseudo, mail, null, null, null, null, null, null);
	}
	
	public String getMusicRizeAlbum() {
		return musicRizeAlbum;
	}

	public void setMusicRizeAlbum(String musicRizeAlbum) {
		this.musicRizeAlbum = musicRizeAlbum;
	}
	
	public boolean isfuturArtist() {
		return futurArtist;
	}
	public void setfuturArtist(boolean futurArtist) {
		this.futurArtist = futurArtist;
	}
	public List<String> getRizeGet() {
		return rizeGet;
	}
	public void setRizeGet(List<String> rizeGet) {
		this.rizeGet = rizeGet;
	}
}
