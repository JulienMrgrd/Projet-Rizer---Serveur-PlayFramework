package service;

import java.util.List;

public interface PlaylistServiceInterface {

	/**
	 * creer une playlist
	 * @param idProfil id de l'utilisateur
	 * @param name nom de la playlist
	 * @param tracks la liste des music
	 */
	public void createPlayList(Integer idProfil, String name, List<Integer> tracks);
	
	/**
	 * Modifie les infos d'une playlist
	 * @param idProfil id de l'utilisateur
	 * @param information les infos qu'on veut ajouter
	 */
	public void modifyPlaylist(Integer idProfil, String information);
	
	/**
	 * supprime une playlist
	 * @param idProfil id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 */
	public void deletePlaylist(Integer idProfil, Integer idPlaylist);
	
	/**
	 * ajoute une music a une playlist
	 * @param idProfil id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music
	 */
	public void addMusicPlaylist(Integer idProfil, Integer idPlaylist, Integer idMusic);
	
	/**
	 * enleve une music a une playlist
	 * @param idProfil id de l'utilisateur
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music
	 * 	 */
	public void removeMusicPlaylist(Integer idProfil, Integer idPlaylist, Integer idMusic);
}
