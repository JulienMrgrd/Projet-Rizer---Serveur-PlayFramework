package models;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Music {
    
	@JsonProperty("_id")
	private String _id;
    private String name;
    private String fileId;
    private List<Integer> like;
    private HashMap<String,String> comment;//pseudo+commentaire
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
	public Music(String id, String name, String file, List<Integer> like,
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
	public List<Integer> getLike() {
		return like;
	}
	public void setLike(List<Integer> like) {
		this.like = like;
	}
	public HashMap<String, String> getComment() {
		return comment;
	}
	public void setComment(HashMap<String, String> comment) {
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
	public void setAlbum(Album album) {
		this.album = album;
	}
    

    

}
