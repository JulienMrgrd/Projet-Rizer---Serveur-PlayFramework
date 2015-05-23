package models;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Music {
    
	@JsonProperty("_id")
	private String _id;
    private String name;
    private String fileId;
    private List<String> like;
    private Map<String,String> comment;//pseudo+commentaire
    private List<Tag> tags;
    private Time duration;
    private Album album;
    
    
    
	/**
	 * @param id
	 * @param name
	 * @param file : URL
	 * @param like : List d'ID profil
	 * @param comment : HashTag <Login,comment>
	 * @param tags
	 * @param duration : Duree de la musique
	 * @param album 
	 */
	public Music(String id, String name, String file, List<String> like,
			HashMap<String, String> comment, List<Tag> tags, Time duration,
			Album album) {
		super();
		this._id = id;
		this.name = name;
		this.fileId = file;
		this.like = like;
		this.comment = comment;
		this.tags = tags;
		this.duration = duration;
		this.album = album;
	}
	
	public Music(){
		super();
	}
	
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String file) {
		this.fileId = file;
	}
	public List<String> getLike() {
		return like;
	}
	public void setLike(List<String> like) {
		this.like = like;
	}
	public Map<String, String> getComment() {
		return comment;
	}
	public void setComment(Map<String, String> comment) {
		this.comment = comment;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public Album getAlbum() {
		return album;
	}
	@Override
	public String toString() {
		return "Music [_id=" + _id + ", name=" + name + ", fileId=" + fileId
				+ ", like=" + like + ", comment=" + comment + ", tags=" + tags
				+ ", duration=" + duration + ", album=" + album + "]";
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result + ((like == null) ? 0 : like.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		Music other = (Music) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (like == null) {
			if (other.like != null)
				return false;
		} else if (!like.equals(other.like))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
    

}
