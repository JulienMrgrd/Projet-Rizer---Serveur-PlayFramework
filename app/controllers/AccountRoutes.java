package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import utils.RizerUtils;

public class AccountRoutes extends Controller {
	
    public static Result inscription(String login, String mdp, String mail) {
    	//TODO: appeler AccountService.subscribeUser(...)
        return ok("inscription:"
    			+ "\nlogin = "+login+"\nmdp = "+mdp+"\nmail = "+mail);
    }
    
    public static Result connexion(String login, String mdp){
    	//TODO: appeler AccountService.connection(...)
    	return ok("connexion:"
    			+ "\nlogin = "+login+"\nmdp = "+mdp);
    }

    public static Result checkToken(String UUID){
    	//TODO: appeler TokenService.checkToken(...)
    	return ok("checkToken:"
    			+ "\nToken = "+UUID);
    }

    public static Result modifyAccountInformations(String UUID, String keys, String values){
    	//TODO: construire un objet Account et appeler AccountService.modifyAccount(...)
    	String[] keysArray = keys.split(RizerUtils.URL_SPLITTER);
    	String[] valuesArray = values.split(RizerUtils.URL_SPLITTER);
    	return ok("modifyAccountInformations:"
    			+ "\nUUID = "+UUID+"\nnombre de clés = "+keysArray.length+"\nnombre de valeurs = "+valuesArray.length);
    }

    public static Result visualizeAccountInformations(String UUID, Integer idAccount){
    	//TODO: appeler AccountService.seeAccount(...)
    	return ok("visualizeAccountInformations:"
    			+ "\nUUID = "+UUID+"\nIdAccount = "+idAccount);
    }

    public static Result deleteAccount(String UUID) {
    	//TODO: appeler AccountService.unsubscribe(...)
    	return ok("deleteAccount:"
    			+ "\nUUID = "+UUID);
    }

    public static Result sendDemandBecomeArtist(String UUID) {
    	//TODO: appeler AccountService.becomeArtist(...)
    	return ok("sendDemandBecomeArtist:"
    			+ "\nUUID = "+UUID);
    }

}
