package dao;

import model.user.Role;
import model.user.User;

import org.junit.Assert;
import org.junit.Test;

public class DaoImplTest extends Assert {

	@Test
	public void testSaveEntity() {
		DaoImpl daoImpl = new DaoImpl();
		User user = new User();
		user.setLogin("admin");
		user.setPassword("admin");
		user.setRole(Role.ADMIN);
		daoImpl.saveEntity(user);
	}

}
