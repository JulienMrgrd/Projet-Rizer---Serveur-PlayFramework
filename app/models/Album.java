package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album {

	@JsonProperty("_id")
	private String _id;
	private String title;
    private List<String> tracks;
    private String idartist;
    
	/**
	 * @param id 
	 * @param title
	 * @param tracks : Liste d'ID de music
	 * @param artist
	 */
	public Album(String id, String title, List<String> tracks, String idartist) {
		super();
		this._id = id;
		this.title = title;
		this.tracks = tracks;
		this.idartist = idartist;
	}
    
	public Album(){
		super();
	}

	public void setId(String id) {
		this._id = id;
	}
	public String getId() {
		return _id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getTracks() {
		return tracks;
	}
	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}
	public String getArtist() {
		return idartist;
	}
	public void setArtist(String artist) {
		this.idartist = artist;
	}


    
}
