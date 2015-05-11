package dao;

import models.*;
import modelsMongo.PlayJongo;

public class AlbumDao {
	
	/**
	 * Ajoute un ablbum dans la collection "Album"
	 * @param albumTmp
	 */
	public static void addAlbum(Album albumTmp){
		PlayJongo.getCollection("Album").save(albumTmp);
	}
	
	/**
	 * Supprime l'album d'identifiant _id
	 * @param _id
	 */
	public static void deleteAlbum(String _id){
		Album albumTmp=PlayJongo.getCollection("Album").findOne("{_id:#}", _id).as(Album.class);
		for(String id : albumTmp.getTracks()){
			MusicDao.deleteMusic(id);
		}
		
		
		
		
	}

}
