package controllers;

import java.util.Map;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class AccountRoutes extends Controller {

    public static Result inscription(String login, String mdp, String mail) {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result connexion(String login, String mdp){
    	return ok(index.render("Your new application is ready."));
    }

    public static Result checkToken(String UUID){
    	return ok(index.render("Your new application is ready."));
    }

    public static Result modifyAccountInformations(String UUID, Map<String, String> infos){
    	return ok(index.render("Your new application is ready."));
    }

    public static Result visualizeAccountInformations(String UUID, Integer idAccount){
    	return ok(index.render("Your new application is ready."));
    }

    public static Result deleteAccount(String UUID) {
    	return ok(index.render("Your new application is ready."));
    }

    public static Result sendDemandBecomeArtist(String UUID) {
    	return ok(index.render("Your new application is ready."));
    }

}
