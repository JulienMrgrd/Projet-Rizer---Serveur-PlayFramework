package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class SocialActivityRoutes extends Controller{
	
    /**
	 * Follow un artist
	 * @param UUID
	 * @param idArtist l'artiste à follow
	 */
	public static Result followArtist (String UUID, int artistId){ 
		//TODO: appeller SocialActivityService.followArtist(...)
		return ok("followArtist:"
				+ "\nUUID = "+UUID+"\nartistId = "+artistId);
    }
    
	/**
	 * Unfollow un artist
	 * @param UUID
	 * @param idArtist l'artiste à unfollow
	 */
	public static Result unfollowArtist (String UUID, int artistId){ 
		//TODO: appeller SocialActivityService.unfollowArtist(...)
		return ok("unfollowArtist:"
				+ "\nUUID = "+UUID+"\nartistId = "+artistId);
    }

	/**
	 * Follow un artist
	 * @param UUID
	 * @param idUser le user à rizer (si une demande est en cours)
	 */
	public static Result rizerFuturArtist (String UUID, int userId){ 
		//TODO: appeller SocialActivityService.rizeFuturArtist(...)
		return ok("rizerFuturArtist:"
				+ "\nUUID = "+UUID+"\nuserId = "+userId);
    }

}
