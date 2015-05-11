package dao;

import models.*;
import modelsMongo.PlayJongo;

public class PlaylistDao {
	
	/**
	 * Ajoute la playlist p a la collection
	 * @param p : 
	 * @return vrai si ajout effectué, faux si le nom de la playlist p est deja presente en base
	 */

	public static boolean addPlaylist(Playlist p){
		if(PlayJongo.getCollection("Playlist").findOne("{name:#}", p.getName()).as(Playlist.class) == null){
			PlayJongo.getCollection("Playlist").save(p);
			return true;
		}else{
			return false;
		}
			

	}
	
	/**
	 * Ajoute une music a une playlist
	 * @param _idPlaylist 
	 * @param _idMusic
	 */
	public static void addMusicToPlaylist(String _idPlaylist, String _idMusic){
		PlayJongo.getCollection("Playlist").update("{_id:#}",_idPlaylist).with("{$push: {listMusics: #}}",_idMusic);
		
	}

	/**
	 * Mise a jour des information d'une playlist
	 * @param p
	 */
	public static void updatePlaylist(Playlist p){
		PlayJongo.getCollection("Playlist").save(p);

	}

	/**
	 * Supprime une playlist
	 * @param _id
	 */
	public static void deletePlaylist(String _id){
		PlayJongo.getCollection("Playlist").remove(_id);
	}
	
	/**
	 * Recherche de playlist par nom
	 * @param name
	 * @return
	 */
	public static Playlist findPlaylistbyName(String name){
		return PlayJongo.getCollection("Playlist").findOne("{name:#}", name).as(Playlist.class);
	}


}
