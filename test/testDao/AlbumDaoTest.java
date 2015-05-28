package testDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import models.Album;

import org.junit.Before;
import org.junit.Test;

import dao.AlbumDao;
public class AlbumDaoTest {

	AlbumDao albumDao;

	@Before
	public void setUp()  {
		albumDao = new AlbumDao();
	}

	@Test
	public void testAddAlbum(){
		Album album = null;
		album = albumDao.getAlbum("albumTest");
		assertNull(album);
		album = new Album("albumTest", "titleAlbum",new ArrayList<String>(), "artistName");
		boolean res = albumDao.addAlbum(album);
		assertTrue(res);
		album = albumDao.getAlbum("albumTest");
		assertNotNull(album);
		albumDao.deleteAlbum("albumTest");
	}

	@Test
	public void testGetAlbum(){
		Album album = null;
		album = albumDao.getAlbum("albumTest");
		assertNull(album);
		album = new Album("albumTest", "titleAlbum",new ArrayList<String>(), "artistName");
		albumDao.addAlbum(album);
		album = albumDao.getAlbum("albumTest");
		assertNotNull(album);
		albumDao.deleteAlbum("albumTest");
	}

//	@Test 
//	public void testGetAlbumByName(){
//		List<Album> list = null;
//		list = albumDao.getAlbumsByName("titleAlbum");
//		assertEquals(list.size(), 0);
//		Album album = new Album("albumTest", "titleAlbum",new ArrayList<String>(), "artistName");
//		albumDao.addAlbum(album);
//		list = albumDao.getAlbumsByName("titleAlbum");
//		assertNotNull(list);
//		assertEquals(list.size(), 1);
//		albumDao.deleteAlbum("albumTest");
//	}

	@Test 
	public void testUpdateAlbum(){
		Album album = null;
		album = albumDao.getAlbum("albumTest");
		assertNull(album);
		album = new Album("albumTest", "titleAlbum",new ArrayList<String>(), "artistName");
		albumDao.addAlbum(album);
		album = albumDao.getAlbum("albumTest");
		assertEquals(album.getTitle(),"titleAlbum");
		album.setTitle("update");
		albumDao.updateAlbum(album);
		album = albumDao.getAlbum("albumTest");
		assertEquals(album.getTitle(), "update");
		albumDao.deleteAlbum("albumTest");
	}

	@Test
	public void testDeleteAlbum(){
		Album album = null;
		album = albumDao.getAlbum("albumTest");
		assertNull(album);
		album = new Album("albumTest", "titleAlbum",new ArrayList<String>(), "artistName");
		albumDao.addAlbum(album);
		album = albumDao.getAlbum("albumTest");
		assertNotNull(album);
		albumDao.deleteAlbum("albumTest");
		album = null;
		album = albumDao.getAlbum("albumTest");
		assertNull(album);
	}

}
