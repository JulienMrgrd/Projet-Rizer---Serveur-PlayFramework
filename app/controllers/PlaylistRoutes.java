package controllers;

import models.Playlist;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class PlaylistRoutes extends Controller{
	
    public static Result createOnePlaylist(String UUID, Playlist playlist){ 
    	return ok(index.render("Your new application is ready.")); }

	public static Result modifyInfosOnePlaylist(String UUID, Playlist playlist){ 
		return ok(index.render("Your new application is ready.")); } 
	
	public static Result deleteOnePlaylist(String UUID, Integer idPlaylist){ 
		return ok(index.render("Your new application is ready.")); }
	
	public static Result addMusicToPlaylist(String UUID, Integer idPlaylist, int musicID){ 
		return ok(index.render("Your new application is ready.")); }
	
	public static Result deleteMusicToPlaylist(String UUID, Integer idPlaylist, int musicID){ 
		return ok(index.render("Your new application is ready.")); }
	
	public static Result visualizeOnePlaylist(String UUID, Integer idPlaylist){
		return ok(index.render("Your new application is ready."));
	}

}
