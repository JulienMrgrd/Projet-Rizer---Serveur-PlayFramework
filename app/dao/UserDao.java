package dao;



import java.util.List;
import java.util.Iterator;

import models.*;
import modelsmongo.PlayJongo;

public class UserDao extends Dao {

	public String inscriptionUser(User compte){
		PlayJongo.getCollection("User").save(compte);
		return (new TokenDao()).getNewToken(compte.getLogin(), compte.getPassword());
	}

	public boolean checkLoginUser(String login){
		return (PlayJongo.getCollection("User").findOne("{login:#}", login).as(Artist.class) == null);
	}
	
	
	
	public void deleteUser(String _id){
		//A finir selon la supression de playlist
		PlayJongo.getCollection("User").remove("{ _id:#}", _id);
	}
	
	public User getUser(String _id){
		return PlayJongo.getCollection("User").findOne("{ _id:#}", _id).as(User.class);
	}
	
	public void updateUser(User compte){
		PlayJongo.getCollection("User").save(compte);
	}
	
	public List<User> findAllFutursArtistes(){
		Iterator<User> i=PlayJongo.getCollection("User").find("{ futurArtist:#}", true).as(User.class).iterator();
		return PlayJongo.toArray(i);
		
	}
}
