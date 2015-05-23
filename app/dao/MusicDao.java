package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import models.Music;
import modelsmongo.PlayJongo;

import org.bson.types.ObjectId;

import com.mongodb.gridfs.GridFSInputFile;

public class MusicDao extends Dao{
	
	/**
	 * Ajoute une music dans la collection "Music"
	 * ajoute le fichier source de la music
	 * @param f : fichier source
	 * @param m : objet music
	 * @throws IOException
	 */
	public void addMusic(File f, Music m) throws IOException{
		if( f!=null ){
			GridFSInputFile gfsFile = PlayJongo.gridfs().createFile(f);
			gfsFile.setFilename(m.getName());
			//Utiliser un ID spécifique
			//A fini :metadata
			//gfsFile.setId(m.getFileId());
			m.setFileId(gfsFile.getId().toString());
			gfsFile.save();
		}
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
	
	@SuppressWarnings("unchecked")
	public List<Music> getMusicsContainsName(String name){
		Iterator<Music> m= PlayJongo.getCollection("Music").find("{name:{$regex:\""+name+"\", $options: 'i' }}").as(Music.class).iterator();
		return PlayJongo.toArray(m);
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
		Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		return PlayJongo.gridfs().findOne(new ObjectId(musicTmp.getFileId())).getInputStream();
	}

	public void updateMusic(Music musicTmp) {
		PlayJongo.getCollection("Album").save(musicTmp);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Music> findAll(){
		Iterator<Music> m= PlayJongo.getCollection("Music").find().as(Music.class).iterator();
		return PlayJongo.toArray(m);
	}
	
	
	
}
