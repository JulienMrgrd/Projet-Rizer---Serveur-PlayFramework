package dao;



import java.io.IOException;

import org.joda.time.DateTime;





import models.*;
import modelsmongo.PlayJongo;



public class TokenDao {
	
	/**
	 * Verrifie l'authentification et renvoi id du compte
	 * @param login
	 * @param pswd
	 * @return renvoi null le compte n'existe pas 
	 */
	private static String connexion(String login, String pswd){
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
	public static String getNewToken(String login, String pswd){
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
	public static String checkToken(String token){
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
	public static void deleteToken(String _id){
		PlayJongo.getCollection("Token").remove(_id);
	}
	
	
	/**
	 * Supprime les token expirer
	 */
	public static void cleanToken(){
		PlayJongo.getCollection("Token").remove("{ dateMaj: { $lt: # }}", new DateTime().minusDays(2).toString());
	}
	
	
	
	
	//TEsts
	public static void main(String[] args) throws IOException{
	//	TokenDao.getNewToken("", "");
		
		/*String newFileName = "mkyong-java-image";
		GridFS gfsPhoto = PlayJongo.gridfs();
		GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
		System.out.println(imageForOutput);
		I f = null;
		imageForOutput.writeTo(f);
		
		JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon((Image)f));
        frame.add(label);
        frame.setVisible(true);*/
		PlayJongo.getCollection("Token").save(new Token("ddddd"));
		//PlayJongo.getCollection("Token").remove("{ dateMaj: { $lt: # }}", new DateTime("2015-04-17T15:36:14.300+02:00").toString());
		
		//System.out.println(new DateTime());
	}

}
