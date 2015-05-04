package dao;

import models.*;
import modelsMongo.PlayJongo;

public class AlbumDao {
	
	public static void deleteAlbum(String _id){
		Album albumTmp=PlayJongo.getCollection("Album").findOne("{_id:#}", _id).as(Album.class);
		for(String id : albumTmp.getTracks()){
			MusicDao.deleteMusic(id);
		}
		
		
	}

}
