package controllers;

import models.Playlist;
import play.mvc.Controller;
import play.mvc.Result;
import service.PlaylistService;
import service.TokenService;
import utils.RizerUtils;

import com.fasterxml.jackson.databind.JsonNode;

public class PlaylistRoutes extends Controller{
	
	/**
	 * Creer une playlist
	 * @param UUID
	 * @param name nom de la playlist
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result createOnePlaylist(String UUID, String name, String description){
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
    	new PlaylistService().createPlayList(idAccount, name, description);
    	return ok("createOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nname = "+name);
    }
    
    /**
	 * Verifie si l'utilisateur possède une playlist
	 * @param UUID
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result hasAPlaylist(String UUID){
    	String idAccount = new TokenService().checkToken(UUID);
    	if(idAccount==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
    	new PlaylistService().hasAPlayList(idAccount);
    	return ok("hasAPlaylist:\nUUID = "+UUID);
    	
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
    	return ok("modifyInfosOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nname = "+name+"\ndescription = "+description);
    }
    
    /**
	 * Supprime une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 */
	public static Result deleteOnePlaylist(String UUID, String idPlaylist){ 
		if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);
    	
    	new PlaylistService().deletePlaylist(idPlaylist);
		return ok("deleteOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist);
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
		return ok("addMusicToPlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist+"\nmusicID = "+musicID); 
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
    	
    	new PlaylistService().removeMusicInPlaylist(idPlaylist, musicID);
		return ok("removeMusicToPlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist+"\nmusicID = "+musicID); 
	}
	
	/**
	 * Visualise une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public static Result visualizeOnePlaylist(String UUID, String idPlaylist){
		if(new TokenService().checkToken(UUID)==null) return unauthorized(RizerUtils.BAD_TOKEN);
		
    	new PlaylistService().visualizePlaylist(idPlaylist);
		return ok("visualizeOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist); 
	}

}
