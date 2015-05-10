package service;

import models.Artist;
import models.User;
import dao.ArtistDao;
import dao.UserDao;

public class SocialActivityService{

	/**
	 * Permet a un compte de suivre un artiste.
	 * @param idAccount l'identifiant du compte qui follow
	 * @param idArtist l'identifiant de l'artiste qui est follow
	 * @return vrai si OK, false sinon
	 */
	public static boolean followArtist(String idAccount, String idArtist) {
		boolean follow = false;
		User user = null;
		user = UserDao.getArtist(idAccount);
		if(user!=null){
			user.getFollow().add(idArtist);
			UserDao.inscriptionUser(user);
			follow = true;
		}else{
			Artist artist = ArtistDao.getArtist(idAccount);
			artist.getFollow().add(idArtist);
			ArtistDao.inscriptionArtist(artist);
			follow = true;
		}
		return follow;
	}

	/**
	 * Permet a un compte de ne plus suivre un artiste.
	 * @param idAccount l'identifiant du compte qui unfollow
	 * @param idArtist l'identifiant de l'artiste qui est unfollow
	 * @return vrai si OK, false sinon
	 */
	public static boolean unfollowArtist(String idAccount, String idArtist) {
		boolean remove = false;
		User user = null;
		user = UserDao.getArtist(idAccount);
		if(user!=null){
			for(int i = 0; i<user.getFollow().size() && remove!=true; i++){
				if(user.getFollow().get(i).equals(idArtist)){
					user.getFollow().remove(i);
					remove = true;
				}
			}
			UserDao.inscriptionUser(user);
		}else{
			Artist artist = ArtistDao.getArtist(idAccount);
			for(int i = 0; i<artist.getFollow().size() && remove!=true; i++){
				if(artist.getFollow().get(i).equals(idArtist)){
					artist.getFollow().remove(i);
					remove = true;
				}
			}
			ArtistDao.inscriptionArtist(artist);
		}
		return remove;
	}

	/**
	 * Permet a un compte de rizer un FuturArtist.
	 * @param idAccount l'identifiant du compte qui rize
	 * @param idUser l'identifiant du FuturArtiste qui se fait rizer
	 * @return vrai si OK, false sinon
	 */
	public static boolean rizeFuturArtist(String idAccount, String idUser) {
		boolean rize = false;
		User user = null;
		user = UserDao.getArtist(idAccount);
		User rizer = UserDao.getArtist(idUser);
		if(user!=null){
			user.getRises().add(idUser);
			UserDao.inscriptionUser(user);
			rizer.getRizeGet().add(idAccount);
			UserDao.inscriptionUser(rizer);
			rize = true;
		}else{
			Artist artist = ArtistDao.getArtist(idAccount);
			artist.getRises().add(idUser);
			ArtistDao.inscriptionArtist(artist);
			rizer.getRizeGet().add(idAccount);
			UserDao.inscriptionUser(rizer);
			rize = true;
		}
		return rize;
	}

}
