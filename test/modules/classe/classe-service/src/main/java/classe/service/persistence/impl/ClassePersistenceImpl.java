/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.service.persistence.impl;

import classe.exception.NoSuchClasseException;

import classe.model.Classe;
import classe.model.ClasseTable;
import classe.model.impl.ClasseImpl;
import classe.model.impl.ClasseModelImpl;

import classe.service.persistence.ClassePersistence;
import classe.service.persistence.ClasseUtil;
import classe.service.persistence.impl.constants.LLPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the classe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClassePersistence.class)
public class ClassePersistenceImpl
	extends BasePersistenceImpl<Classe> implements ClassePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClasseUtil</code> to access the classe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClasseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching classes
	 */
	@Override
	public List<Classe> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @return the range of matching classes
	 */
	@Override
	public List<Classe> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching classes
	 */
	@Override
	public List<Classe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Classe> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching classes
	 */
	@Override
	public List<Classe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Classe> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Classe> list = null;

		if (useFinderCache) {
			list = (List<Classe>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Classe classe : list) {
					if (!uuid.equals(classe.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CLASSE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ClasseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Classe>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching classe
	 * @throws NoSuchClasseException if a matching classe could not be found
	 */
	@Override
	public Classe findByUuid_First(
			String uuid, OrderByComparator<Classe> orderByComparator)
		throws NoSuchClasseException {

		Classe classe = fetchByUuid_First(uuid, orderByComparator);

		if (classe != null) {
			return classe;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClasseException(sb.toString());
	}

	/**
	 * Returns the first classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching classe, or <code>null</code> if a matching classe could not be found
	 */
	@Override
	public Classe fetchByUuid_First(
		String uuid, OrderByComparator<Classe> orderByComparator) {

		List<Classe> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching classe
	 * @throws NoSuchClasseException if a matching classe could not be found
	 */
	@Override
	public Classe findByUuid_Last(
			String uuid, OrderByComparator<Classe> orderByComparator)
		throws NoSuchClasseException {

		Classe classe = fetchByUuid_Last(uuid, orderByComparator);

		if (classe != null) {
			return classe;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchClasseException(sb.toString());
	}

	/**
	 * Returns the last classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching classe, or <code>null</code> if a matching classe could not be found
	 */
	@Override
	public Classe fetchByUuid_Last(
		String uuid, OrderByComparator<Classe> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Classe> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the classes before and after the current classe in the ordered set where uuid = &#63;.
	 *
	 * @param classeId the primary key of the current classe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	@Override
	public Classe[] findByUuid_PrevAndNext(
			long classeId, String uuid,
			OrderByComparator<Classe> orderByComparator)
		throws NoSuchClasseException {

		uuid = Objects.toString(uuid, "");

		Classe classe = findByPrimaryKey(classeId);

		Session session = null;

		try {
			session = openSession();

			Classe[] array = new ClasseImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, classe, uuid, orderByComparator, true);

			array[1] = classe;

			array[2] = getByUuid_PrevAndNext(
				session, classe, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Classe getByUuid_PrevAndNext(
		Session session, Classe classe, String uuid,
		OrderByComparator<Classe> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CLASSE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ClasseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(classe)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Classe> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the classes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Classe classe :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(classe);
		}
	}

	/**
	 * Returns the number of classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching classes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CLASSE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "classe.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(classe.uuid IS NULL OR classe.uuid = '')";

	public ClassePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Classe.class);

		setModelImplClass(ClasseImpl.class);
		setModelPKClass(long.class);

		setTable(ClasseTable.INSTANCE);
	}

	/**
	 * Caches the classe in the entity cache if it is enabled.
	 *
	 * @param classe the classe
	 */
	@Override
	public void cacheResult(Classe classe) {
		entityCache.putResult(ClasseImpl.class, classe.getPrimaryKey(), classe);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the classes in the entity cache if it is enabled.
	 *
	 * @param classes the classes
	 */
	@Override
	public void cacheResult(List<Classe> classes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (classes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Classe classe : classes) {
			if (entityCache.getResult(
					ClasseImpl.class, classe.getPrimaryKey()) == null) {

				cacheResult(classe);
			}
		}
	}

	/**
	 * Clears the cache for all classes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ClasseImpl.class);

		finderCache.clearCache(ClasseImpl.class);
	}

	/**
	 * Clears the cache for the classe.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Classe classe) {
		entityCache.removeResult(ClasseImpl.class, classe);
	}

	@Override
	public void clearCache(List<Classe> classes) {
		for (Classe classe : classes) {
			entityCache.removeResult(ClasseImpl.class, classe);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ClasseImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ClasseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new classe with the primary key. Does not add the classe to the database.
	 *
	 * @param classeId the primary key for the new classe
	 * @return the new classe
	 */
	@Override
	public Classe create(long classeId) {
		Classe classe = new ClasseImpl();

		classe.setNew(true);
		classe.setPrimaryKey(classeId);

		String uuid = PortalUUIDUtil.generate();

		classe.setUuid(uuid);

		return classe;
	}

	/**
	 * Removes the classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe that was removed
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	@Override
	public Classe remove(long classeId) throws NoSuchClasseException {
		return remove((Serializable)classeId);
	}

	/**
	 * Removes the classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the classe
	 * @return the classe that was removed
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	@Override
	public Classe remove(Serializable primaryKey) throws NoSuchClasseException {
		Session session = null;

		try {
			session = openSession();

			Classe classe = (Classe)session.get(ClasseImpl.class, primaryKey);

			if (classe == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClasseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(classe);
		}
		catch (NoSuchClasseException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Classe removeImpl(Classe classe) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(classe)) {
				classe = (Classe)session.get(
					ClasseImpl.class, classe.getPrimaryKeyObj());
			}

			if (classe != null) {
				session.delete(classe);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (classe != null) {
			clearCache(classe);
		}

		return classe;
	}

	@Override
	public Classe updateImpl(Classe classe) {
		boolean isNew = classe.isNew();

		if (!(classe instanceof ClasseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(classe.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(classe);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in classe proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Classe implementation " +
					classe.getClass());
		}

		ClasseModelImpl classeModelImpl = (ClasseModelImpl)classe;

		if (Validator.isNull(classe.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			classe.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(classe);
			}
			else {
				classe = (Classe)session.merge(classe);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ClasseImpl.class, classeModelImpl, false, true);

		if (isNew) {
			classe.setNew(false);
		}

		classe.resetOriginalValues();

		return classe;
	}

	/**
	 * Returns the classe with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the classe
	 * @return the classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	@Override
	public Classe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClasseException {

		Classe classe = fetchByPrimaryKey(primaryKey);

		if (classe == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClasseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return classe;
	}

	/**
	 * Returns the classe with the primary key or throws a <code>NoSuchClasseException</code> if it could not be found.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	@Override
	public Classe findByPrimaryKey(long classeId) throws NoSuchClasseException {
		return findByPrimaryKey((Serializable)classeId);
	}

	/**
	 * Returns the classe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe, or <code>null</code> if a classe with the primary key could not be found
	 */
	@Override
	public Classe fetchByPrimaryKey(long classeId) {
		return fetchByPrimaryKey((Serializable)classeId);
	}

	/**
	 * Returns all the classes.
	 *
	 * @return the classes
	 */
	@Override
	public List<Classe> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @return the range of classes
	 */
	@Override
	public List<Classe> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of classes
	 */
	@Override
	public List<Classe> findAll(
		int start, int end, OrderByComparator<Classe> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of classes
	 */
	@Override
	public List<Classe> findAll(
		int start, int end, OrderByComparator<Classe> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Classe> list = null;

		if (useFinderCache) {
			list = (List<Classe>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLASSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLASSE;

				sql = sql.concat(ClasseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Classe>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the classes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Classe classe : findAll()) {
			remove(classe);
		}
	}

	/**
	 * Returns the number of classes.
	 *
	 * @return the number of classes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLASSE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "classeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLASSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClasseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the classe persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		ClasseUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ClasseUtil.setPersistence(null);

		entityCache.removeCache(ClasseImpl.class.getName());
	}

	@Override
	@Reference(
		target = LLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CLASSE =
		"SELECT classe FROM Classe classe";

	private static final String _SQL_SELECT_CLASSE_WHERE =
		"SELECT classe FROM Classe classe WHERE ";

	private static final String _SQL_COUNT_CLASSE =
		"SELECT COUNT(classe) FROM Classe classe";

	private static final String _SQL_COUNT_CLASSE_WHERE =
		"SELECT COUNT(classe) FROM Classe classe WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "classe.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Classe exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Classe exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ClassePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}