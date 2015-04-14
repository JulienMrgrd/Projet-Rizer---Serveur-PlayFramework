package controllers;

import models.Music;
import models.Playlist;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class MusicRoutes extends Controller{
	
    public static Result createOnePlaylist(String UUID, Playlist playlist){ 
    	return ok(index.render("Your new application is ready.")); 
    }

	public static Result addMusic (String UUID, Music music){ 
		return ok(index.render("Your new application is ready.")); 
		}

	public static Result modifyInfosMusic (String UUID, Music music){ 
		return ok(index.render("Your new application is ready.")); 
	}

	public static Result deleteMusic (String UUID, Integer musicID){ 
		return ok(index.render("Your new application is ready.")); 
		}

	public static Result likeMusic (String UUID, Integer musicID){ 
		return ok(index.render("Your new application is ready.")); 
		}
	
	public static Result addCommentToMusic(String UUID, Integer musicID, String comment){ 
		return ok(index.render("Your new application is ready.")); 
		}
	
	public static Result listenMusic( String UUID, Integer musicID){ 
		return ok(index.render("Your new application is ready.")); 
	}

}
