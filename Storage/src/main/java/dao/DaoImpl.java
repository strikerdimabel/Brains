package dao;

import java.util.List;

import model.teaser.Teaser;
import daointerface.DAO;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 12:54:00
 */
public class DaoImpl implements DAO {

	public DaoImpl(){

	}

	@Override
	public <T> void delete(long id, Class<T> tClass){

	}

	@Override
	public <T> List<T> getAll(Class<T> tClass){
		return null;
	}

	@Override
	public <T> T getByUniqueField(Class<T> tClass, String fieldName, Object field){
		return null;
	}

	@Override
	public <T> T getEntityById(long id, Class<T> tClass){
		return null;
	}

	@Override
	public <T> boolean saveEntity(T solution, Class<? extends T> class1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean exist(long id, Class<? extends T> class1) {
		// TODO Auto-generated method stub
		return false;
	}

}