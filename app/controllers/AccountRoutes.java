package controllers;

import models.Account;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

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
     * Modifie en base l'Account passé en parametre(en JSon), et met ses attributs non nuls à jour en base
     * @param UUID
     * @return true si OK, false sinon
     */
    public static Result modifyAccountInformations(String UUID){
    	//TODO : Ios envoie l'objet Account dans la requete POST, en transformant Account en Json: 
    	//TODO : JsonNode accountJson = Json.toJson(account);
    	//TODO : Voir https://www.playframework.com/documentation/2.4.x/JavaJsonActions
    	JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } 

        Account account = play.libs.Json.fromJson(json, Account.class);
        if(account == null) {
             return badRequest("Not an Account object");
        }
    	//TODO: construire un objet Account et appeler AccountService.modifyAccount(...)
    	return ok("modifyAccountInformations:"
    			+ "\nUUID = "+UUID+"\naccount_pseudo = "+account.getPseudo());
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
