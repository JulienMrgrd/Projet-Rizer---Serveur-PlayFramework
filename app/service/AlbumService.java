package service;

import java.util.ArrayList;

import models.Album;
import dao.AlbumDao;

public class AlbumService {

	public AlbumService(){

	}

	/**
	 * Creer un album et l'ajoute en base
	 * @param title
	 * @param artist
	 * @return Album creer
	 */
	public Album createAlbum(String title, String IdArtist){
		Album album = new Album(null, title, new ArrayList<String>(), IdArtist);
		AlbumDao albumDao = new AlbumDao();
		albumDao.addAlbum(album);
		return album;
	}

	/**
	 * Visualiser l'album
	 * @param idAlbum
	 * @return l'album a visualiser
	 */
	public Album visualizeAlbum(String idAlbum){
		AlbumDao albumDao = new AlbumDao();
		Album album = albumDao.getAlbum(idAlbum);
		return album;
	}

	/**
	 * Ajouter music a un album
	 * @param idAlbum
	 * @param idMusic
	 * @return true si ok sinon false
	 */
	public boolean addMusicAlbum(String idAlbum, String idMusic){
		AlbumDao albumDao = new AlbumDao();
		Album album = albumDao.getAlbum(idAlbum);
		if(album.getTracks().size()>0){
			for(int i = 0; i<album.getTracks().size();i++){
				if(album.getTracks().get(i).equals(idMusic)){
					return false;
				}
			}
		}
		album.getTracks().add(idMusic);
		albumDao.updateAlbum(album);
		return true;
	}
	
	/**
	 * Enleve music a un album
	 * @param idAlbum
	 * @param idMusic
	 * @return true si ok false sinon
	 */
	public boolean removeMusicAlbum(String idAlbum, String idMusic){
		AlbumDao albumDao = new AlbumDao();
		Album album = albumDao.getAlbum(idAlbum);
		if(album.getTracks().size()>0){
			for(int i = 0; i<album.getTracks().size(); i++){
				if(album.getTracks().get(i).equals(idMusic)){
					album.getTracks().remove(i);
					albumDao.updateAlbum(album);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Modifie les parametres d'un album
	 * @param idAlbum
	 * @param album
	 */
	public void modifyAlbum(String idAlbum, Album album){
		AlbumDao albumDao = new AlbumDao();
		Album albumBase = albumDao.getAlbum(idAlbum);
		if(album.getTitle()!=null){
			albumBase.setTitle(album.getTitle());
		}
		if(album.getTracks()!=null){
			albumBase.setTracks(album.getTracks());
		}
		if(album.getArtist()!=null){
			albumBase.setArtist(album.getArtist());
		}
		albumDao.updateAlbum(albumBase);
	}
	
	/**
	 * Supprime un album
	 * @param idAlbum
	 */
	public void deleteAlbum (String idAlbum){
		AlbumDao albumDao = new AlbumDao();
		albumDao.deleteAlbum(idAlbum);
	}
}
