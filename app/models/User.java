package models;

import java.util.List;

public class User extends Account{

    private boolean futurArtist;
    private List<Integer> rizeGet;
    
	/**
	 * @param id
	 * @param photo
	 * @param surname
	 * @param forename
	 * @param email
	 * @param pseudonym
	 * @param playlists : List of Music id
	 * @param rises : List of Profil id
	 * @param follow : List of Artist id
	 * @param historical : List of Music id already listen
	 * @param futurArtist : To check if he want to become artist
	 * @param rizeGet : Number of rize he gets during 
	 */
	public User(Integer id, String photo, String surname, String forename,
			String email, String pseudonym, List<Integer> playlists,
			List<Integer> rises, List<Integer> follow,
			List<Integer> historical, boolean futurArtist,
			List<Integer> rizeGet) {
		super(id, photo, surname, forename, email, pseudonym, playlists, rises,
				follow, historical);
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
