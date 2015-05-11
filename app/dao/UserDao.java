package dao;



import models.*;
import modelsMongo.PlayJongo;

public class UserDao {

	public static String inscriptionUser(User compte){
		PlayJongo.getCollection("User").save(compte);
		return TokenDao.getNewToken(compte.getLogin(), compte.getPassword());
	}

	public static boolean checkLoginUser(String login){
		return (PlayJongo.getCollection("User").findOne("{login:#}", login).as(Artist.class) == null);
	}
	
	
	
	public static void deleteUser(String _id){
		//A finir selon la supression de playlist
		PlayJongo.getCollection("User").remove("{ _id:#}", _id);
	}
	
	public static User getUser(String _id){
		return PlayJongo.getCollection("User").findOne("{ _id:#}", _id).as(User.class);
	}
	
	public static void updateUser(User compte){
		PlayJongo.getCollection("User").save(compte);
	}
}
