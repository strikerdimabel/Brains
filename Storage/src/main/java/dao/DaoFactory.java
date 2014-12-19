package dao;

import daointerface.DAO;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 12:53:55
 */
public class DaoFactory {

	private static final DAO INSTANCE = new DaoImpl();

	private DaoFactory(){
	}

	public static DAO getInstance(){
		return INSTANCE;
	}

}