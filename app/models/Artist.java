package models;

import java.util.List;

public class Artist extends Profil{

    private List<Integer> library;//id album
    private List<Integer> followers;//id profil
    private List<String> news;
    private String biography;
    
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
	 * @param library : List of his Album id
	 * @param followers : List of Profil id
	 * @param news : List of artist news
	 * @param biography
	 */
	public Artist(Integer id, String photo, String surname, String forename,
			String email, String pseudonym, List<Integer> playlists,
			List<Integer> rises, List<Integer> follow,
			List<Integer> historical, List<Integer> library,
			List<Integer> followers, List<String> news, String biography) {
		super(id, photo, surname, forename, email, pseudonym, playlists, rises,
				follow, historical);
		this.library = library;
		this.followers = followers;
		this.news = news;
		this.biography = biography;
	}
	
	public List<Integer> getLibrary() {
		return library;
	}
	public void setLibrary(List<Integer> library) {
		this.library = library;
	}
	public List<Integer> getFollowers() {
		return followers;
	}
	public void setFollowers(List<Integer> followers) {
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
