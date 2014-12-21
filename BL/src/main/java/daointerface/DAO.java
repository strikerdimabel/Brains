package daointerface;

import java.util.List;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 12:54:04
 */
public interface DAO {

	<T> void delete(Class<T> tClass, long id);

	<T> List<T> getAll(Class<T> tClass);

	<T> T getByUniqueField(Class<T> tClass, String fieldName, Object field);

	<T> T getEntityById(Class<T> tClass, long id);

	<T> void saveEntity(T obj);
	
	<T> boolean exist(Class<? extends T> class1, long id);

}