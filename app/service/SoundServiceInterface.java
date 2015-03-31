package service;

import models.Music;

public interface SoundServiceInterface {

	/**
	 * Ajoute une musique en base
	 * @param idProfil l'id du Profil (Artist ou FuturArtist) qui rajoute cette musique
	 * @param music le fichier � uploader
	 * @return vrai si l'op�ration s'est bien pass�e
	 */
	public boolean addMusic(Integer idProfil, Music music);
	
	/**
	 * Remplace les informations d'une musique en base, si elle existe et qu'elle appartient � ce compte
	 * @param idProfil l'id du Profil (Artist ou FuturArtist) qui change les informations de la musique
	 * @param music la musique � remplacer
	 * @return vrai si l'op�ration s'est bien pass�e
	 */
	public boolean modifyInfoSound(Integer idProfil, Music music);
	
	/**
	 * Supprime la musique en base
	 * @param idProfil l'id du Profil qui supprime cette musique
	 * @param idMusic l'id de la musique � supprimer
	 * @return vrai si l'op�ration s'est bien pass�e
	 */
	public boolean deleteMusic(Integer idProfil, Integer idMusic);
	
	/**
	 * Ajoute un like � la music
	 * @param idProfil l'id du profil qui like la musique
	 * @param idMusic l'id de la musique lik�
	 * @return vrai si l'op�ration s'est bien pass�e.
	 */
	public boolean likerMusic(Integer idProfil, Integer idMusic);
	
	/**
	 * Ajoute un commentaire � une musique
	 * @param idProfil l'id du Profil qui commente
	 * @param idMusic l'id de la musique qui est comment�e
	 * @param comment le commentaire
	 * @return
	 */
	public boolean commentMusic(Integer idProfil, Integer idMusic, String comment);
	
}
