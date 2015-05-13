package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.mongodb.gridfs.GridFSInputFile;

import models.*;
import modelsmongo.PlayJongo;

public class AccountDao {

	/**
	 * Inscription d'un utilisateur (user ou artist)
	 * @param compte : element à inserer en base
	 * @param f : image correspondant au profile
	 * @return
	 * @throws IOException
	 */
	public  String inscription(Account compte, File f) throws IOException{
		GridFSInputFile gfsFile = PlayJongo.gridfs().createFile(f);
		gfsFile.setFilename(compte.getPhoto());
		gfsFile.save();
		compte.setPhoto(gfsFile.getId().toString());
		if(!(new AccountDao()).checkLogin(compte.getLogin()))
			return null;
		if(compte instanceof Artist)
			return (new ArtistDao()).inscriptionArtist((Artist)compte);
		return (new UserDao()).inscriptionUser((User)compte);


	}
	/**
	 * Verifi un utilisateur possede deja ce login
	 * @param login 
	 * @return
	 */

	public boolean checkLogin(String login){
		return (new ArtistDao()).checkLoginArtist(login) && (new UserDao()).checkLoginUser(login);

	}

	/**
	 * Recupere le flux de l'image
	 * @param _id : id de l'image en base
	 * @return
	 */
	public InputStream getAccountPhoto(String _id){
		return PlayJongo.gridfs().findOne(_id).getInputStream();
	}


	/**
	 * Mise jour d'un données d'un utilisateur
	 * @param compte
	 */
	public void updateAccount(Account compte){
		if(compte instanceof Artist){
			PlayJongo.getCollection("Artist").save(compte);
		}else{
			PlayJongo.getCollection("User").save(compte);
		}
	}



}
