package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import service.SocialActivityService;
import service.TokenService;
import utils.RizerUtils;

public class SocialActivityRoutes extends Controller{
	
    /**
	 * Follow un artist
	 * @param UUID
	 * @param idArtist l'artiste à follow
	 */
	public static Result followArtist (String UUID, String artistId){ 
		String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
		new SocialActivityService().followArtist(idAccount, artistId);
		return ok("followArtist:"
				+ "\nUUID = "+UUID+"\nartistId = "+artistId);
    }
    
	/**
	 * Unfollow un artist
	 * @param UUID
	 * @param idArtist l'artiste à unfollow
	 */
	public static Result unfollowArtist (String UUID, String artistId){ 
		String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
		new SocialActivityService().unfollowArtist(idAccount, artistId);
		return ok("unfollowArtist:"
				+ "\nUUID = "+UUID+"\nartistId = "+artistId);
    }

	/**
	 * Follow un artist
	 * @param UUID
	 * @param idUser le user à rizer (si une demande est en cours)
	 */
	public static Result rizerFuturArtist (String UUID, String userId){
		String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
		new SocialActivityService().rizeFuturArtist(idAccount, userId);
		return ok("rizerFuturArtist:"
				+ "\nUUID = "+UUID+"\nuserId = "+userId);
    }

}
