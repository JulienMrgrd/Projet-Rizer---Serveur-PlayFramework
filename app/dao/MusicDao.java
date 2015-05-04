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
		gfsFile.setId(m.getFileId());
		PlayJongo.getCollection("Music").save(m);
		
	}

	public static void deleteMusic(String _id){
		Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		PlayJongo.gridfs().remove(musicTmp.getFileId());
		PlayJongo.getCollection("Music").remove(_id);
		
		
	}
	
	public static InputStream getInputStreamMusic(String _id){
		Music musicTmp=PlayJongo.getCollection("Music").findOne("{_id:#}", _id).as(Music.class);
		return PlayJongo.gridfs().findOne(musicTmp.getFileId()).getInputStream();
	}
	
	
}
