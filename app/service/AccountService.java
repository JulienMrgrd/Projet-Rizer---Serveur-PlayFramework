package service;

import java.io.IOException;
import java.util.List;

import models.Account;
import models.Artist;
import models.User;
import dao.AccountDao;
import dao.ArtistDao;
import dao.UserDao;

public class AccountService {

	public AccountService(){
		
	}
	
	/**
	 * Inscrit un nouveau User
	 * @param namePhoto url de photo
	 * @param login
	 * @param password
	 * @param email
	 * @param description
	 * @param pseudo
	 * @param photo
	 * @return uuid
	 * @throws IOException
	 */
	public String subscribeAccountUser(String login, String password, String pseudo, String mail) {
		AccountDao accountDao = new AccountDao();
		Account account = new User(login, password, pseudo, mail);
		return accountDao.inscription(account);
	}



	/**
	 * Inscrit un Artist qui existe en user
	 * @param accountId du user qui existe deja
	 * @return Id du user cree ou null sinon
	 */
	public String subscribeAccountArtist(String accountId) {
		AccountDao accountDao = new AccountDao();
		UserDao userDao = new UserDao();
		User user = userDao.getUser(accountId);
		Account account = new Artist(user);
		userDao.deleteUser(accountId);
		return accountDao.inscription(account);
	}

	/**
	 * Inscrit un Artist réel
	 * @param login
	 * @param password
	 * @param email
	 * @param pseudo
	 * @return Id de l'artiste cree ou null sinon
	 */
	public String subscribeAccountArtist(String login, String password, String pseudo, String mail ) {
		AccountDao accountDao = new AccountDao();
		Account account = new Artist( login, password, pseudo, mail );
		return accountDao.inscription(account);
	}

	/**
	 * Permet de modifier son compte
	 * @param idAccount 
	 * @param account L'objet Account contenant les nouvelles informations
	 */
	public void modifyAccount(String idAccount, Account account) {
		User user = null;
		UserDao userDao = new UserDao();
		user = userDao.getUser(idAccount);
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
			userDao.updateUser(user);
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
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
			artistDao.updateArtist(artist);
		}
	}


	/**
	 * Permet de voir un Account (tous les attributs ne seront pas renseignés)
	 * @param idAccount id du Account à voir
	 * @return User ou Artist
	 */
	public Account visualizeAccount(String idAccount) {
		User user = null;
		UserDao userDao = new UserDao();
		user = userDao.getUser(idAccount);
		if(user!=null){
			user.setEmail(null);
			user.setLogin(null);
			user.setPassword(null);
			return user;
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			artist.setEmail(null);
			artist.setLogin(null);
			artist.setPassword(null);
			return artist;
		}
	}
	
	public Account visualizeMyAccount(String idAccount) {
		User user = null;
		UserDao userDao = new UserDao();
		user = userDao.getUser(idAccount);
		if(user!=null){
			user.setPassword(null);
			return user;
		}else{
			ArtistDao artistDao = new ArtistDao();
			Artist artist = artistDao.getArtist(idAccount);
			artist.setPassword(null);
			return artist;
		}
	}


	/**
	 * Permet de se desinscrire
	 * @param idAccount id du Account a supprimer
	 * @return true si Ok, false sinon
	 */
	public void deleteAccount(String idAccount) {
		// TODO finir selon playlist
		UserDao userDao = new UserDao();
		userDao.deleteUser(idAccount);
	}

	/**
	 * Permet d'entrer dans la phase pour devenir artist
	 * @param user id du Account a promouvoir
	 * @return true si Ok, false sinon
	 */
	public boolean becomeArtist(String idAccount) {
		UserDao userDao = new UserDao();
		User user = userDao.getUser(idAccount);
		if(user.isfuturArtist()){
			return false;
		}else{
			user.setfuturArtist(true);
			userDao.updateUser(user);
			return true;
		}
	}

	/**
	 * Transforme un User en Artist (le client n'appelle pas cette méthode, c'est un daemon
	 * qui le fait)
	 */
	public Artist transformToArtist(String idUser) {
		UserDao userDao = new UserDao();
		ArtistDao artistDao = new ArtistDao();
		User user = userDao.getUser(idUser);
		Artist artist = new Artist(user);
		userDao.deleteUser(idUser);
		artistDao.updateArtist(artist);
		return artist;
	}

	public List<Artist> findAllArtists() {
		ArtistDao dao = new ArtistDao();
		return dao.findAll();
	}
	
	public List<User> findAllFutursArtists() {
		UserDao dao = new UserDao();
		return dao.findAllFutursArtistes();
	}

}
