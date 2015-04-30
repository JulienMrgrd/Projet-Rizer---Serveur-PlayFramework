package controllers;

import java.io.File;

import models.Music;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

public class MusicRoutes extends Controller{
	
	/**
	 * Upload une Music en base
	 * @param UUID
	 * @param music
	 * @return
	 */
	public static Result uploadMusic (String UUID){ 
		//TODO: regarder https://www.playframework.com/documentation/2.0/JavaFileUpload
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart musique = body.getFile("musique");
		if (musique != null) {
			File file = musique.getFile();
			if(file==null) badRequest("error", "is not a file");
		} else {
			return badRequest("error", "Missing file");
		}
		String fileName = musique.getFilename();
		String contentType = musique.getContentType(); 
		return ok("uploadMusic:"
    			+ "\nUUID = "+UUID+"\nmusic = "+fileName);
	}

	/**
	 * Modifie en base la Music passée en parametre (en JSon), et met ses attributs non nuls à jour en base
	 * @param UUID
	 * @return
	 */
	public static Result modifyInfosMusic (String UUID){ 
		//TODO : Ios envoie l'objet Music dans la requete POST, en transformant Account en Json: 
    	//TODO : JsonNode musicJson = Json.toJson(account);
    	//TODO : Voir https://www.playframework.com/documentation/2.4.x/JavaJsonActions
    	JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } 

        Music music = play.libs.Json.fromJson(json, Music.class);
        if(music == null) {
             return badRequest("Not a Music object");
        }
    	//TODO: construire un objet Music et appeler MusicService.modifyInfosMusic(...)
    	return ok("modifyInfosMusic:"
    			+ "\nUUID = "+UUID+"\nmusic = "+music.getName());
    }

	/**
	 * Supprime une music
	 * @param UUID
	 * @param idMusic
	 */
	public static Result deleteMusic (String UUID, int musicID){ 
		//TODO: appeller MusicService.deleteMusic(...)
		return ok("deleteMusic:"
				+ "\nUUID = "+UUID+"\nmusicID = "+musicID);
    }
	
	/**
	 * Like une music
	 * @param UUID
	 * @param idMusic
	 */
	public static Result likeMusic (String UUID, int musicID){ 
		//TODO: appeller MusicService.likerMusic(...)
		return ok("likeMusic:"
				+ "\nUUID = "+UUID+"\nmusicID = "+musicID);
    }

	/**
	 * Commente une music
	 * @param UUID
	 * @param idMusic
	 */
	public static Result commentMusic (String UUID, int musicID, String comment){ 
		//TODO: appeller MusicService.commentMusic(...)
		return ok("commentMusic:"
				+ "\nUUID = "+UUID+"\nmusicID = "+musicID+"\ncomment = "+comment);
    }
	
	/**
	 * Envoie un flux à l'utilisateur pour écouter la musique
	 * @param UUID
	 * @param musicID
	 * @return
	 */
	public static Result listenMusic( String UUID, int musicID){ 
		//TODO: appeller MusicService.listenMusic(...)
		return ok("listenMusic:"
				+ "\nUUID = "+UUID+"\nmusicID = "+musicID);
    }

}
