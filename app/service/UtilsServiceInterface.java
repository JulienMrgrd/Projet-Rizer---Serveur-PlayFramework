package service;

import java.util.List;

import models.Album;
import models.Artist;
import models.Music;

public interface UtilsServiceInterface {

	/**
	 * Recherche un artiste dans la base et dans la base de Gracenote
	 * @param research La chaine de caract�re
	 * @return la liste des r�sultats
	 */
	public List<Artist> searchArtist(String research);
	
	/**
	 * Recherche un album dans la base et dans la base de Gracenote
	 * @param research La chaine de caract�re
	 * @return la liste des r�sultats
	 */
	public List<Album> searchAlbum(String research);
	
	/**
	 * Recherche un musique dans la base et dans la base de Gracenote
	 * @param research La chaine de caract�re
	 * @return la liste des r�sultats
	 */
	public List<Music> searchMusic(String research);
	
	/**
	 * Retourne la liste des artistes recommand�s pour ce profil
	 * @param idProfil l'id du profil
	 * @return la liste des r�sultats
	 */
	public List<Artist> recommendArtist(Integer idProfil);
	
	/**
	 * Retourne la liste des albums recommand�s pour ce profil
	 * @param idProfil l'id du profil
	 * @return la liste des r�sultats
	 */
	public List<Album> recommendAlbum(Integer idProfil);
	
	/**
	 * Retourne la liste des musiques recommand�es pour ce profil
	 * @param idProfil l'id du profil
	 * @return la liste des r�sultats
	 */
	public List<Music> recommendMusic(Integer idProfil);
	
}
