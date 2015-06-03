package dao;

import java.util.Iterator;
import java.util.List;

import models.Album;
import models.Artist;
import models.Playlist;
import modelsmongo.PlayJongo;


public class AlbumDao extends Dao{
	
	/**
	 * Ajoute un ablbum dans la collection "Album"
	 * @param albumTmp
	 */
	public boolean addAlbum(Album albumTmp){
		if(PlayJongo.getCollection("Album").findOne("{title:#, idartist:#}", albumTmp.getTitle(), albumTmp.getArtist()).as(Playlist.class) == null){
			PlayJongo.getCollection("Album").save(albumTmp);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Supprime l'album d'identifiant _id
	 * @param _id
	 */
	public void deleteAlbum(String _id){
		Album albumTmp=PlayJongo.getCollection("Album").findOne("{_id:#}", _id).as(Album.class);
		for(String id : albumTmp.getTracks()){
			(new MusicDao()).deleteMusic(id);
		}
		PlayJongo.getCollection("Album").remove("{ _id:#}", _id);
		
		
		
	}

	public Album getAlbum(String _idAlbum) {
		return PlayJongo.getCollection("Album").findOne("{_id:#}", _idAlbum).as(Album.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> getAlbumsContainsName(String title){
		Iterator<Album> m= PlayJongo.getCollection("Album").find("{title:{$regex:\""+title+"\", $options: 'i' }}").as(Album.class).iterator();
		return PlayJongo.toArray(m);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> getAlbumsByName(String name){
		Iterator<Album> m= PlayJongo.getCollection("Album").find("{name:#}", name).as(Album.class).iterator();
		return PlayJongo.toArray(m);
	}

	public void updateAlbum(Album albumTmp) {
		PlayJongo.getCollection("Album").save(albumTmp);
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> findAll(){
		Iterator<Album> m= PlayJongo.getCollection("Album").find().as(Album.class).iterator();
		return PlayJongo.toArray(m);
	}

}
