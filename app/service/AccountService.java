package service;

import java.util.List;

import models.Artist;
import models.Account;

public class AccountService {

	
	/**
	 * Permet de se connecter
	 * @param email de l'utilsateur
	 * @param password de l'utilisateur
	 * @return un Account correspondant
	 */
	public Account connection(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Permet de se deconnecter
	 */
	public static void logOut() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Inscrit un User
	 * @param login login de connexion
	 * @param email de l'utilisateur
	 * @param pseudonym pseudo de l'utilisateur
	 * @return Id du user cree ou null sinon
	 */
	public static Integer subscribeUser(String login, String password, String email, String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Transforme un User en Artist
	 */
	public static Artist subscribeArtist(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Permet de se desinscrire
	 * @param idAccount id du Account a supprimer
	 */
	public static void unsubscribe(Integer idAccount) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param user id du Account a promouvoir
	 */
	public static void becomeArtist(Integer idAccount) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permet de modifier son compte
	 * @param account L'objet Account contenant les nouvelles informations
	 */
	public static void modifyAccount(Integer idAccount, Account account) {
		// TODO les champs null de "account" ne provoqueront aucun changement en base, les autres oui.
	}

	/**
	 * Permet de voir son Account
	 * @param idAccount id du Account qu'on veut voir
	 */
	public static void seeAccount(Integer idAccount) {
		// TODO Auto-generated method stub
		
	}


}
