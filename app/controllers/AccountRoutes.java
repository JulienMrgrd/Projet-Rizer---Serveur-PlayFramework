package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import utils.RizerUtils;

public class AccountRoutes extends Controller {
	
    /**
	 * connecte un utilisateur
	 * @param login
	 * @param mdp
	 * @return l'id du compte
	 */
    public static Result connexion(String login, String pass){
    	//TODO: appeler TokenService.connection(...)
    	return ok("connexion:"
    			+ "\nlogin = "+login+"\npass = "+pass);
    }

    /**
     * Verifie le token d'un utilisateur
     * @param UUID
     * @return true si OK, false sinon
     */
    public static Result checkToken(String UUID){
    	//TODO: appeler TokenService.checkToken(...)
    	return ok("checkToken:"
    			+ "\nToken = "+UUID);
    }
	
	/**
	 * Inscris un utilisateur
	 * @param login
	 * @param pass
	 * @param mail
	 * @param pseudo
	 * @return l'id du Account crée, ou null si existant
	 */
    public static Result inscription(String login, String pass, String mail, String pseudo) {
    	//TODO: appeler AccountService.subscribeAccount(...)
        return ok("inscription:"
    			+ "\nlogin = "+login+"\npass = "+pass+"\nmail = "+mail+"\npseudo = "+pseudo);
    }
    
    /**
     * Modifie en base les informations non nulles passées en parametre, et met à jour le compte
     * @param UUID
     * @param keys (les attributs de Account)
     * @param values (les nouvelles valeurs)
     * @return true si OK, false sinon
     */
    public static Result modifyAccountInformations(String UUID, String keys, String values){
    	//TODO: construire un objet Account et appeler AccountService.modifyAccount(...)
    	String[] keysArray = keys.split(RizerUtils.URL_SPLITTER);
    	String[] valuesArray = values.split(RizerUtils.URL_SPLITTER);
    	return ok("modifyAccountInformations:"
    			+ "\nUUID = "+UUID+"\nnombre de clés = "+keysArray.length+"\nnombre de valeurs = "+valuesArray.length);
    }

    /**
     * Retourne certaines informations du compte
     * @param UUID
     * @return un Account
     */
    public static Result visualizeAccountInformations(String UUID){
    	//TODO: appeler AccountService.visualizeAccount(...)
    	return ok("visualizeAccountInformations:"
    			+ "\nUUID = "+UUID);
    }
    
    /**
     * Retourne TOUTES (excepté pass) les informations du compte
     * @param UUID
     * @return un Account
     */
    public static Result visualizeMyAccountInformations(String UUID){
    	//TODO: appeler AccountService.visualizeAccount(...)
    	return ok("visualizeMyAccountInformations:"
    			+ "\nUUID = "+UUID);
    }

    /**
	 * Permet de se desinscrire
	 * @param UUID
	 * @return true si Ok, false sinon
	 */
    public static Result deleteAccount(String UUID) {
    	//TODO: appeler AccountService.deleteAccount(...)
    	return ok("deleteAccount:"
    			+ "\nUUID = "+UUID);
    }

    /**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param UUID
	 * @return true si Ok, false sinon
	 */
    public static Result sendDemandBecomeArtist(String UUID) {
    	//TODO: appeler AccountService.becomeArtist(...)
    	return ok("sendDemandBecomeArtist:"
    			+ "\nUUID = "+UUID);
    }

}
