package dao;



import models.Account;
import models.Artist;
import models.Token;
import models.User;
import modelsmongo.PlayJongo;

import org.joda.time.DateTime;



public class TokenDao extends Dao {
	
	/**
	 * Verrifie l'authentification et renvoi id du compte
	 * @param login
	 * @param pswd
	 * @return renvoi null le compte n'existe pas 
	 */
	private String connexion(String login, String pswd){
		Account comptetmp=PlayJongo.getCollection("Artist").findOne("{login:#, password:#}", login, pswd).as(Artist.class);
		if(comptetmp==null)
			comptetmp=PlayJongo.getCollection("User").findOne("{login:#, password:#}", login, pswd).as(User.class);
		if(comptetmp==null)
			return null;
		return comptetmp._id;
		
	}
	
	
	/**
	 * Authentification et renvoi un String correspondant au token
	 * @param login
	 * @param pswd
	 * @return
	 */
	public String getNewToken(String login, String pswd){
		String idAccount=connexion(login,pswd);
		if(idAccount==null)
			return null;
		
		Token userToken = PlayJongo.getCollection("Token").findOne("{accountId:#}", idAccount).as(Token.class);
		if(userToken!=null)
			return userToken._id;
			
		userToken=new Token(idAccount);
		PlayJongo.getCollection("Token").save(userToken);
		
		return userToken._id;	
	}
	
	
	
	
	/**
	 * Verifie la validite d'un token
	 * @param token
	 * @return
	 */
	public String checkToken(String token){
		Token userToken=PlayJongo.getCollection("Token").findOne("{_id:#}", token).as(Token.class);
		if(userToken==null)
			return null;
		
		if(userToken.getDiffDay() > 2){
			userToken.setDateMaj();
			PlayJongo.getCollection("Token").save(userToken);
		}
		return userToken.getAccountId();
		
	}
	
	/**
	 * Supprime un token en base _ logout
	 * @param _id
	 */
	public void deleteToken(String _id){
		PlayJongo.getCollection("Token").remove(_id);
	}
	
	
	/**
	 * Supprime les token expirer
	 */
	public void cleanToken(){
		PlayJongo.getCollection("Token").remove("{ dateMaj: { $lt: # }}", new DateTime().minusDays(2).toString());
	}
	
}
