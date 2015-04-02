package service;

import java.util.List;

import models.Artist;
import models.Account;

public class ProfilService {

	
	/**
	 * Permet de se connecter
	 * @param email de l'utilsateur
	 * @param password de l'utilisateur
	 * @return un Profil correspondant
	 */
	public Account connection(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Permet de se deconnecter
	 */
	public static void disconnection() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Inscrit un User
	 * @param surname c'est le nom 
	 * @param forename c'est le prenom 
	 * @param email de l'utilisateur
	 * @param pseudonym pseudo de l'utilisateur
	 * @return Id du user creer ou null sinon
	 */
	public static Integer subscribeUser(String surname, String forename, String email,
			String pseudonym) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Inscrit un Artist
	 * @param surname nom de l'artiste
	 * @param forename prenom de l'artiste
	 * @param email email de l'artiste
	 * @param pseudonym pseudo de l'artiste
	 * @param playlists playlists de l'artiste
	 * @param rises la liste des personne qu'on a rises
	 * @param follow la liste des personne qu'on follow
	 * @param historical la liste des sons deja ecoute
	 * @return un Artist creer
	 */
	public static Artist subscribeArtist(String surname, String forename,
			String email, String pseudonym, List<Integer> playlists,
			List<Integer> rises, List<Integer> follow, List<Integer> historical) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Permet de se desinscrire
	 * @param idProfil id du profil a supprimer
	 */
	public static void unsubscribe(Integer idProfil) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param user id du profil a promouvoir
	 */
	public static void becomeArtist(Integer idProfil) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permet de modifier son profil
	 * @param profil Le profil qu'on recupere pour le changer en base
	 */
	public static void modifyProfil(Integer idProfil, Account profil) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permet de voir son profil
	 * @param idProfil id du profil qu'on veut voir
	 */
	public static void seeProfil(Integer idProfil) {
		// TODO Auto-generated method stub
		
	}


}
