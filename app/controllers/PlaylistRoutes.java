package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import utils.RizerUtils;

public class PlaylistRoutes extends Controller{
	
	/**
	 * creer une playlist
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
	 * verifie si l'utilisateur possède une playlist
	 * @param UUID
	 * @return idPlaylist si OK, null sinon
	 */
    public static Result hasAPlaylist(String UUID){
    	//TODO: appeler PlayListService.hasAPlaylist(...)
    	return ok("hasAPlaylist:\nUUID = "+UUID);
    }
    
    /**
     * Modifie en base les informations non nulles passées en parametre, et met à jour la playlist
     * @param UUID
     * @param idPlaylist
     * @param keys (les attributs de playlist)
     * @param values (les nouvelles valeurs)
     * @return true si OK, false sinon
     */
    public static Result modifyInfosOnePlaylist(String UUID, int idPlaylist, String keys, String values){
    	//TODO: construire un objet PlayList et appeler PlaylistService.modifyPlaylist(...)
    	String[] keysArray = keys.split(RizerUtils.URL_SPLITTER);
    	String[] valuesArray = values.split(RizerUtils.URL_SPLITTER);
    	return ok("modifyInfosOnePlaylist:"
    			+ "\nUUID = "+UUID+"\nidPlaylist = "+idPlaylist+"\nnombre de clés = "+keysArray.length+"\nnombre de valeurs = "+valuesArray.length);
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
