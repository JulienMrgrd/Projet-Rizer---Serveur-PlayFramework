package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class SocialActivityRoutes extends Controller{
	
    public static Result followArtist(String UUID, Integer idArtist) {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result unfollowArtist(String UUID, Integer idArtist){
    	return ok(index.render("Your new application is ready."));
    }

    public static Result rizerFuturArtist(String UUID){
    	return ok(index.render("Your new application is ready."));
    }

}
