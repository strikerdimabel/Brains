package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import daointerface.DAO;

/**
 * @author Dmitri Belous
 * @version 1.0
 * @created 19-Dec-2014 12:54:00
 */
public class DaoImpl implements DAO {

	private final SessionFactory sessionFactory;

	public DaoImpl() {
		try {
			Configuration configuration = new Configuration()
					.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public <T> void saveEntity(T obj) {
		try {
			getCurrentSession().beginTransaction();
			getCurrentSession().saveOrUpdate(obj);
			getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			getCurrentSession().getTransaction().rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void clean() {
		getCurrentSession().beginTransaction();
		getCurrentSession().clear();
		getCurrentSession().getTransaction().commit();
	}

	public void close() {
		sessionFactory.close();
	}

	@Override
	public <T> void delete(Class<T> tClass, long id) {
		try {
			getCurrentSession().beginTransaction();
			Object obj = getCurrentSession().get(tClass, id);
			getCurrentSession().delete(obj);
			getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			getCurrentSession().getTransaction().rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public <T> List<T> getAll(Class<T> tClass) {
		try {
			getCurrentSession().beginTransaction();
			@SuppressWarnings("unchecked")
			List<T> retValue = (List<T>) getCurrentSession().createCriteria(
					tClass).list();
			getCurrentSession().getTransaction().commit();
			return retValue;
		} catch (Exception e) {
			getCurrentSession().getTransaction().rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public <T> T getByUniqueField(Class<T> tClass, String fieldName,
			Object field) {
		try {
			getCurrentSession().beginTransaction();
			@SuppressWarnings("unchecked")
			T res = (T) getCurrentSession().createCriteria(tClass)
					.add(Restrictions.eq(fieldName, field)).uniqueResult();
			getCurrentSession().getTransaction().commit();
			return res;
		} catch (Exception e) {
			getCurrentSession().getTransaction().rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public <T> T getEntityById(Class<T> tClass, long id) {
		try {
			getCurrentSession().beginTransaction();
			@SuppressWarnings("unchecked")
			T retValue = (T) getCurrentSession().get(tClass, id);
			getCurrentSession().getTransaction().commit();
			return retValue;
		} catch (Exception e) {
			getCurrentSession().getTransaction().rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public <T> boolean exist(Class<? extends T> class1, long id) {
		try {
			getCurrentSession().beginTransaction();
			Object obj = getCurrentSession().get(class1, id);
			getCurrentSession().getTransaction().commit();
			return obj != null;
		} catch (Exception e) {
			getCurrentSession().getTransaction().rollback();
			throw new RuntimeException(e.getMessage());
		}
	}

}