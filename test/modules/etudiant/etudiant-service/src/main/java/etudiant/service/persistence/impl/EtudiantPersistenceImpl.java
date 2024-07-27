/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service.persistence.impl;

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

import etudiant.exception.NoSuchEtudiantException;

import etudiant.model.Etudiant;
import etudiant.model.EtudiantTable;
import etudiant.model.impl.EtudiantImpl;
import etudiant.model.impl.EtudiantModelImpl;

import etudiant.service.persistence.EtudiantPersistence;
import etudiant.service.persistence.EtudiantUtil;
import etudiant.service.persistence.impl.constants.LLPersistenceConstants;

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
 * The persistence implementation for the etudiant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EtudiantPersistence.class)
public class EtudiantPersistenceImpl
	extends BasePersistenceImpl<Etudiant> implements EtudiantPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EtudiantUtil</code> to access the etudiant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EtudiantImpl.class.getName();

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
	 * Returns all the etudiants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching etudiants
	 */
	@Override
	public List<Etudiant> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the etudiants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @return the range of matching etudiants
	 */
	@Override
	public List<Etudiant> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the etudiants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching etudiants
	 */
	@Override
	public List<Etudiant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Etudiant> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the etudiants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching etudiants
	 */
	@Override
	public List<Etudiant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Etudiant> orderByComparator, boolean useFinderCache) {

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

		List<Etudiant> list = null;

		if (useFinderCache) {
			list = (List<Etudiant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Etudiant etudiant : list) {
					if (!uuid.equals(etudiant.getUuid())) {
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

			sb.append(_SQL_SELECT_ETUDIANT_WHERE);

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
				sb.append(EtudiantModelImpl.ORDER_BY_JPQL);
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

				list = (List<Etudiant>)QueryUtil.list(
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
	 * Returns the first etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etudiant
	 * @throws NoSuchEtudiantException if a matching etudiant could not be found
	 */
	@Override
	public Etudiant findByUuid_First(
			String uuid, OrderByComparator<Etudiant> orderByComparator)
		throws NoSuchEtudiantException {

		Etudiant etudiant = fetchByUuid_First(uuid, orderByComparator);

		if (etudiant != null) {
			return etudiant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEtudiantException(sb.toString());
	}

	/**
	 * Returns the first etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etudiant, or <code>null</code> if a matching etudiant could not be found
	 */
	@Override
	public Etudiant fetchByUuid_First(
		String uuid, OrderByComparator<Etudiant> orderByComparator) {

		List<Etudiant> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etudiant
	 * @throws NoSuchEtudiantException if a matching etudiant could not be found
	 */
	@Override
	public Etudiant findByUuid_Last(
			String uuid, OrderByComparator<Etudiant> orderByComparator)
		throws NoSuchEtudiantException {

		Etudiant etudiant = fetchByUuid_Last(uuid, orderByComparator);

		if (etudiant != null) {
			return etudiant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEtudiantException(sb.toString());
	}

	/**
	 * Returns the last etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etudiant, or <code>null</code> if a matching etudiant could not be found
	 */
	@Override
	public Etudiant fetchByUuid_Last(
		String uuid, OrderByComparator<Etudiant> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Etudiant> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the etudiants before and after the current etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param etudiantId the primary key of the current etudiant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next etudiant
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	@Override
	public Etudiant[] findByUuid_PrevAndNext(
			long etudiantId, String uuid,
			OrderByComparator<Etudiant> orderByComparator)
		throws NoSuchEtudiantException {

		uuid = Objects.toString(uuid, "");

		Etudiant etudiant = findByPrimaryKey(etudiantId);

		Session session = null;

		try {
			session = openSession();

			Etudiant[] array = new EtudiantImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, etudiant, uuid, orderByComparator, true);

			array[1] = etudiant;

			array[2] = getByUuid_PrevAndNext(
				session, etudiant, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Etudiant getByUuid_PrevAndNext(
		Session session, Etudiant etudiant, String uuid,
		OrderByComparator<Etudiant> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ETUDIANT_WHERE);

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
			sb.append(EtudiantModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(etudiant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Etudiant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the etudiants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Etudiant etudiant :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(etudiant);
		}
	}

	/**
	 * Returns the number of etudiants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching etudiants
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ETUDIANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"etudiant.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(etudiant.uuid IS NULL OR etudiant.uuid = '')";

	public EtudiantPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Etudiant.class);

		setModelImplClass(EtudiantImpl.class);
		setModelPKClass(long.class);

		setTable(EtudiantTable.INSTANCE);
	}

	/**
	 * Caches the etudiant in the entity cache if it is enabled.
	 *
	 * @param etudiant the etudiant
	 */
	@Override
	public void cacheResult(Etudiant etudiant) {
		entityCache.putResult(
			EtudiantImpl.class, etudiant.getPrimaryKey(), etudiant);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the etudiants in the entity cache if it is enabled.
	 *
	 * @param etudiants the etudiants
	 */
	@Override
	public void cacheResult(List<Etudiant> etudiants) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (etudiants.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Etudiant etudiant : etudiants) {
			if (entityCache.getResult(
					EtudiantImpl.class, etudiant.getPrimaryKey()) == null) {

				cacheResult(etudiant);
			}
		}
	}

	/**
	 * Clears the cache for all etudiants.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EtudiantImpl.class);

		finderCache.clearCache(EtudiantImpl.class);
	}

	/**
	 * Clears the cache for the etudiant.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Etudiant etudiant) {
		entityCache.removeResult(EtudiantImpl.class, etudiant);
	}

	@Override
	public void clearCache(List<Etudiant> etudiants) {
		for (Etudiant etudiant : etudiants) {
			entityCache.removeResult(EtudiantImpl.class, etudiant);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EtudiantImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EtudiantImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new etudiant with the primary key. Does not add the etudiant to the database.
	 *
	 * @param etudiantId the primary key for the new etudiant
	 * @return the new etudiant
	 */
	@Override
	public Etudiant create(long etudiantId) {
		Etudiant etudiant = new EtudiantImpl();

		etudiant.setNew(true);
		etudiant.setPrimaryKey(etudiantId);

		String uuid = PortalUUIDUtil.generate();

		etudiant.setUuid(uuid);

		return etudiant;
	}

	/**
	 * Removes the etudiant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant that was removed
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	@Override
	public Etudiant remove(long etudiantId) throws NoSuchEtudiantException {
		return remove((Serializable)etudiantId);
	}

	/**
	 * Removes the etudiant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the etudiant
	 * @return the etudiant that was removed
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	@Override
	public Etudiant remove(Serializable primaryKey)
		throws NoSuchEtudiantException {

		Session session = null;

		try {
			session = openSession();

			Etudiant etudiant = (Etudiant)session.get(
				EtudiantImpl.class, primaryKey);

			if (etudiant == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEtudiantException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(etudiant);
		}
		catch (NoSuchEtudiantException noSuchEntityException) {
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
	protected Etudiant removeImpl(Etudiant etudiant) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(etudiant)) {
				etudiant = (Etudiant)session.get(
					EtudiantImpl.class, etudiant.getPrimaryKeyObj());
			}

			if (etudiant != null) {
				session.delete(etudiant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (etudiant != null) {
			clearCache(etudiant);
		}

		return etudiant;
	}

	@Override
	public Etudiant updateImpl(Etudiant etudiant) {
		boolean isNew = etudiant.isNew();

		if (!(etudiant instanceof EtudiantModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(etudiant.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(etudiant);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in etudiant proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Etudiant implementation " +
					etudiant.getClass());
		}

		EtudiantModelImpl etudiantModelImpl = (EtudiantModelImpl)etudiant;

		if (Validator.isNull(etudiant.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			etudiant.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(etudiant);
			}
			else {
				etudiant = (Etudiant)session.merge(etudiant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EtudiantImpl.class, etudiantModelImpl, false, true);

		if (isNew) {
			etudiant.setNew(false);
		}

		etudiant.resetOriginalValues();

		return etudiant;
	}

	/**
	 * Returns the etudiant with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the etudiant
	 * @return the etudiant
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	@Override
	public Etudiant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEtudiantException {

		Etudiant etudiant = fetchByPrimaryKey(primaryKey);

		if (etudiant == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEtudiantException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return etudiant;
	}

	/**
	 * Returns the etudiant with the primary key or throws a <code>NoSuchEtudiantException</code> if it could not be found.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	@Override
	public Etudiant findByPrimaryKey(long etudiantId)
		throws NoSuchEtudiantException {

		return findByPrimaryKey((Serializable)etudiantId);
	}

	/**
	 * Returns the etudiant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant, or <code>null</code> if a etudiant with the primary key could not be found
	 */
	@Override
	public Etudiant fetchByPrimaryKey(long etudiantId) {
		return fetchByPrimaryKey((Serializable)etudiantId);
	}

	/**
	 * Returns all the etudiants.
	 *
	 * @return the etudiants
	 */
	@Override
	public List<Etudiant> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the etudiants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @return the range of etudiants
	 */
	@Override
	public List<Etudiant> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the etudiants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of etudiants
	 */
	@Override
	public List<Etudiant> findAll(
		int start, int end, OrderByComparator<Etudiant> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the etudiants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of etudiants
	 */
	@Override
	public List<Etudiant> findAll(
		int start, int end, OrderByComparator<Etudiant> orderByComparator,
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

		List<Etudiant> list = null;

		if (useFinderCache) {
			list = (List<Etudiant>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ETUDIANT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ETUDIANT;

				sql = sql.concat(EtudiantModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Etudiant>)QueryUtil.list(
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
	 * Removes all the etudiants from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Etudiant etudiant : findAll()) {
			remove(etudiant);
		}
	}

	/**
	 * Returns the number of etudiants.
	 *
	 * @return the number of etudiants
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ETUDIANT);

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
		return "etudiantId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ETUDIANT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EtudiantModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the etudiant persistence.
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

		EtudiantUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EtudiantUtil.setPersistence(null);

		entityCache.removeCache(EtudiantImpl.class.getName());
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

	private static final String _SQL_SELECT_ETUDIANT =
		"SELECT etudiant FROM Etudiant etudiant";

	private static final String _SQL_SELECT_ETUDIANT_WHERE =
		"SELECT etudiant FROM Etudiant etudiant WHERE ";

	private static final String _SQL_COUNT_ETUDIANT =
		"SELECT COUNT(etudiant) FROM Etudiant etudiant";

	private static final String _SQL_COUNT_ETUDIANT_WHERE =
		"SELECT COUNT(etudiant) FROM Etudiant etudiant WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "etudiant.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Etudiant exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Etudiant exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EtudiantPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}