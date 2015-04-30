package service;

import models.Account;
import models.Artist;

public class AccountService {

	
	/**
	 * Inscrit un User
	 * @param login login de connexion
	 * @param pass le mot de passe
	 * @param email de l'utilisateur
	 * @param pseudonym pseudo de l'utilisateur
	 * @return Id du user cree ou null sinon
	 */
	public static int subscribeAccount(String login, String password, String email, String pseudo) {
		// TODO Auto-generated method stub
		return -1;
	}

	/**
	 * Permet de modifier son compte
	 * @param account L'objet Account contenant les nouvelles informations
	 * @return true si Ok, false sinon
	 */
	public static boolean modifyAccount(int idAccount, Account account) {
		// TODO les champs null de "account" ne provoqueront aucun changement en base, les autres oui.
		return false;
	}
	
	/**
	 * Permet de voir un Account (tous les attributs ne seront pas renseignés)
	 * @param idAccount id du Account à voir
	 */
	public static Account visualizeAccount(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Permet de voir son Account
	 * @param idAccount id du Account à voir
	 */
	public static Account visualizeMyAccount(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Permet de se desinscrire
	 * @param idAccount id du Account a supprimer
	 * @return true si Ok, false sinon
	 */
	public static void deleteAccount(int idAccount) {
		// TODO Auto-generated method stub
	}

	/**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param user id du Account a promouvoir
	 * @return true si Ok, false sinon
	 */
	public static boolean becomeArtist(int idAccount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Transforme un User en Artist (le client n'appelle pas cette méthode, c'est un daemon
	 * qui le fait)
	 */
	private static Artist transformToArtist(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
