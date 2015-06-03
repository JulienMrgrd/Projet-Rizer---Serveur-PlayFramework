package service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import models.Artist;
import models.Music;
import models.User;
import dao.ArtistDao;
import dao.MusicDao;
import dao.UserDao;

public class MusicService{

	public MusicService(){

	}

	/**
	 * Ajoute une musique en base
	 * @param file File de la music
	 * @param music le fichier a uploader
	 * @throws IOException 
	 */
	public void addMusic(File file, Music music) throws IOException {
		MusicDao musicDao = new MusicDao();
		musicDao.addMusic(file, music);
		
	}

	/**
	 * Remplace les informations d'une musique en base, si elle existe et qu'elle appartient a ce compte
	 * @param idAccount l'id du compte (Artist ou FuturArtist) qui change les informations de la musique
	 * @param music la musique a remplacer
	 * @return vrai si l'operation s'est bien passee
	 */
	public void modifyInfoMusic(String idMusic, Music music) {
		MusicDao musicDao = new MusicDao();
		Music musicBase = musicDao.getMusic(idMusic);
		if(music.getName()!=null){
			musicBase.setName(music.getName());
		}
		if(music.getFileId()!=null){
			musicBase.setFileId(music.getFileId());
		}
		if(music.getLike()!=null){
			musicBase.setLike(music.getLike());
		}
		if(music.getComment()!=null){
			musicBase.setComment(music.getComment());
		}
		if(music.getTags()!=null){
			musicBase.setTags(music.getTags());
		}
		if(music.getDuration()!=null){
			musicBase.setDuration(music.getDuration());
		}
		musicDao.updateMusic(musicBase);
	}

	/**
	 * Supprime la musique en base
	 * @param idMusic l'id de la musique a supprimer
	 */
	public void deleteMusic(String idMusic) {
		MusicDao musicDao = new MusicDao();
		musicDao.deleteMusic(idMusic);
	}

	/**
	 * Ajoute un like a la music
	 * @param idAccount l'id du compte qui like la musique
	 * @param idMusic l'id de la musique like
	 * @return vrai si l'operation s'est bien passee.
	 */
	public boolean likerMusic(String idAccount, String idMusic) {
		MusicDao musicDao = new MusicDao();
		Music music = musicDao.getMusic(idMusic);
		if(music==null)
			return false;
		if(music.getLike()==null){
			music.setLike(new ArrayList<String>());
		}else{
			if(music.getLike().contains(idAccount))
				return false;
		}
		
		musicDao.addLike(idMusic, idAccount);
		return true;
	}

	/**
	 * Ajoute un commentaire a une musique
	 * @param idAccount l'id du compte qui commente
	 * @param idMusic l'id de la musique qui est commentee
	 * @param comment le commentaire
	 */
	public void commentMusic(String idAccount, String idMusic,
			String comment) {
		User user = null;
		UserDao userDao = new UserDao();
		MusicDao musicDao = new MusicDao();
		Music music = musicDao.getMusic(idMusic);
		user = userDao.getUser(idAccount);
		if(user!=null){
			music.getComment().put(user.getPseudo(), comment);
			musicDao.updateMusic(music);
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			music.getComment().put(artist.getPseudo(), comment);
			musicDao.updateMusic(music);
		}
	}

	/**
	 * Permet à l'utilisateur d'écouter une musique
	 * @param idMusic l'id de la musique qui est commentee
	 * @return InputStream de la music
	 */
	public InputStream listenMusic(String idMusic) {
		InputStream music = null;
		MusicDao musicDao = new MusicDao();
		music = musicDao.getInputStreamMusic(idMusic);
		return music;	
	}
	
	
	/**
	 * Retourne la musique, sans le fichier
	 * @param idMusic
	 * @return
	 */
	public Music vizualizeMusic(String idMusic){
		MusicDao musicDao = new MusicDao();
		return musicDao.getMusic(idMusic);
	}

	public List<Music> findAllMusics() {
		MusicDao dao = new MusicDao();
		return dao.findAll();
	}
	
	public Music infoMusic(String idMusic) {
		MusicDao musicDao = new MusicDao();
		Music music = musicDao.getMusic(idMusic);
		return music;
	}

	
}
