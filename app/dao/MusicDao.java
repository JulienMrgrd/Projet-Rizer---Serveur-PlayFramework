package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.mongodb.gridfs.GridFSInputFile;

import models.Music;
import modelsmongo.PlayJongo;

public class MusicDao {
	
	/**
	 * Ajoute une music dans la collection "Music"
	 * ajoute le fichier source de la music
	 * @param f : fichier source
	 * @param m : objet music
	 * @throws IOException
	 */
	public void addMusic(File f, Music m) throws IOException{
		GridFSInputFile gfsFile = PlayJongo.gridfs().createFile(f);
		gfsFile.setFilename(m.getName());
		//Utiliser un ID spécifique
		//A fini :metadata
		gfsFile.setId(m.getFileId());
		gfsFile.save();
		PlayJongo.getCollection("Music").save(m);
		
	}

	/**
	 * Supprime la music d'identifiant _id
	 * @param _id
	 */
	public void deleteMusic(String _id){
		Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		PlayJongo.gridfs().remove(musicTmp.getFileId());
		PlayJongo.getCollection("Music").remove(_id);
		
		
	}
	
	/**
	 * Recupere la music d'identifiant _id
	 * @param _id
	 * @return
	 */
	public Music getMusic(String _id){
		return PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
	}
	
	/**
	 * Ajoute un like a une music
	 * @param _idMusic : identifiant de la music
	 * @param _idLiker : identifiant de l'utilisateur ayant faite le like
	 */
	public void addLike(String _idMusic, String _idLiker){
		PlayJongo.getCollection("Music").update("{_id:#}",_idMusic).with("{$push: {like: #}}",_idLiker);
	}
	
	/**
	 * Recupere le flux du fichier source d'une music d'identifiant _id
	 * @param _id
	 * @return
	 */
	
	public InputStream getInputStreamMusic(String _id){
		//Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		return PlayJongo.gridfs().findOne(_id).getInputStream();
	}
	
	
	
}
