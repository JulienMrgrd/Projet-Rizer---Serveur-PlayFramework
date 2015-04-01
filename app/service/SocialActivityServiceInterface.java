package service;

public interface SocialActivityServiceInterface {

	public boolean followArtist(Integer idProfil, Integer idArtist);
	
	public boolean unfollowArtist(Integer idProfil, Integer idArtist);
	
	public boolean rizeFuturArtist(Integer idProfil, Integer idFuturArtist);
	
}
