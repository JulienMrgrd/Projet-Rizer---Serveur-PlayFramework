package service;

import java.util.ArrayList;

import models.Artist;
import models.Playlist;
import models.User;
import dao.ArtistDao;
import dao.PlaylistDao;
import dao.UserDao;


public class PlaylistService {

	public PlaylistService(){
		
	}
	
	/**
	 * creer une playlist et l'ajoute au compte
	 * @param idAccount
	 * @param name
	 * @param description
	 * @return la playlist
	 */
	public Playlist createPlayList(String idAccount, String name, String description) {
		User user = null;
		Playlist playlist = new Playlist(idAccount, new ArrayList<String>(), name, description);
		PlaylistDao.addPlaylist(playlist);
		user = UserDao.getUser(idAccount);
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
	public void hasAPlayList(String idAccount) {
		// TODO Auto-generated method stub
	}

	/**
	 * Permet de modifier sa playlist
	 * @param idAccount id de l'utilisateur
	 * @param playlist L'objet Playlist contenant les nouvelles informations
	 * @return true si Ok, false sinon
	 */
	public void modifyPlaylist(String idPlaylist, String name, String description) {
		PlaylistDao playlistDao = new PlaylistDao();
		Playlist playlistBase = playlistDao.getPlaylist(idPlaylist);
		if(name!=null){
			playlistBase.setName(name);
		}
		if(description!=null){
			playlistBase.setDescription(description);
		}
		playlistDao.updatePlaylist(p);
	}

	/**
	 * Supprime une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 */
	public void deletePlaylist(String idAccount, String idPlaylist) {
		PlaylistDao playlistDao = new PlaylistDao();
		playlistDao.deletePlaylist(idPlaylist);
	}

	/**
	 * Ajoute une music a une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music (préalablement uploadé sur serveur)

	 */
	public void addMusicToPlaylist(String idAccount, String idPlaylist,
			String idMusic) {
		PlaylistDao playlistDao = new PlaylistDao();
		Playlist playlist = playlistDao.getPlaylist(idPlaylist);
		playlist.getListMusics().add(idMusic);
		playlistDao.updatePlaylist(playlist);
	}

	/**
	 * Enleve une music d'une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music
	 * @return true si Ok, false sinon
	 */
//	public boolean removeMusicInPlaylist(String idAccount, String idPlaylist,
//			String idMusic) {
//		PlaylistDao playlistDao = new PlaylistDao();
//		Playlist playlist = playlistDao.getPlaylist(idPlaylist);
//		for(int i = 0; i<playlist.getListMusics().size() && ; i++){
//			
//		}
//	}
	
	/**
	 * Visualise une playlist
	 * @param idAccount id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public Playlist visualizePlaylist(String idAccount, String idPlaylist) {
		// TODO Auto-generated method stub
		return null;
	}

}
