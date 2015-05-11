package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import models.Account;
import models.Artist;
import models.Playlist;
import models.User;
import dao.AccountDao;
import dao.ArtistDao;
import dao.UserDao;

public class AccountService {

	/**
	 * Inscrit un nouveau User
	 * @param namePhoto url de photo
	 * @param login
	 * @param password
	 * @param email
	 * @param description
	 * @param pseudo
	 * @param photo
	 * @return Id du user cree ou null sinon
	 * @throws IOException
	 */
	public static String subscribeAccountUser(String namePhoto, String login, String password, 
			String email,String description, String pseudo, File photo) throws IOException {
		Account account = new User(null, namePhoto, login, password, pseudo, email, description, new ArrayList<Playlist>(), 
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, new ArrayList<String>());
		return AccountDao.inscription(account,photo);
	}



	/**
	 * Inscrit un Artist qui existe en user
	 * @param accountId du user qui existe deja
	 * @param biography
	 * @param photo
	 * @return Id du user cree ou null sinon
	 * @throws IOException
	 */
	public static String subscribeAccountArtist(String accountId, String biography, File photo) throws IOException {
		User user = UserDao.getUser(accountId);
		Account account = new Artist(user.get_id(), user.getPhoto(), user.getLogin(), user.getPassword(), user.getPassword(),
				user.getEmail(), user.getDescription(), user.getPlaylists(), user.getRises(), user.getFollow(), 
				user.getHistorical(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), biography);
		UserDao.deleteUser(accountId);
		return AccountDao.inscription(account, photo);
	}

	/**
	 * Inscrit un Artist réel
	 * @param namePhoto
	 * @param login
	 * @param password
	 * @param email
	 * @param description
	 * @param pseudo
	 * @param biography
	 * @param photo
	 * @return Id du user cree ou null sinon
	 * @throws IOException
	 */
	public static String subscribeAccountArtist(String namePhoto, String login, String password, 
			String email,String description, String pseudo,String biography, File photo ) throws IOException {

		Account account = new Artist( null,namePhoto, login, password, pseudo, email, description, 
				new ArrayList<Playlist>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), biography);
		return AccountDao.inscription(account, photo);
	}

	/**
	 * Permet de modifier son compte
	 * @param idAccount 
	 * @param account L'objet Account contenant les nouvelles informations
	 */
	public static void modifyAccount(String idAccount, Account account) {
		User user = null;
		user = UserDao.getUser(idAccount);
		if(user!=null){
			if(account.get_id()!=null){
				user.set_id(account.get_id());
			}
			if(account.getPhoto()!=null){
				user.setPhoto(account.getPhoto());
			}
			if(account.getLogin()!=null){
				user.setLogin(account.getLogin());
			}
			if(account.getPassword()!=null){
				user.setPassword(account.getPassword());
			}
			if(account.getPseudo()!=null){
				user.setPseudo(account.getPseudo());
			}
			if(account.getEmail()!=null){
				user.setEmail(account.getEmail());
			}
			if(account.getDescription()!=null){
				user.setDescription(account.getDescription());
			}
			if(account.getPlaylists()!=null){
				user.setPlaylists(account.getPlaylists());
			}
			if(account.getRises()!=null){
				user.setRises(account.getRises());
			}
			if(account.getFollow()!=null){
				user.setFollow(account.getFollow());
			}
			if(account.getHistorical()!=null){
				user.setHistorical(account.getHistorical());
			}
			UserDao.updateUser(user);
		}else{
			Artist artist = ArtistDao.getArtist(idAccount);
			if(account.get_id()!=null){
				artist.set_id(account.get_id());
			}
			if(account.getPhoto()!=null){
				artist.setPhoto(account.getPhoto());
			}
			if(account.getLogin()!=null){
				artist.setLogin(account.getLogin());
			}
			if(account.getPassword()!=null){
				artist.setPassword(account.getPassword());
			}
			if(account.getPseudo()!=null){
				artist.setPseudo(account.getPseudo());
			}
			if(account.getEmail()!=null){
				artist.setEmail(account.getEmail());
			}
			if(account.getDescription()!=null){
				artist.setDescription(account.getDescription());
			}
			if(account.getPlaylists()!=null){
				artist.setPlaylists(account.getPlaylists());
			}
			if(account.getRises()!=null){
				artist.setRises(account.getRises());
			}
			if(account.getFollow()!=null){
				artist.setFollow(account.getFollow());
			}
			if(account.getHistorical()!=null){
				artist.setHistorical(account.getHistorical());
			}
			ArtistDao.updateArtist(artist);
		}
	}


	/**
	 * Permet de voir un Account (tous les attributs ne seront pas renseignés)
	 * @param idAccount id du Account à voir
	 * @return User ou Artist
	 */
	public static Account visualizeAccount(String idAccount) {
		User user = null;
		user = UserDao.getUser(idAccount);
		if(user!=null){
			return user;
		}else{
			Artist artist = ArtistDao.getArtist(idAccount);
			return artist;
		}
	}


	/**
	 * Permet de se desinscrire
	 * @param idAccount id du Account a supprimer
	 * @return true si Ok, false sinon
	 */
	public static void deleteAccount(String idAccount) {
		// TODO finir selon playlist
		UserDao.deleteUser(idAccount);
	}

	/**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param user id du Account a promouvoir
	 * @return true si Ok, false sinon
	 */
	public static boolean becomeArtist(String idAccount) {
		User user = UserDao.getUser(idAccount);
		if(user.isfuturArtist()){
			return false;
		}else{
			user.setfuturArtist(true);
			UserDao.updateUser(user);
			return true;
		}
	}

	/**
	 * Transforme un User en Artist (le client n'appelle pas cette méthode, c'est un daemon
	 * qui le fait)
	 */
	public static Artist transformToArtist(String idUser) {
		User user = UserDao.getUser(idUser);
		Artist artist = new Artist(user);
		UserDao.deleteUser(idUser);
		ArtistDao.updateArtist(artist);
		return artist;
	}

}
