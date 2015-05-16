package dao;

import models.*;
import modelsmongo.PlayJongo;

public class AlbumDao {
	
	/**
	 * Ajoute un ablbum dans la collection "Album"
	 * @param albumTmp
	 */
	public void addAlbum(Album albumTmp){
		PlayJongo.getCollection("Album").save(albumTmp);
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

	public Album getAlbum(String idAlbum) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAlbum(Album album) {
		// TODO Auto-generated method stub
		
	}

}
