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
		
		if(new SocialActivityService().followArtist(idAccount, artistId)){
			return ok();
		}
		return unauthorized();
    }
    
	/**
	 * Unfollow un artist
	 * @param UUID
	 * @param idArtist l'artiste à unfollow
	 */
	public static Result unfollowArtist (String UUID, String artistId){ 
		String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
		if(new SocialActivityService().unfollowArtist(idAccount, artistId)){
			return ok();
		}
		return unauthorized();
    }

	/**
	 * Follow un artist
	 * @param UUID
	 * @param idUser le user à rizer (si une demande est en cours)
	 */
	public static Result rizerFuturArtist (String UUID, String userId){
		String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
		if(new SocialActivityService().rizeFuturArtist(idAccount, userId)){
			return ok();
		}
		return unauthorized();
    }

}
