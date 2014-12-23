package main;

import dao.DaoImpl;
import manager.Manager;

public class ManagerFactory {
	
	private static final Manager INSTANCE = new Manager(new DaoImpl());
	
	public static Manager getManager() {
		return INSTANCE;
	}
	
}
