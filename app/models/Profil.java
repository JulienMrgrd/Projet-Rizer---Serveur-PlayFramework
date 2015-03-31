package models;

import java.util.List;

public abstract class Profil {

	private Integer id;
    private String photo;
    private String surname;
    private String forename;
    private String email;
    private String pseudonym;
    private List<Integer> playlists;
    private List<Integer> rises;
    private List<Integer> follow;
    private List<Integer> historical;
    
    
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
	 */
	public Profil(Integer id, String photo, String surname, String forename,
			String email, String pseudonym, List<Integer> playlists,
			List<Integer> rises, List<Integer> follow, List<Integer> historical) {
		super();
		this.id = id;
		this.photo = photo;
		this.surname = surname;
		this.forename = forename;
		this.email = email;
		this.pseudonym = pseudonym;
		this.playlists = playlists;
		this.rises = rises;
		this.follow = follow;
		this.historical = historical;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPseudonym() {
		return pseudonym;
	}
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	public List<Integer> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Integer> playlists) {
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
