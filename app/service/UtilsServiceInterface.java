package service;

import java.util.List;

import models.Album;
import models.Artist;
import models.Music;

public interface UtilsServiceInterface {

	/**
	 * Recherche un artiste dans la base et dans la base de Gracenote
	 * @param research La chaine de caractère
	 * @return la liste des résultats
	 */
	public List<Artist> searchArtist(String research);
	
	/**
	 * Recherche un album dans la base et dans la base de Gracenote
	 * @param research La chaine de caractère
	 * @return la liste des résultats
	 */
	public List<Album> searchAlbum(String research);
	
	/**
	 * Recherche un musique dans la base et dans la base de Gracenote
	 * @param research La chaine de caractère
	 * @return la liste des résultats
	 */
	public List<Music> searchMusic(String research);
	
	/**
	 * Retourne la liste des artistes recommandés pour ce profil
	 * @param idProfil l'id du profil
	 * @return la liste des résultats
	 */
	public List<Artist> recommendArtist(Integer idProfil);
	
	/**
	 * Retourne la liste des albums recommandés pour ce profil
	 * @param idProfil l'id du profil
	 * @return la liste des résultats
	 */
	public List<Album> recommendAlbum(Integer idProfil);
	
	/**
	 * Retourne la liste des musiques recommandées pour ce profil
	 * @param idProfil l'id du profil
	 * @return la liste des résultats
	 */
	public List<Music> recommendMusic(Integer idProfil);
	
}
