package controllers;

import java.util.List;

import models.Account;
import models.Artist;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import service.AccountService;
import service.TokenService;
import utils.RizerUtils;

import com.fasterxml.jackson.databind.JsonNode;

public class AccountRoutes extends Controller {
	
	/**
	 * connecte un utilisateur
	 * @param login
	 * @param mdp
	 * @return l'id du compte
	 */
    public static Result connexion(String login, String pass){
    	String UUID = new TokenService().connection(login, pass);
    	if(UUID==null) return badRequest(RizerUtils.BAD_CONNECTION);
    	else return ok(UUID);
    }
    
    public static Result checkToken(String uuid){
    	String idAccount = new TokenService().checkToken(uuid);
    	if(idAccount==null) return badRequest(RizerUtils.BAD_TOKEN);
    	else return ok(uuid);
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
    	String uuid = new AccountService().subscribeAccountUser(login, pass, mail ,pseudo);
    	if(uuid==null) return badRequest(RizerUtils.BAD_INSCRIPTION);
    	else return ok(uuid);
    }
    
    
    /**
     * Modifie en base l'Account passé en parametre(en JSon), et met ses attributs non nuls à jour en base
     * @param UUID
     * @return true si OK, false sinon
     */
    public static Result modifyAccountInformations(String UUID){
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return badRequest(RizerUtils.BAD_TOKEN);
    	
    	//TODO : Ios envoie l'objet Account dans la requete POST, en transformant Account en Json: 
    	//TODO : JsonNode accountJson = Json.toJson(account);
    	//TODO : Voir https://www.playframework.com/documentation/2.4.x/JavaJsonActions
    	JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } 

        Account account = play.libs.Json.fromJson(json, Account.class);
        if(account == null) {
             return badRequest(RizerUtils.NOT_ACCOUNT);
        }
    	new AccountService().modifyAccount(idAccount, account);
    	return ok();
    }

    /**
     * Retourne certaines informations du compte
     * @param UUID
     * @return un Account
     */
    public static Result visualizeAccountInformations(String UUID, String idAccount){
    	if(new TokenService().checkToken(UUID)==null) return badRequest(RizerUtils.BAD_TOKEN);
    	
    	Account account = new AccountService().visualizeAccount(idAccount);
    	JsonNode jn = play.libs.Json.toJson(account);
    	return ok(jn);
    }
    
    /**
     * Retourne TOUTES (excepté pass) les informations du compte
     * @param UUID
     * @return un Account
     */
    public static Result visualizeMyAccountInformations(String UUID){
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return badRequest(RizerUtils.BAD_TOKEN);
    	
    	Account account = new AccountService().visualizeMyAccount(idAccount);
    	JsonNode jn = play.libs.Json.toJson(account);
    	return ok(jn);
    }

    /**
	 * Permet de se desinscrire
	 * @param UUID
	 * @return true si Ok, false sinon
	 */
    public static Result deleteAccount(String UUID) {
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return badRequest(RizerUtils.BAD_TOKEN);
    	
    	new AccountService().deleteAccount(idAccount);
    	return ok();
    }

    /**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param UUID
	 * @return true si Ok, false sinon
	 */
    public static Result sendDemandBecomeArtist(String UUID) {
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return badRequest(RizerUtils.BAD_TOKEN);
    	
    	if(new AccountService().becomeArtist(idAccount)){
    		return ok();
    	} else {
    		return unauthorized();
    	}
    }
    
    public static Result findAllArtists(){
    	List<Artist> artistes = new AccountService().findAllArtists();
    	if(artistes!=null){
	    	JsonNode json = play.libs.Json.toJson(artistes);
	    	return ok(json);
    	}
    	return ok();
    }
    
    public static Result findAllFutursArtists(){
    	List<User> futurs_artistes = new AccountService().findAllFutursArtists();
    	if(futurs_artistes!=null){
    		JsonNode json = play.libs.Json.toJson(futurs_artistes);
    		return ok(json);
    	}
    	return ok();
    }

}
