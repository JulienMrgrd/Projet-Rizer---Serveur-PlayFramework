package models;

import java.util.List;

public class Album {

	private Integer id;
	private String title;
    private List<Integer> tracks;
    private Artist artist;
    
	/**
	 * @param id 
	 * @param title
	 * @param tracks : List of tracks id
	 * @param artist
	 */
	public Album(Integer id, String title, List<Integer> tracks, Artist artist) {
		super();
		this.id = id;
		this.title = title;
		this.tracks = tracks;
		this.artist = artist;
	}
    

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getTracks() {
		return tracks;
	}
	public void setTracks(List<Integer> tracks) {
		this.tracks = tracks;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}


    
}
