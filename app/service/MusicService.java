package service;

import models.Music;

public class MusicService{

	/**
	 * Ajoute une musique en base
	 * @param idProfil l'id du Profil (Artist ou FuturArtist) qui rajoute cette musique
	 * @param music le fichier a uploader
	 * @return vrai si l'operation s'est bien passee
	 */
	public static boolean addMusic(Integer idProfil, Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Remplace les informations d'une musique en base, si elle existe et qu'elle appartient a ce compte
	 * @param idProfil l'id du Profil (Artist ou FuturArtist) qui change les informations de la musique
	 * @param music la musique a remplacer
	 * @return vrai si l'operation s'est bien passee
	 */
	public static boolean modifyInfoMusic(Integer idProfil, Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Supprime la musique en base
	 * @param idProfil l'id du Profil qui supprime cette musique
	 * @param idMusic l'id de la musique a supprimer
	 * @return vrai si l'operation s'est bien passee
	 */
	public static boolean deleteMusic(Integer idProfil, Integer idMusic) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ajoute un like a la music
	 * @param idProfil l'id du profil qui like la musique
	 * @param idMusic l'id de la musique like
	 * @return vrai si l'operation s'est bien passee.
	 */
	public static boolean likerMusic(Integer idProfil, Integer idMusic) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ajoute un commentaire a une musique
	 * @param idProfil l'id du Profil qui commente
	 * @param idMusic l'id de la musique qui est commentee
	 * @param comment le commentaire
	 * @return
	 */
	public static boolean commentMusic(Integer idProfil, Integer idMusic,
			String comment) {
		// TODO Auto-generated method stub
		return false;
	}

}
