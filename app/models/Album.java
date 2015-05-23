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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result
				+ ((idartist == null) ? 0 : idartist.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tracks == null) ? 0 : tracks.hashCode());
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
		Album other = (Album) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (idartist == null) {
			if (other.idartist != null)
				return false;
		} else if (!idartist.equals(other.idartist))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tracks == null) {
			if (other.tracks != null)
				return false;
		} else if (!tracks.equals(other.tracks))
			return false;
		return true;
	}
    
}
