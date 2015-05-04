package dao;

import java.io.File;

import org.joda.time.DateTime;

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
	
	public static User getArtist(String _id){
		return PlayJongo.getCollection("User").findOne("{ _id:#}", _id).as(User.class);
	}

}
