package dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.mongodb.gridfs.GridFSInputFile;

import models.*;
import modelsmongo.PlayJongo;

public class AccountDao extends Dao{

	/**
	 * Inscription d'un utilisateur (user ou artist)
	 * @param compte : element à inserer en base
	 * @return token
	 */
	public String inscription(Account compte){
		
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
	
	public boolean addPhoto(String idCompte, File f) throws IOException{
		Account tmp;
		tmp =(new ArtistDao()).getArtist(idCompte);
		if(tmp == null )
			tmp =(new UserDao()).getUser(idCompte);
		if(tmp==null)
			return false;
		GridFSInputFile gfsFile = PlayJongo.gridfs().createFile(f);
		gfsFile.setFilename(tmp.getPhoto());
		gfsFile.save();
		tmp.setPhoto(gfsFile.getId().toString());
		this.updateAccount(tmp);
		return true;
		
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
