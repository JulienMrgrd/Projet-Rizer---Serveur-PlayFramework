package service;

import java.util.List;

import models.Album;
import models.Artist;
import models.Music;

public interface UtilsServiceInterface {

	
	public List<Artist> searchArtist(String research);
	
	public List<Album> searchAlbum(String research);
	
	public List<Music> searchMusic(String research);
	
	public List<Artist> recommendArtist(Integer idProfil);
	
	public List<Album> recommendAlbum(Integer idProfil);
	
	public List<Music> recommendMusic(Integer idProfil);
	
}
