package dao;



import models.Artist;
import modelsmongo.PlayJongo;

public class ArtistDao{
/**
 * Inscription d'un artist
 * @param compte : object Artist à inserer en base
 * @return String correspondant au token
 */
	public String inscriptionArtist(Artist compte){
			PlayJongo.getCollection("Artist").save(compte);
		return (new TokenDao()).getNewToken(compte.getLogin(), compte.getPassword());
	}
	
	/**
	 * Verifie si le login est deja present en base dans la collection Artist
	 * @param login : element à verifier
	 * @return boolean
	 */
	public boolean checkLoginArtist(String login){
		return (PlayJongo.getCollection("Artist").findOne("{login:#}", login).as(Artist.class) == null);
	}
	
	/**
	 * Suppression d'un Artist
	 * @param _id : id de l'artiste à supprimer
	 */
	public void deleteArtist(String _id){
		//A finir
		PlayJongo.getCollection("Artist").remove("{ _id:#}", _id);
	}
	
	
	/**
	 * Recuperation de l'instance Artiste correspondant à un id
	 * @param _id : id de l'artiste
	 * @return 
	 */
	public Artist getArtist(String _id){
		return PlayJongo.getCollection("Artist").findOne("{ _id:#}", _id).as(Artist.class);
	}
	
	/**
	 * Mise à jour d'un compte artiste
	 * @param compte 
	 */
	public void updateArtist(Artist compte){
		PlayJongo.getCollection("Artist").save(compte);
	}
	
	public static void main(String[] args){
		
		//System.out.println(ArtistDao.foundArtist());
		
		//System.out.println(new ObjectId("55240df7ac649850679a4ea5"));
		System.out.println("fin");
	}

	
	
}


