package controllers;

import models.Music;
import models.Playlist;
import play.mvc.Controller;
import play.mvc.Result;

public class MusicRoutes extends Controller{
	
	public static Result addMusic (String UUID, Music music){ 
		return ok("Your new application is ready."); 
		}

	public static Result modifyInfosMusic (String UUID, Music music){ 
		return ok("Your new application is ready."); 
	}

	public static Result deleteMusic (String UUID, Integer musicID){ 
		return ok("Your new application is ready."); 
		}

	public static Result likeMusic (String UUID, Integer musicID){ 
		return ok("Your new application is ready."); 
		}
	
	public static Result addCommentToMusic(String UUID, Integer musicID, String comment){ 
		return ok("Your new application is ready."); 
		}
	
	public static Result listenMusic( String UUID, Integer musicID){ 
		return ok("Your new application is ready."); 
	}

}
