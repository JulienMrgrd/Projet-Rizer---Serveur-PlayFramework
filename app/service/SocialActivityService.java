package service;

import models.Artist;
import models.User;
import dao.ArtistDao;
import dao.UserDao;

public class SocialActivityService{

	public SocialActivityService(){
		
	}
	
	/**
	 * Permet a un compte de suivre un artiste.
	 * @param idAccount l'identifiant du compte qui follow
	 * @param idArtist l'identifiant de l'artiste qui est follow
	 * @return vrai si OK, false sinon
	 */
	public boolean followArtist(String idAccount, String idArtist) {
		boolean follow = false;
		User user = null;
		UserDao userDao = new UserDao();
		user = userDao.getUser(idAccount);
		if(user!=null){
			user.getFollow().add(idArtist);
			userDao.updateUser(user);
			follow = true;
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			artist.getFollow().add(idArtist);
			artistDao.updateArtist(artist);
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
	public boolean unfollowArtist(String idAccount, String idArtist) {
		boolean remove = false;
		User user = null;
		UserDao userDao = new UserDao();
		user = userDao.getUser(idAccount);
		if(user!=null){
			for(int i = 0; i<user.getFollow().size() && remove!=true; i++){
				if(user.getFollow().get(i).equals(idArtist)){
					user.getFollow().remove(i);
					remove = true;
				}
			}
			userDao.updateUser(user);
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			for(int i = 0; i<artist.getFollow().size() && remove!=true; i++){
				if(artist.getFollow().get(i).equals(idArtist)){
					artist.getFollow().remove(i);
					remove = true;
				}
			}
			artistDao.updateArtist(artist);
		}
		return remove;
	}

	/**
	 * Permet a un compte de rizer un FuturArtist.
	 * @param idAccount l'identifiant du compte qui rize
	 * @param idUser l'identifiant du FuturArtiste qui se fait rizer
	 * @return vrai si OK, false sinon
	 */
	public boolean rizeFuturArtist(String idAccount, String idUser) {
		boolean rize = false;
		User user = null;
		UserDao userDao = new UserDao();
		user = userDao.getUser(idAccount);
		User rizer = userDao.getUser(idUser);
		if(user!=null){
			user.getRises().add(idUser);
			userDao.updateUser(user);
			rizer.getRizeGet().add(idAccount);
			userDao.updateUser(rizer);
			rize = true;
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			artist.getRises().add(idUser);
			artistDao.updateArtist(artist);
			rizer.getRizeGet().add(idAccount);
			userDao.updateUser(rizer);
			rize = true;
		}
		return rize;
	}

}
