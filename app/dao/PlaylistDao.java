package dao;

import models.*;
import modelsmongo.PlayJongo;

public class PlaylistDao extends Dao {
	
	/**
	 * Ajoute la playlist p a la collection
	 * @param p : 
	 * @return vrai si ajout effectué, faux si le nom de la playlist p est deja presente en base
	 */

	public boolean addPlaylist(Playlist playlistTmp){
		if(PlayJongo.getCollection("Playlist").findOne("{name:#, accountId:#}", playlistTmp.getName(), playlistTmp.getAccountId() ).as(Playlist.class) == null){
			PlayJongo.getCollection("Playlist").save(playlistTmp);
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
	public void addMusicToPlaylist(String _idPlaylist, String _idMusic){
		PlayJongo.getCollection("Playlist").update("{_id:#}",_idPlaylist).with("{$push: {listMusics: #}}",_idMusic);
		
	}

	/**
	 * Mise a jour des information d'une playlist
	 * @param p
	 */
	public void updatePlaylist(Playlist p){
		PlayJongo.getCollection("Playlist").save(p);

	}

	/**
	 * Supprime une playlist
	 * @param _id
	 */
	public void deletePlaylist(String _id){
		PlayJongo.getCollection("Playlist").remove(_id);
	}
	
	/**
	 * Recherche de playlist par nom
	 * @param name
	 * @return
	 */
	public Playlist findPlaylistbyName(String name){
		return PlayJongo.getCollection("Playlist").findOne("{name:#}", name).as(Playlist.class);
	}

	public Playlist findPlaylistbyNameAndIdAccount(String name, String idAccount) {
		return PlayJongo.getCollection("Playlist").findOne("{name:#, accountId:#}", name, idAccount).as(Playlist.class);
	}

	public Playlist getPlaylist(String idPlaylist) {
		return PlayJongo.getCollection("Playlist").findOne("{_id:#}", idPlaylist).as(Playlist.class);
	}


}
