package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.mongodb.gridfs.GridFSInputFile;

import models.*;
import modelsMongo.PlayJongo;

public class AccountDao {

	public static String inscription(Account compte, File f) throws IOException{
		GridFSInputFile gfsFile = PlayJongo.gridfs().createFile(f);
		gfsFile.setFilename(compte.getPhoto());
		gfsFile.save();
		compte.setPhoto(gfsFile.getId().toString());
		if(!AccountDao.checkLogin(compte.getLogin()))
			return null;
		if(compte instanceof Artist)
			return ArtistDao.inscriptionArtist((Artist)compte);
		return UserDao.inscriptionUser((User)compte);


	}

	//Verifi si le login passé en parametre existe deja en base
	public static boolean checkLogin(String login){
		return ArtistDao.checkLoginArtist(login) && UserDao.checkLoginUser(login);

	}
	
	public static InputStream getAccountPhoto(String _id){
		return PlayJongo.gridfs().findOne(_id).getInputStream();
	}

	

}
