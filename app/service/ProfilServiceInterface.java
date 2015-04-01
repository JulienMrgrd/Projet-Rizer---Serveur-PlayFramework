package service;

import java.util.List;

import models.Artist;
import models.Profil;

public interface ProfilServiceInterface {

	/**
	 * Permet de se connecter
	 * @param email de l'utilsateur
	 * @param password de l'utilisateur
	 * @return un Profil correspondant
	 */
	public Profil connection (String email, String password);

	/**
	 * Permet de se deconnecter
	 */
	public void disconnection();

	/**
	 * Inscrit un User
	 * @param surname c'est le nom 
	 * @param forename c'est le prenom 
	 * @param email de l'utilisateur
	 * @param pseudonym pseudo de l'utilisateur
	 * @return Id du user creer ou null sinon
	 */
	public Integer subscribeUser(String surname, String forename,String email, String pseudonym);

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
	public Artist subscribeArtist( String surname, String forename,String email, String pseudonym, List<Integer> playlists,List<Integer> rises, List<Integer> follow,List<Integer> historical);
	/**
	 * Permet de se desinscrire
	 * @param idProfil id du profil a supprimer
	 */
	public void unsubscribe(Integer idProfil);
	/**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param user id du profil a promouvoir
	 */
	public void becomeArtist(Integer idProfil);
	/**
	 * Permet de modifier son profil
	 * @param profil Le profil qu'on recupere pour le changer en base
	 */
	public void modifyProfil(Integer idProfil, Profil profil);
	/**
	 * Permet de voir son profil
	 * @param idProfil id du profil qu'on veut voir
	 */
	public void seeProfil(Integer idProfil);	
}


