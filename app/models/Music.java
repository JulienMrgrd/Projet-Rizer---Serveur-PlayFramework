package models;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

public class Music {
    
	private Integer id;
    private String name;
    private String file;
    private List<Integer> like;
    private HashMap<String,String> comment;//pseudo+commentaire
    private List<Tag> tags;
    private Time duration;
    private Album album;
    
    
    
	/**
	 * @param id
	 * @param name
	 * @param file
	 * @param like : List of Profil id
	 * @param comment : HashTag <pseudonym,comment>
	 * @param tags
	 * @param duration : Time to become artist
	 * @param album 
	 */
	public Music(Integer id, String name, String file, List<Integer> like,
			HashMap<String, String> comment, List<Tag> tags, Time duration,
			Album album) {
		super();
		this.id = id;
		this.name = name;
		this.file = file;
		this.like = like;
		this.comment = comment;
		this.tags = tags;
		this.duration = duration;
		this.album = album;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
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
