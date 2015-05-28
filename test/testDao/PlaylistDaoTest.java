package testDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import models.Playlist;

import org.junit.Before;
import org.junit.Test;

import dao.PlaylistDao;

public class PlaylistDaoTest {

	PlaylistDao playlistDao;
	
	@Before
	public void setUp(){
		playlistDao = new PlaylistDao();
	}
	
	@Test
	public void testAddPlaylist(){
		Playlist playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNull(playlist);
		playlist = new Playlist("accountid", new ArrayList<String>(), "name", "description");
		playlist.set_id("playlist");
		boolean res = playlistDao.addPlaylist(playlist);
		assertTrue(res);
		playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNotNull(playlist);
		playlistDao.deletePlaylist("playlist");
	}
	
	@Test
	public void testAddMusicToPlayList(){
		Playlist playlist = new Playlist("accountid", new ArrayList<String>(), "name", "description");
		playlist.set_id("playlist");
		playlistDao.addPlaylist(playlist);
		playlistDao.addMusicToPlaylist("playlist","idMusic");
		playlist = playlistDao.getPlaylist("playlist");
		assertEquals(playlist.getListMusics().get(0), "idMusic");
		playlistDao.deletePlaylist("playlist");
	}
	
	@Test
	public void testUpdatePlaylist(){
		Playlist playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNull(playlist);
		playlist = new Playlist("accountid", new ArrayList<String>(), "name", "description");
		playlist.set_id("playlist");
		playlistDao.addPlaylist(playlist);
		playlist = playlistDao.getPlaylist("playlist");
		assertEquals(playlist.getName(),"name");
		playlist.setName("update");
		playlistDao.updatePlaylist(playlist);
		playlist = playlistDao.getPlaylist("playlist");
		assertEquals(playlist.getName(), "update");
		playlistDao.deletePlaylist("playlist");
		
	}
	
	@Test
	public void testGetPlaylist(){
		Playlist playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNull(playlist);
		playlist = new Playlist("accountid", new ArrayList<String>(), "name", "description");
		playlist.set_id("playlist");
		boolean res = playlistDao.addPlaylist(playlist);
		assertTrue(res);
		playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNotNull(playlist);
		playlistDao.deletePlaylist("playlist");
	}
	
	@Test
	public void testFindPlaylistByNameAndIdAccount(){
		Playlist playlist = null;
		playlist = playlistDao.findPlaylistbyNameAndIdAccount("name", "accountid");
		assertNull(playlist);
		playlist = new Playlist("accountid", new ArrayList<String>(), "name", "description");
		playlist.set_id("playlist");
		boolean res = playlistDao.addPlaylist(playlist);
		assertTrue(res);
		playlist = null;
		playlist = playlistDao.findPlaylistbyNameAndIdAccount("name", "accountid");
		assertNotNull(playlist);
		playlistDao.deletePlaylist("playlist");
	}
	
	@Test
	public void testDelete(){
		Playlist playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNull(playlist);
		playlist = new Playlist("accountid", new ArrayList<String>(), "name", "description");
		playlist.set_id("playlist");
		boolean res = playlistDao.addPlaylist(playlist);
		assertTrue(res);
		playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNotNull(playlist);
		playlistDao.deletePlaylist("playlist");
		playlist = null;
		playlist = playlistDao.getPlaylist("playlist");
		assertNull(playlist);
	}
}
