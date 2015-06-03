package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Playlist;
import play.mvc.Controller;
import play.mvc.Result;
import service.PlaylistService;
import service.TokenService;
import utils.RizerUtils;

public class PlaylistRoutes extends Controller{
	
	/**
	 * Creer une playlist
	 * @param UUID
	 * @param name nom de la pilaylist
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result createOnePlaylist(String UUID, String name, String description){
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
    	Playlist playlist = new PlaylistService().createPlayList(idAccount, name, description);
    	if(playlist!=null){
	    	JsonNode json = play.libs.Json.toJson(playlist);
	    	return ok(json);
    	}
    	return unauthorized();
    }
    
    /**
	 * Verifie si l'utilisateur possède une playlist
	 * @param UUID
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result hasAPlaylist(String UUID){
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
    	if(new PlaylistService().hasAPlayList(idAccount)){
    		return ok();
    	}
    	return unauthorized();
    	
    }
    
    /**
     * Modifie en base la Playlist passée en parametre (en JSon), et met ses attributs non nuls à jour en base
     * @param UUID
     * @param idPlaylist
     * @param name
     * @param description
     * @return true si OK, false sinon
     */
    public static Result modifyInfosOnePlaylist(String UUID, String idPlaylist, String name, String description){
    	if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
        new PlaylistService().modifyPlaylist(idPlaylist, name, description);
    	return ok();
    }
    
    /**
	 * Supprime une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 */
	public static Result deleteOnePlaylist(String UUID, String idPlaylist){ 
		if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
    	new PlaylistService().deletePlaylist(idPlaylist);
		return ok();
    }
	
	/**
	 * Ajoute une music a une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music (préalablement uploadé sur serveur)
 	 * @return true si Ok, false sinon
	 */
	public static Result addMusicToPlaylist(String UUID, String idPlaylist, String musicID){ 
		if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);

    	new PlaylistService().addMusicToPlaylist(idPlaylist, musicID);
		return ok(); 
	}
	
	/**
	 * Enleve une music d'une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 * @param idMusic id de la music
	 * @return true si Ok, false sinon
	 */
	public static Result removeMusicToPlaylist(String UUID, String idPlaylist, String musicID){ 
		if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
    	if(new PlaylistService().removeMusicInPlaylist(idPlaylist, musicID)){
    		return ok();
    	}
    	return unauthorized();
	}
	
	/**
	 * Visualise une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public static Result visualizeOnePlaylist(String UUID, String idPlaylist){
		if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
    	Playlist playlist = new PlaylistService().visualizePlaylist(idPlaylist);
    	if(playlist!=null){
	    	JsonNode json = play.libs.Json.toJson(playlist);
	    	return ok(json);
    	}
    	return unauthorized();
	}

}
