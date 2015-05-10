package service;

import java.util.ArrayList;

import models.Artist;
import models.Playlist;
import models.User;
import dao.ArtistDao;
import dao.PlaylistDao;
import dao.UserDao;


public class PlaylistService {

	/**
	 * creer une playlist et l'ajoute au compte
	 * @param idAccount
	 * @param name
	 * @param description
	 * @return la playlist
	 */
	public static Playlist createPlayList(String idAccount, String name, String description) {
		User user = null;
		Playlist playlist = new Playlist(new ArrayList<String>(), name, description);
		PlaylistDao.addPlaylist(playlist);
		user = UserDao.getArtist(idAccount);
		if(user!=null){
			user.getPlaylists().add(playlist);
			UserDao.inscriptionUser(user);
		}else{
			Artist artist = ArtistDao.getArtist(idAccount);
			artist.getPlaylists().add(playlist);
			ArtistDao.inscriptionArtist(artist);
		}
		return playlist;
	}
	
	/**
	 * Interroge la base pour savoir si un utilisateur a une playlist
	 * @param idAccount id de l'utilisateur
	 * @return idPlaylist si OK, null sinon
	 */
	public static void hasAPlayList(int idAccount) {
		// TODO Auto-generated method stub
	}

	/**
	 * Permet de modifier sa playlist
	 * @param idAccount id de l'utilisateur
	 * @param playlist L'objet Playlist contenant les nouvelles informations
	 * @return true si Ok, false sinon
	 */
	public static void modifyPlaylist(String idAccount, Playlist playlist) {
		// TODO Auto-generated method stub
	}

	/**
	 * Supprime une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @return true si Ok, false sinon
	 */
	public static boolean deletePlaylist(int idAccount, int idPlaylist) {
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
	public static boolean addMusicToPlaylist(int idAccount, int idPlaylist,
			int idMusic) {
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
	public static boolean removeMusicInPlaylist(int idAccount, int idPlaylist,
			int idMusic) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Visualise une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public static Playlist visualizePlaylist(int idAccount, int idPlaylist) {
		// TODO Auto-generated method stub
		return null;
	}

}
