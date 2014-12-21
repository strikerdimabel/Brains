package main;

import dao.DaoImpl;
import manager.Manager;

public class ManagerFactory {
	
	public static Manager newManager() {
		return new Manager(new DaoImpl());
	}
	
}
