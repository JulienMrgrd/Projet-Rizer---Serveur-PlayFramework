package testDao;

import static org.junit.Assert.*;
import models.Artist;

import org.junit.Before;
import org.junit.Test;

import dao.ArtistDao;

public class ArtistDaoTest {
	
	ArtistDao artistDao;
	
	@Before
	public void setUp(){
		artistDao = new ArtistDao();
	}

	@Test
	public void testInscriptionArtist(){
		Artist artist = null;
		artist = artistDao.getArtist("artist");
		assertNull(artist);
		artist = new Artist("login","pass","mail","pseudo");
		artist.set_id("artist");
		artistDao.inscriptionArtist(artist);
		artist = null;
		artist = artistDao.getArtist("artist");
		assertNotNull(artist);
		assertEquals(artist.getLogin(),"login");
		artistDao.deleteArtist("artist");
	}
	
	@Test
	public void testCheckLoginArtistFalse(){
		Artist artist = null;
		artist = artistDao.getArtist("artist");
		assertNull(artist);
		artist = new Artist("login","pass","mail","pseudo");
		artist.set_id("artist");
		artistDao.inscriptionArtist(artist);
		boolean res = artistDao.checkLoginArtist("login");
		assertFalse(res);
		artistDao.deleteArtist("artist");
	}
	
	@Test
	public void testCheckLoginArtistTrue(){
		boolean res = artistDao.checkLoginArtist("afjzekjfer");
		assertTrue(res);
	}
	
	@Test
	public void testGetArtist(){
		Artist artist = null;
		artist = artistDao.getArtist("artist");
		assertNull(artist);
		artist = new Artist("login","pass","mail","pseudo");
		artist.set_id("artist");
		artistDao.inscriptionArtist(artist);
		artist = artistDao.getArtist("artist");
		assertNotNull(artist);
		assertEquals(artist.getLogin(),"login");
		artistDao.deleteArtist("artist");
	}
	
	@Test
	public void testUpdateArtist(){
		Artist artist = null;
		artist = artistDao.getArtist("artist");
		assertNull(artist);
		artist = new Artist("login","pass","mail","pseudo");
		artist.set_id("artist");
		artistDao.inscriptionArtist(artist);
		artist = artistDao.getArtist("artist");
		assertEquals(artist.getLogin(),"login");
		artist.setLogin("update");
		artistDao.updateArtist(artist);
		artist = artistDao.getArtist("artist");
		assertEquals(artist.getLogin(),"update");
		artistDao.deleteArtist("artist");
	}
	
	@Test
	public void testDelete(){
		Artist artist = null;
		artist = artistDao.getArtist("artist");
		assertNull(artist);
		artist = new Artist("login","pass","mail","pseudo");
		artist.set_id("artist");
		artistDao.inscriptionArtist(artist);
		artist = artistDao.getArtist("artist");
		assertNotNull(artist);
		artistDao.deleteArtist("artist");
		artist = null;
		artist = artistDao.getArtist("artist");
		assertNull(artist);

		
	}
	
}
