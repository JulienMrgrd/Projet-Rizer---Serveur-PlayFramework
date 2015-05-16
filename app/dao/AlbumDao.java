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
	
	public List<Album> getAlbumsByName(String name){
		MongoCursor<Album> m= (MongoCursor<Album>) PlayJongo.getCollection("Album").find("{name:#}", name).as(Album.class);
		return m.toArray();
		
	}

	public void updateAlbum(Album albumTmp) {
		PlayJongo.getCollection("Album").save(albumTmp);
		
	}

}
