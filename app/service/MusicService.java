package service;

import models.Music;

public class MusicService{

	public MusicService(){
		
	}
	
	/**
	 * Ajoute une musique en base
	 * @param idAccount l'id du compte (Artist ou FuturArtist) qui rajoute cette musique
	 * @param music le fichier a uploader
	 * @return vrai si l'operation s'est bien passee
	 */
	public boolean addMusic(String idAccount, Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Remplace les informations d'une musique en base, si elle existe et qu'elle appartient a ce compte
	 * @param idAccount l'id du compte (Artist ou FuturArtist) qui change les informations de la musique
	 * @param music la musique a remplacer
	 * @return vrai si l'operation s'est bien passee
	 */
	public boolean modifyInfoMusic(String idAccount, Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Supprime la musique en base
	 * @param idAccount l'id du compte qui supprime cette musique
	 * @param idMusic l'id de la musique a supprimer
	 * @return vrai si l'operation s'est bien passee
	 */
	public boolean deleteMusic(String idAccount, String idMusic) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ajoute un like a la music
	 * @param idAccount l'id du compte qui like la musique
	 * @param idMusic l'id de la musique like
	 * @return vrai si l'operation s'est bien passee.
	 */
	public boolean likerMusic(String idAccount, String idMusic) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ajoute un commentaire a une musique
	 * @param idAccount l'id du compte qui commente
	 * @param idMusic l'id de la musique qui est commentee
	 * @param comment le commentaire
	 * @return
	 */
	public boolean commentMusic(String idAccount, String idMusic,
			String comment) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Permet à l'utilisateur d'écouter une musique
	 * @param idAccount l'id du compte qui commente
	 * @param idMusic l'id de la musique qui est commentee
	 * @return
	 */
	public boolean listenMusic(String idAccount, String idMusic) {
		// TODO Auto-generated method stub
		return false;
	}

}
