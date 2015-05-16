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
		PlaylistDao playlistDao = new PlaylistDao();
		UserDao userDao = new UserDao();
		Playlist playlist = new Playlist(idAccount, new ArrayList<String>(), name, description);
		playlistDao.addPlaylist(playlist);
		playlist = playlistDao.findPlaylistbyNameAndIdAccount(name,idAccount);
		user = userDao.getUser(idAccount);
		if(user!=null){
			user.getPlaylists().add(playlist.get_id());
			userDao.updateUser(user);
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			artist.getPlaylists().add(playlist.get_id());
			artistDao.updateArtist(artist);
		}
		return playlist;
	}

	/**
	 * Interroge la base pour savoir si un utilisateur a une playlist
	 * @param idAccount id de l'utilisateur
	 * @return vrai si il a et false sinon
	 */
	public boolean hasAPlayList(String idAccount) {
		return false;
		// TODO Auto-generated method stub
	}

	/**
	 * Permet de modifier sa playlist
	 * @param idPlaylist
	 * @param name
	 * @param description
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
		playlistDao.updatePlaylist(playlistBase);
	}

	/**
	 * Supprime une playlist
	 * @param idPlaylist id de la playlist
	 */
	public void deletePlaylist(String idPlaylist) {
		PlaylistDao playlistDao = new PlaylistDao();
		playlistDao.deletePlaylist(idPlaylist);
	}

	/**
	 * Ajoute une music a une playlist
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music (préalablement uploadé sur serveur)
	 */
	public void addMusicToPlaylist( String idPlaylist,
			String idMusic) {
		PlaylistDao playlistDao = new PlaylistDao();
		Playlist playlist = playlistDao.getPlaylist(idPlaylist);
		playlist.getListMusics().add(idMusic);
		playlistDao.updatePlaylist(playlist);
	}

	/**
	 * Enleve une music d'une playlist
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music
	 * @return true si Ok, false sinon
	 */
	public boolean removeMusicInPlaylist( String idPlaylist,
			String idMusic) {
		boolean remove = false;
		PlaylistDao playlistDao = new PlaylistDao();
		Playlist playlist = playlistDao.getPlaylist(idPlaylist);
		if(playlist.getListMusics().size()>0){
			for(int i = 0; i<playlist.getListMusics().size() && remove!=true; i++){
				if(playlist.getListMusics().get(i).equals(idMusic)){
					playlist.getListMusics().remove(i);
					playlistDao.updatePlaylist(playlist);
					remove = true;
				}
			}
		}
		return remove;
	}

	/**
	 * Visualise une playlist
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public Playlist visualizePlaylist( String idPlaylist) {
		PlaylistDao playlistDao = new PlaylistDao();
		Playlist playlist = playlistDao.getPlaylist(idPlaylist);
		return playlist;
	}

}
