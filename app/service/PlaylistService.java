package service;

import models.Playlist;


public class PlaylistService {

	/**
	 * creer une playlist
	 * @param idAccount id de l'utilisateur
	 * @param name nom de la playlist
	 * @return idPlaylist si OK, null sinon
	 */
	public static Integer createPlayList(Integer idAccount, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Interroge la base pour savoir si un utilisateur a une playlist
	 * @param idAccount id de l'utilisateur
	 * @return idPlaylist si OK, null sinon
	 */
	public static void hasAPlayList(Integer idAccount) {
		// TODO Auto-generated method stub
	}

	/**
	 * Permet de modifier sa playlist
	 * @param idAccount id de l'utilisateur
	 * @param playlist L'objet Playlist contenant les nouvelles informations
	 * @return true si Ok, false sinon
	 */
	public static void modifyPlaylist(Integer idAccount, Playlist playlist) {
		// TODO Auto-generated method stub

	}

	/**
	 * Supprime une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @return true si Ok, false sinon
	 */
	public static boolean deletePlaylist(Integer idAccount, Integer idPlaylist) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ajoute une music a une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music (préalablement uploadé sur serveur)
	 * @return true si Ok, false sinon
	 */
	public static boolean addMusicToPlaylist(Integer idAccount, Integer idPlaylist,
			Integer idMusic) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Enleve une music d'une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music
	 * @return true si Ok, false sinon
	 */
	public static boolean removeMusicInPlaylist(Integer idAccount, Integer idPlaylist,
			Integer idMusic) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Visualise une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public static Playlist visualizePlaylist(Integer idAccount, Integer idPlaylist) {
		// TODO Auto-generated method stub
		return null;
	}

}
