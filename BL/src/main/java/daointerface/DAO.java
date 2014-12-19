package daointerface;

import java.util.List;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 12:54:04
 */
public interface DAO {

	<T> void delete(long id, Class<T> tClass);

	<T> List<T> getAll(Class<T> tClass);

	<T> T getByUniqueField(Class<T> tClass, String fieldName, Object field);

	<T> T getEntityById(long id, Class<T> tClass);

	<T> boolean saveEntity(T solution, Class<? extends T> class1);
	
	<T> boolean exist(long id, Class<? extends T> class1);

}