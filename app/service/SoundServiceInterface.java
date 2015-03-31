package service;

import models.Music;

public interface SoundServiceInterface {

	/**
	 * Ajoute une musique en base
	 * @param idProfil l'id du Profil (Artist ou FuturArtist) qui rajoute cette musique
	 * @param music le fichier à uploader
	 * @return vrai si l'opération s'est bien passée
	 */
	public boolean addMusic(Integer idProfil, Music music);
	
	/**
	 * Remplace les informations d'une musique en base, si elle existe et qu'elle appartient à ce compte
	 * @param idProfil l'id du Profil (Artist ou FuturArtist) qui change les informations de la musique
	 * @param music la musique à remplacer
	 * @return vrai si l'opération s'est bien passée
	 */
	public boolean modifyInfoSound(Integer idProfil, Music music);
	
	/**
	 * Supprime la musique en base
	 * @param idProfil l'id du Profil qui supprime cette musique
	 * @param idMusic l'id de la musique à supprimer
	 * @return vrai si l'opération s'est bien passée
	 */
	public boolean deleteMusic(Integer idProfil, Integer idMusic);
	
	/**
	 * Ajoute un like à la music
	 * @param idProfil l'id du profil qui like la musique
	 * @param idMusic l'id de la musique liké
	 * @return vrai si l'opération s'est bien passée.
	 */
	public boolean likerMusic(Integer idProfil, Integer idMusic);
	
	/**
	 * Ajoute un commentaire à une musique
	 * @param idProfil l'id du Profil qui commente
	 * @param idMusic l'id de la musique qui est commentée
	 * @param comment le commentaire
	 * @return
	 */
	public boolean commentMusic(Integer idProfil, Integer idMusic, String comment);
	
}
