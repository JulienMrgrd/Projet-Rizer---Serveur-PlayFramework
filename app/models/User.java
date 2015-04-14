package models;

import java.util.List;

public class User extends Account{

    private boolean futurArtist;
    private List<Integer> rizeGet;
    
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
	 * @param futurArtist : Pour vérifier si une demande a été effectuée
	 * @param rizeGet : Nombre de rize obtenus
	 */
	public User(String id, String photo, String login, String password, String pseudo, String email, String description, 
			List< Playlist > playlists,	List<Integer> rises, List<Integer> follow, List<Integer> historical, boolean futurArtist,	List<Integer> rizeGet) {
		
		super(id, photo, login, password, pseudo, email, description, playlists, rises, follow, historical);
		this.futurArtist = futurArtist;
		this.rizeGet = rizeGet;
	}
	
	public boolean isfuturArtist() {
		return futurArtist;
	}
	public void setfuturArtist(boolean futurArtist) {
		this.futurArtist = futurArtist;
	}
	public List<Integer> getRizeGet() {
		return rizeGet;
	}
	public void setRizeGet(List<Integer> rizeGet) {
		this.rizeGet = rizeGet;
	}
}
