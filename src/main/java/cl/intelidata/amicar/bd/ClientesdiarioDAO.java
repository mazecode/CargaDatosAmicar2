package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientesdiario entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see cl.intelidata.amicar.bd.Clientesdiario
 * @author MyEclipse Persistence Tools
 */
public class ClientesdiarioDAO implements IClientesdiarioDAO {
	// property constants
	public static final String RUT_CLIENTE = "rutCliente";
	public static final String EMAIL_CLIENTE = "emailCliente";
	public static final String NOMBRE_CLIENTE = "nombreCliente";
	public static final String SEXO_CLIENTE = "sexoCliente";
	public static final String FONO_CLIENTE = "fonoCliente";
	public static final String AUTOMOVIL_CLIENTE = "automovilCliente";
	public static final String ID_GRUPO = "idGrupo";
	public static final String ID_BODY = "idBody";
	public static final String NOMBRE_JRN = "nombreJrn";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Clientesdiario entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ClientesdiarioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientesdiario entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientesdiario entity) {
		EntityManagerHelper.log("saving Clientesdiario instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Clientesdiario entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ClientesdiarioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientesdiario entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientesdiario entity) {
		EntityManagerHelper.log("deleting Clientesdiario instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Clientesdiario.class,
					entity.getIdCliente());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Clientesdiario entity and return it or a copy
	 * of it to the sender. A copy of the Clientesdiario entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ClientesdiarioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientesdiario entity to update
	 * @return Clientesdiario the persisted Clientesdiario entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Clientesdiario update(Clientesdiario entity) {
		EntityManagerHelper.log("updating Clientesdiario instance", Level.INFO,
				null);
		try {
			Clientesdiario result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Clientesdiario findById(Integer id) {
		EntityManagerHelper.log("finding Clientesdiario instance with id: "
				+ id, Level.INFO, null);
		try {
			Clientesdiario instance = getEntityManager().find(
					Clientesdiario.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Clientesdiario entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Clientesdiario property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Clientesdiario> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Clientesdiario> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding Clientesdiario instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Clientesdiario model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<Clientesdiario> findByRutCliente(Object rutCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(RUT_CLIENTE, rutCliente, rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByEmailCliente(Object emailCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(EMAIL_CLIENTE, emailCliente, rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByNombreCliente(Object nombreCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(NOMBRE_CLIENTE, nombreCliente,
				rowStartIdxAndCount);
	}

	public List<Clientesdiario> findBySexoCliente(Object sexoCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(SEXO_CLIENTE, sexoCliente, rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByFonoCliente(Object fonoCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(FONO_CLIENTE, fonoCliente, rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByAutomovilCliente(Object automovilCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(AUTOMOVIL_CLIENTE, automovilCliente,
				rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByIdGrupo(Object idGrupo,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_GRUPO, idGrupo, rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByIdBody(Object idBody,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_BODY, idBody, rowStartIdxAndCount);
	}

	public List<Clientesdiario> findByNombreJrn(Object nombreJrn,
			int... rowStartIdxAndCount) {
		return findByProperty(NOMBRE_JRN, nombreJrn, rowStartIdxAndCount);
	}

	/**
	 * Find all Clientesdiario entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientesdiario> all Clientesdiario entities
	 */
	@SuppressWarnings("unchecked")
	public List<Clientesdiario> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Clientesdiario instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Clientesdiario model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}