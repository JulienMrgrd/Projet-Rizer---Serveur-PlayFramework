package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class SocialActivityRoutes extends Controller{
	
    public static Result followArtist(String UUID, Integer idArtist) {
		return ok("Your new application is ready."); 
	}
    
    public static Result unfollowArtist(String UUID, Integer idArtist){
		return ok("Your new application is ready."); 
	}

    public static Result rizerFuturArtist(String UUID){
		return ok("Your new application is ready."); 
	}

}
