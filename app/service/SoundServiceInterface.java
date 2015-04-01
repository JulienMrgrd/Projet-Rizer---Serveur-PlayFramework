package service;

import models.Music;

public interface SoundServiceInterface {

	
	public boolean addMusic(Integer idProfil, Music music);
	
	public boolean modifyInfoSound(Integer idProfil, Music music);
	
	public boolean deleteMusic(Integer idProfil, Integer idMusic);
	
	public boolean likerMusic(Integer idProfil, Integer idMusic);
	
	public boolean commentMusic(Integer idProfil, Integer idMusic, String comment);
	
}
