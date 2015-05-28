package testDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import models.User;

import org.junit.Before;
import org.junit.Test;

import dao.UserDao;

public class UserDaoTest {
	
	UserDao userDao;
	
	@Before
	public void setUp() {
		userDao = new UserDao();
	}
	
	@Test
	public void testInscriptionUser(){
		User user = new User("login", "password", "pseudo", "mail");
		user.set_id("user");
		userDao.inscriptionUser(user);
		user = null;
		user = userDao.getUser("user");
		assertNotNull(user);
		assertEquals(user.getLogin(),"login");
		userDao.deleteUser("user");
	}
	
	@Test
	public void testCheckLoginUserFalse(){
		User user = new User("login", "password", "pseudo", "mail");
		user.set_id("user");
		userDao.inscriptionUser(user);
		boolean res = userDao.checkLoginUser("login");
		assertFalse(res);
		userDao.deleteUser("user");
	}
	
	@Test
	public void testCheckLoginUserTrue(){
		boolean res = userDao.checkLoginUser("abcderfg");
		assertTrue(res);
	}
	
	@Test
	public void testGetUser(){
		User user = new User("login", "password", "pseudo", "mail");
		user.set_id("user");
		userDao.inscriptionUser(user);
		user = userDao.getUser("user");
		assertNotNull(user);
		assertEquals(user.getLogin(), "login");
		userDao.deleteUser("user");
	}
	
	@Test
	public void testUpdateUser(){
		User user = new User("login", "password", "pseudo", "mail");
		user.set_id("user");
		userDao.inscriptionUser(user);
		user.setLogin("update");
		userDao.updateUser(user);
		user = userDao.getUser("user");
		assertEquals(user.getLogin(), "update");
		userDao.deleteUser("user");
	}
	
	@Test
	public void testDelete(){
		User user = null;
		user = userDao.getUser("user");
		assertNull(user);
		user = new User("login", "password", "pseudo", "mail");
		user.set_id("user");
		userDao.inscriptionUser(user);
		user = userDao.getUser("user");
		assertNotNull(user);
		userDao.deleteUser("user");
		user = userDao.getUser("user");
		assertNull(user);
	}
}
