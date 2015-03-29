package service;

public interface SocialActivityServiceInterface {

	/**
	 * Permet à un profil de suivre un artiste.
	 * @param idProfil l'identifiant du profil qui follow
	 * @param idArtist l'identifiant de l'artiste qui est follow
	 * @return vrai si l'opération s'est bien passée
	 */
	public boolean followArtist(Integer idProfil, Integer idArtist);
	
	/**
	 * Permet à un profil de ne plus suivre un artiste.
	 * @param idProfil l'identifiant du profil qui unfollow
	 * @param idArtist l'identifiant de l'artiste qui est unfollow
	 * @return vrai si l'opération s'est bien passée
	 */
	public boolean unfollowArtist(Integer idProfil, Integer idArtist);
	
	/**
	 * Permet à un profil de suivre rizer un "FuturArtist".
	 * @param idProfil l'identifiant du profil qui rize
	 * @param idFuturArtist l'identifiant du FuturArtiste qui se fait rizer
	 * @return vrai si l'opération s'est bien passée
	 */
	public boolean rizeFuturArtist(Integer idProfil, Integer idFuturArtist);
	
}
