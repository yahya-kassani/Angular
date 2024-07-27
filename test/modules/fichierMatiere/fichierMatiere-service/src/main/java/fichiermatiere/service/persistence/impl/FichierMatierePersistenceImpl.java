/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service.persistence.impl;

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

import fichiermatiere.exception.NoSuchFichierMatiereException;

import fichiermatiere.model.FichierMatiere;
import fichiermatiere.model.FichierMatiereTable;
import fichiermatiere.model.impl.FichierMatiereImpl;
import fichiermatiere.model.impl.FichierMatiereModelImpl;

import fichiermatiere.service.persistence.FichierMatierePersistence;
import fichiermatiere.service.persistence.FichierMatiereUtil;
import fichiermatiere.service.persistence.impl.constants.LLPersistenceConstants;

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
 * The persistence implementation for the fichier matiere service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FichierMatierePersistence.class)
public class FichierMatierePersistenceImpl
	extends BasePersistenceImpl<FichierMatiere>
	implements FichierMatierePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FichierMatiereUtil</code> to access the fichier matiere persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FichierMatiereImpl.class.getName();

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
	 * Returns all the fichier matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fichier matieres
	 */
	@Override
	public List<FichierMatiere> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fichier matieres where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @return the range of matching fichier matieres
	 */
	@Override
	public List<FichierMatiere> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fichier matieres where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fichier matieres
	 */
	@Override
	public List<FichierMatiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fichier matieres where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fichier matieres
	 */
	@Override
	public List<FichierMatiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator,
		boolean useFinderCache) {

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

		List<FichierMatiere> list = null;

		if (useFinderCache) {
			list = (List<FichierMatiere>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FichierMatiere fichierMatiere : list) {
					if (!uuid.equals(fichierMatiere.getUuid())) {
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

			sb.append(_SQL_SELECT_FICHIERMATIERE_WHERE);

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
				sb.append(FichierMatiereModelImpl.ORDER_BY_JPQL);
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

				list = (List<FichierMatiere>)QueryUtil.list(
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
	 * Returns the first fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fichier matiere
	 * @throws NoSuchFichierMatiereException if a matching fichier matiere could not be found
	 */
	@Override
	public FichierMatiere findByUuid_First(
			String uuid, OrderByComparator<FichierMatiere> orderByComparator)
		throws NoSuchFichierMatiereException {

		FichierMatiere fichierMatiere = fetchByUuid_First(
			uuid, orderByComparator);

		if (fichierMatiere != null) {
			return fichierMatiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFichierMatiereException(sb.toString());
	}

	/**
	 * Returns the first fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fichier matiere, or <code>null</code> if a matching fichier matiere could not be found
	 */
	@Override
	public FichierMatiere fetchByUuid_First(
		String uuid, OrderByComparator<FichierMatiere> orderByComparator) {

		List<FichierMatiere> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fichier matiere
	 * @throws NoSuchFichierMatiereException if a matching fichier matiere could not be found
	 */
	@Override
	public FichierMatiere findByUuid_Last(
			String uuid, OrderByComparator<FichierMatiere> orderByComparator)
		throws NoSuchFichierMatiereException {

		FichierMatiere fichierMatiere = fetchByUuid_Last(
			uuid, orderByComparator);

		if (fichierMatiere != null) {
			return fichierMatiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFichierMatiereException(sb.toString());
	}

	/**
	 * Returns the last fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fichier matiere, or <code>null</code> if a matching fichier matiere could not be found
	 */
	@Override
	public FichierMatiere fetchByUuid_Last(
		String uuid, OrderByComparator<FichierMatiere> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FichierMatiere> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fichier matieres before and after the current fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param fichierMatiereId the primary key of the current fichier matiere
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fichier matiere
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	@Override
	public FichierMatiere[] findByUuid_PrevAndNext(
			long fichierMatiereId, String uuid,
			OrderByComparator<FichierMatiere> orderByComparator)
		throws NoSuchFichierMatiereException {

		uuid = Objects.toString(uuid, "");

		FichierMatiere fichierMatiere = findByPrimaryKey(fichierMatiereId);

		Session session = null;

		try {
			session = openSession();

			FichierMatiere[] array = new FichierMatiereImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fichierMatiere, uuid, orderByComparator, true);

			array[1] = fichierMatiere;

			array[2] = getByUuid_PrevAndNext(
				session, fichierMatiere, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FichierMatiere getByUuid_PrevAndNext(
		Session session, FichierMatiere fichierMatiere, String uuid,
		OrderByComparator<FichierMatiere> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FICHIERMATIERE_WHERE);

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
			sb.append(FichierMatiereModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						fichierMatiere)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FichierMatiere> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fichier matieres where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FichierMatiere fichierMatiere :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fichierMatiere);
		}
	}

	/**
	 * Returns the number of fichier matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fichier matieres
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FICHIERMATIERE_WHERE);

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
		"fichierMatiere.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fichierMatiere.uuid IS NULL OR fichierMatiere.uuid = '')";

	public FichierMatierePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FichierMatiere.class);

		setModelImplClass(FichierMatiereImpl.class);
		setModelPKClass(long.class);

		setTable(FichierMatiereTable.INSTANCE);
	}

	/**
	 * Caches the fichier matiere in the entity cache if it is enabled.
	 *
	 * @param fichierMatiere the fichier matiere
	 */
	@Override
	public void cacheResult(FichierMatiere fichierMatiere) {
		entityCache.putResult(
			FichierMatiereImpl.class, fichierMatiere.getPrimaryKey(),
			fichierMatiere);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fichier matieres in the entity cache if it is enabled.
	 *
	 * @param fichierMatieres the fichier matieres
	 */
	@Override
	public void cacheResult(List<FichierMatiere> fichierMatieres) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fichierMatieres.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FichierMatiere fichierMatiere : fichierMatieres) {
			if (entityCache.getResult(
					FichierMatiereImpl.class, fichierMatiere.getPrimaryKey()) ==
						null) {

				cacheResult(fichierMatiere);
			}
		}
	}

	/**
	 * Clears the cache for all fichier matieres.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FichierMatiereImpl.class);

		finderCache.clearCache(FichierMatiereImpl.class);
	}

	/**
	 * Clears the cache for the fichier matiere.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FichierMatiere fichierMatiere) {
		entityCache.removeResult(FichierMatiereImpl.class, fichierMatiere);
	}

	@Override
	public void clearCache(List<FichierMatiere> fichierMatieres) {
		for (FichierMatiere fichierMatiere : fichierMatieres) {
			entityCache.removeResult(FichierMatiereImpl.class, fichierMatiere);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FichierMatiereImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FichierMatiereImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new fichier matiere with the primary key. Does not add the fichier matiere to the database.
	 *
	 * @param fichierMatiereId the primary key for the new fichier matiere
	 * @return the new fichier matiere
	 */
	@Override
	public FichierMatiere create(long fichierMatiereId) {
		FichierMatiere fichierMatiere = new FichierMatiereImpl();

		fichierMatiere.setNew(true);
		fichierMatiere.setPrimaryKey(fichierMatiereId);

		String uuid = PortalUUIDUtil.generate();

		fichierMatiere.setUuid(uuid);

		return fichierMatiere;
	}

	/**
	 * Removes the fichier matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere that was removed
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	@Override
	public FichierMatiere remove(long fichierMatiereId)
		throws NoSuchFichierMatiereException {

		return remove((Serializable)fichierMatiereId);
	}

	/**
	 * Removes the fichier matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fichier matiere
	 * @return the fichier matiere that was removed
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	@Override
	public FichierMatiere remove(Serializable primaryKey)
		throws NoSuchFichierMatiereException {

		Session session = null;

		try {
			session = openSession();

			FichierMatiere fichierMatiere = (FichierMatiere)session.get(
				FichierMatiereImpl.class, primaryKey);

			if (fichierMatiere == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFichierMatiereException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fichierMatiere);
		}
		catch (NoSuchFichierMatiereException noSuchEntityException) {
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
	protected FichierMatiere removeImpl(FichierMatiere fichierMatiere) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fichierMatiere)) {
				fichierMatiere = (FichierMatiere)session.get(
					FichierMatiereImpl.class,
					fichierMatiere.getPrimaryKeyObj());
			}

			if (fichierMatiere != null) {
				session.delete(fichierMatiere);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fichierMatiere != null) {
			clearCache(fichierMatiere);
		}

		return fichierMatiere;
	}

	@Override
	public FichierMatiere updateImpl(FichierMatiere fichierMatiere) {
		boolean isNew = fichierMatiere.isNew();

		if (!(fichierMatiere instanceof FichierMatiereModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fichierMatiere.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fichierMatiere);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fichierMatiere proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FichierMatiere implementation " +
					fichierMatiere.getClass());
		}

		FichierMatiereModelImpl fichierMatiereModelImpl =
			(FichierMatiereModelImpl)fichierMatiere;

		if (Validator.isNull(fichierMatiere.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fichierMatiere.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fichierMatiere);
			}
			else {
				fichierMatiere = (FichierMatiere)session.merge(fichierMatiere);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FichierMatiereImpl.class, fichierMatiereModelImpl, false, true);

		if (isNew) {
			fichierMatiere.setNew(false);
		}

		fichierMatiere.resetOriginalValues();

		return fichierMatiere;
	}

	/**
	 * Returns the fichier matiere with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fichier matiere
	 * @return the fichier matiere
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	@Override
	public FichierMatiere findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFichierMatiereException {

		FichierMatiere fichierMatiere = fetchByPrimaryKey(primaryKey);

		if (fichierMatiere == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFichierMatiereException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fichierMatiere;
	}

	/**
	 * Returns the fichier matiere with the primary key or throws a <code>NoSuchFichierMatiereException</code> if it could not be found.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	@Override
	public FichierMatiere findByPrimaryKey(long fichierMatiereId)
		throws NoSuchFichierMatiereException {

		return findByPrimaryKey((Serializable)fichierMatiereId);
	}

	/**
	 * Returns the fichier matiere with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere, or <code>null</code> if a fichier matiere with the primary key could not be found
	 */
	@Override
	public FichierMatiere fetchByPrimaryKey(long fichierMatiereId) {
		return fetchByPrimaryKey((Serializable)fichierMatiereId);
	}

	/**
	 * Returns all the fichier matieres.
	 *
	 * @return the fichier matieres
	 */
	@Override
	public List<FichierMatiere> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fichier matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @return the range of fichier matieres
	 */
	@Override
	public List<FichierMatiere> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fichier matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fichier matieres
	 */
	@Override
	public List<FichierMatiere> findAll(
		int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fichier matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fichier matieres
	 */
	@Override
	public List<FichierMatiere> findAll(
		int start, int end, OrderByComparator<FichierMatiere> orderByComparator,
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

		List<FichierMatiere> list = null;

		if (useFinderCache) {
			list = (List<FichierMatiere>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FICHIERMATIERE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FICHIERMATIERE;

				sql = sql.concat(FichierMatiereModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FichierMatiere>)QueryUtil.list(
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
	 * Removes all the fichier matieres from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FichierMatiere fichierMatiere : findAll()) {
			remove(fichierMatiere);
		}
	}

	/**
	 * Returns the number of fichier matieres.
	 *
	 * @return the number of fichier matieres
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FICHIERMATIERE);

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
		return "fichierMatiereId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FICHIERMATIERE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FichierMatiereModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fichier matiere persistence.
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

		FichierMatiereUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FichierMatiereUtil.setPersistence(null);

		entityCache.removeCache(FichierMatiereImpl.class.getName());
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

	private static final String _SQL_SELECT_FICHIERMATIERE =
		"SELECT fichierMatiere FROM FichierMatiere fichierMatiere";

	private static final String _SQL_SELECT_FICHIERMATIERE_WHERE =
		"SELECT fichierMatiere FROM FichierMatiere fichierMatiere WHERE ";

	private static final String _SQL_COUNT_FICHIERMATIERE =
		"SELECT COUNT(fichierMatiere) FROM FichierMatiere fichierMatiere";

	private static final String _SQL_COUNT_FICHIERMATIERE_WHERE =
		"SELECT COUNT(fichierMatiere) FROM FichierMatiere fichierMatiere WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fichierMatiere.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FichierMatiere exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FichierMatiere exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FichierMatierePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}