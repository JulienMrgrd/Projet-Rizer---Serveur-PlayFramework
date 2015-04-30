package dao;

import models.*;
import modelsMongo.PlayJongo;

public class PlaylistDao {

	public static boolean addPlaylist(Playlist p){
		if(PlayJongo.getCollection("Playlist").findOne("{name:#}", p.getName()).as(Playlist.class) == null){
			PlayJongo.getCollection("Playlist").save(p);
			return true;
		}else{
			return false;
		}
			

	}

	public static void modifyPlaylist(Playlist p){
		PlayJongo.getCollection("Playlist").save(p);

	}


	public static void deletePlaylist(String _id){
		PlayJongo.getCollection("Playlist").remove(_id);
	}
	
	public static Playlist findPlaylistbyName(String name){
		return PlayJongo.getCollection("Playlist").findOne("{name:#}", name).as(Playlist.class);
	}


}
