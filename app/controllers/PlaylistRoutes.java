package controllers;

import models.Playlist;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

public class PlaylistRoutes extends Controller{
	
	/**
	 * Creer une playlist
	 * @param UUID
	 * @param name nom de la playlist
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result createOnePlaylist(String UUID, String name){
    	//TODO: appeler PlayListService.createPlayList(...)
    	return ok("createOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nname = "+name);
    }
    
    /**
	 * Verifie si l'utilisateur possède une playlist
	 * @param UUID
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result hasAPlaylist(String UUID){
    	//TODO: appeler PlayListService.hasAPlaylist(...)
    	return ok("hasAPlaylist:\nUUID = "+UUID);
    }
    
    /**
     * Modifie en base la Playlist passée en parametre (en JSon), et met ses attributs non nuls à jour en base
     * @param UUID
     * @param idPlaylist
     * @return true si OK, false sinon
     */
    public static Result modifyInfosOnePlaylist(String UUID, int idPlaylist){
    	//TODO : Ios envoie l'objet Playlist dans la requete POST, en transformant playlist en Json: 
    	//TODO : JsonNode playlistJson = Json.toJson(playlist);
    	//TODO : Voir https://www.playframework.com/documentation/2.4.x/JavaJsonActions
    	JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } 

        Playlist playlist = play.libs.Json.fromJson(json, Playlist.class);
        if(playlist == null) {
             return badRequest("Not a Playlist object");
        }
    	//TODO: construire un objet PlayList et appeler PlaylistService.modifyPlaylist(...)
    	return ok("modifyInfosOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist+"\nplaylist = "+playlist.getName());
    }
    
    /**
	 * Supprime une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 */
	public static Result deleteOnePlaylist(String UUID, int idPlaylist){ 
		//TODO: appeller PlayListService.deletePlaylist(...)
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
	public static Result addMusicToPlaylist(String UUID, int idPlaylist, int musicID){ 
		//TODO: appeller PlayListService.addMusicToPlaylist(...)
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
	public static Result removeMusicToPlaylist(String UUID, int idPlaylist, int musicID){ 
		//TODO: appeller PlayListService.removeMusicInPlaylist(...)
		return ok("removeMusicToPlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist+"\nmusicID = "+musicID); 
	}
	
	/**
	 * Visualise une playlist
	 * @param UUID
	 * @param idPlaylist id de la playlist
	 * @return la Playlist, null sinon	 
	 */
	public static Result visualizeOnePlaylist(String UUID, int idPlaylist){
		//TODO: appeller PlayListService.visualizeOnePlaylist(...)
		return ok("visualizeOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist); 
	}

}
