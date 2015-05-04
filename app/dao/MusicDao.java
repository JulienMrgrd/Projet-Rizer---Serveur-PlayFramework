package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.mongodb.gridfs.GridFSInputFile;

import models.Music;
import models.Token;
import modelsMongo.PlayJongo;

public class MusicDao {
	
	public static void addMusic(File f, Music m) throws IOException{
		GridFSInputFile gfsFile = PlayJongo.gridfs().createFile(f);
		gfsFile.setFilename(m.getName());
		//Utiliser un ID spécifique
		//A fini :metadata
		gfsFile.setId(m.getFileId());
		gfsFile.save();
		PlayJongo.getCollection("Music").save(m);
		
	}

	public static void deleteMusic(String _id){
		Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		PlayJongo.gridfs().remove(musicTmp.getFileId());
		PlayJongo.getCollection("Music").remove(_id);
		
		
	}
	
	
	public static Music getMusic(String _id){
		return PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
	}
	
	public static InputStream getInputStreamMusic(String _id){
		//Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		return PlayJongo.gridfs().findOne(_id).getInputStream();
	}
	
	
}
