package dao;


import org.bson.types.ObjectId;

import models.Artist;
import modelsMongo.PlayJongo;

public class ArtistDao {

	public static void insertNewArtist(){
		Artist testArtiste = new Artist(null, "photo", "surname", "forename", "email", "pseudonym", null, null,
				null, null, null, null, null, null, null);
		
		PlayJongo.getCollection("Artiste").save(testArtiste);
	}
	
	
	public static Artist foundArtist(){
		return PlayJongo.getCollection("Artiste").findOne().as(Artist.class);
	}
	
	public static void main(String[] args){
		ArtistDao.insertNewArtist();
		//System.out.println(ArtistDao.foundArtist());
		
		//System.out.println(new ObjectId("55240df7ac649850679a4ea5"));
		System.out.println("fin");
	}
}


