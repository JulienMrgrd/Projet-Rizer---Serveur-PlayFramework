package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import service.PlaylistService;
import service.SocialActivityService;
import service.TokenService;
import utils.RizerUtils;
import utils.TokenException;

public class SocialActivityRoutes extends Controller{
	
    /**
	 * Follow un artist
	 * @param UUID
	 * @param idArtist l'artiste à follow
	 */
	public static Result followArtist (String UUID, String artistId){ 
		String idAccount = TokenService.checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
		SocialActivityService.followArtist(idAccount, artistId);
		return ok("followArtist:"
				+ "\nUUID = "+UUID+"\nartistId = "+artistId);
    }
    
	/**
	 * Unfollow un artist
	 * @param UUID
	 * @param idArtist l'artiste à unfollow
	 */
	public static Result unfollowArtist (String UUID, String artistId){ 
		String idAccount = TokenService.checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
		SocialActivityService.unfollowArtist(UUID, idAccount, artistId);
		return ok("unfollowArtist:"
				+ "\nUUID = "+UUID+"\nartistId = "+artistId);
    }

	/**
	 * Follow un artist
	 * @param UUID
	 * @param idUser le user à rizer (si une demande est en cours)
	 */
	public static Result rizerFuturArtist (String UUID, String userId){
		String idAccount = TokenService.checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
		SocialActivityService.rizeFuturArtist(UUID, idAccount, userId);
		return ok("rizerFuturArtist:"
				+ "\nUUID = "+UUID+"\nuserId = "+userId);
    }

}
