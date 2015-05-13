package service;

import dao.TokenDao;

public class TokenService {

	public TokenService(){
		
	}
	
	/**
	 * Permet de se connecter
	 * @param login de l'utilisateur
	 * @param password de l'utilisateur
	 * @return l'id du Account correspondant
	 */
	public String connection(String login, String password) {
		
		return new TokenDao().getNewToken(login, password);
	}

	/**
	 * Permet de se deconnecter
	 */
	public void logOut(String UUID) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Verifie la validite d'un token
	 * @param token
	 * @return
	 */
	public String checkToken(String UUID){
		return new TokenDao().checkToken(UUID);
	}
	
}
