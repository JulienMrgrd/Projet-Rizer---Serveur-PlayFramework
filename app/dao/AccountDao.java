package dao;

import models.*;
import modelsMongo.PlayJongo;

public class AccountDao {

	public static String inscription(Account compte){
		if(compte instanceof Artist)
			return ArtistDao.inscriptionArtist((Artist)compte);
		return UserDao.inscriptionUser((User)compte);


	}

	public static boolean checkLogin(String login){
		return ArtistDao.checkLoginArtist(login) && UserDao.checkLoginUser(login);

	}

	public static void deleteUser(String _id){
		
	}

}
