package service;

import java.util.List;

import models.Artist;
import models.Profil;

public class ProfilService implements ProfilServiceInterface {

	@Override
	public Profil connection(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer subscribeUser(String surname, String forename, String email,
			String pseudonym) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist subscribeArtist(String surname, String forename,
			String email, String pseudonym, List<Integer> playlists,
			List<Integer> rises, List<Integer> follow, List<Integer> historical) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unsubscribe(Integer idProfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void becomeArtist(Integer idProfil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyProfil(Integer idProfil, Profil profil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seeProfil(Integer idProfil) {
		// TODO Auto-generated method stub
		
	}


}
