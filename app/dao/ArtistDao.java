package dao;


import org.bson.types.ObjectId;

import models.Account;
import models.Artist;
import models.Token;
import modelsMongo.PlayJongo;

public class ArtistDao {

	public static String inscriptionArtist(Artist compte){
			PlayJongo.getCollection("Artist").save(compte);
		return TokenDao.getNewToken(compte.getLogin(), compte.getPassword());
	}
	
	
	public static Artist foundArtist(){
		return PlayJongo.getCollection("Artist").findOne().as(Artist.class);
	}
	
	//check si le login passé en paramétre existe deja en base
	public static boolean checkLoginArtist(String login){
		return (PlayJongo.getCollection("Artist").findOne("{login:#}", login).as(Artist.class) == null);
	}
	
	public static void deleteArtist(String _id){
		PlayJongo.getCollection("Artist").remove("{ _id:#}", _id);
	}
	
	public static void main(String[] args){
		
		//System.out.println(ArtistDao.foundArtist());
		
		//System.out.println(new ObjectId("55240df7ac649850679a4ea5"));
		System.out.println("fin");
	}
}


