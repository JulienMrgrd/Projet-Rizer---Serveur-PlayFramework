package service;

import dao.TokenDao;

public class TokenService {

	/**
	 * Permet de se connecter
	 * @param login de l'utilisateur
	 * @param password de l'utilisateur
	 * @return l'id du Account correspondant
	 */
	public String connection(String login, String password) {
		
		return TokenDao.getNewToken(login, password);
	}

	/**
	 * Permet de se deconnecter
	 */
	public static void logOut(String UUID) {
		// TODO Auto-generated method stub
		
	}
	
}
