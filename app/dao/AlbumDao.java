package dao;

import java.util.*;

import models.*;
import modelsmongo.MongoCursor;
import modelsmongo.PlayJongo;


public class AlbumDao {
	
	/**
	 * Ajoute un ablbum dans la collection "Album"
	 * @param albumTmp
	 */
	public boolean addAlbum(Album albumTmp){
		if(PlayJongo.getCollection("Album").findOne("{title:#, idartist:#}", albumTmp.getTitle(), albumTmp.getArtist()).as(Playlist.class) == null){
			PlayJongo.getCollection("Album").save(albumTmp);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Supprime l'album d'identifiant _id
	 * @param _id
	 */
	public void deleteAlbum(String _id){
		Album albumTmp=PlayJongo.getCollection("Album").findOne("{_id:#}", _id).as(Album.class);
		for(String id : albumTmp.getTracks()){
			(new MusicDao()).deleteMusic(id);
		}
		
		
		
		
	}

	public Album getAlbum(String _idAlbum) {
		return PlayJongo.getCollection("Album").findOne("{_id:#}", _idAlbum).as(Album.class);
	}
	
	public List<Music> getAlbumsContainsName(String name){
		Iterator m= PlayJongo.getCollection("Album").find("{name:{$regex:\""+name+"\", $options: 'i' }}").as(Album.class).iterator();
		return PlayJongo.toArray(m);
	}
	
	public List<Album> getAlbumsByName(String name){
		Iterator<Album> m= PlayJongo.getCollection("Album").find("{name:#}", name).as(Album.class).iterator();
		return PlayJongo.toArray(m);
		
	}

	public void updateAlbum(Album albumTmp) {
		PlayJongo.getCollection("Album").save(albumTmp);
		
	}

}
