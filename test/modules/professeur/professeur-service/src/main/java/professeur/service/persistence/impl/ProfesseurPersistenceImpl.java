/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.persistence.impl;

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

import professeur.exception.NoSuchProfesseurException;

import professeur.model.Professeur;
import professeur.model.ProfesseurTable;
import professeur.model.impl.ProfesseurImpl;
import professeur.model.impl.ProfesseurModelImpl;

import professeur.service.persistence.ProfesseurPersistence;
import professeur.service.persistence.ProfesseurUtil;
import professeur.service.persistence.impl.constants.LLPersistenceConstants;

/**
 * The persistence implementation for the professeur service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProfesseurPersistence.class)
public class ProfesseurPersistenceImpl
	extends BasePersistenceImpl<Professeur> implements ProfesseurPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProfesseurUtil</code> to access the professeur persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProfesseurImpl.class.getName();

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
	 * Returns all the professeurs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professeurs
	 */
	@Override
	public List<Professeur> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the professeurs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @return the range of matching professeurs
	 */
	@Override
	public List<Professeur> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the professeurs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professeurs
	 */
	@Override
	public List<Professeur> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Professeur> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the professeurs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching professeurs
	 */
	@Override
	public List<Professeur> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Professeur> orderByComparator,
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

		List<Professeur> list = null;

		if (useFinderCache) {
			list = (List<Professeur>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Professeur professeur : list) {
					if (!uuid.equals(professeur.getUuid())) {
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

			sb.append(_SQL_SELECT_PROFESSEUR_WHERE);

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
				sb.append(ProfesseurModelImpl.ORDER_BY_JPQL);
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

				list = (List<Professeur>)QueryUtil.list(
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
	 * Returns the first professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professeur
	 * @throws NoSuchProfesseurException if a matching professeur could not be found
	 */
	@Override
	public Professeur findByUuid_First(
			String uuid, OrderByComparator<Professeur> orderByComparator)
		throws NoSuchProfesseurException {

		Professeur professeur = fetchByUuid_First(uuid, orderByComparator);

		if (professeur != null) {
			return professeur;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProfesseurException(sb.toString());
	}

	/**
	 * Returns the first professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professeur, or <code>null</code> if a matching professeur could not be found
	 */
	@Override
	public Professeur fetchByUuid_First(
		String uuid, OrderByComparator<Professeur> orderByComparator) {

		List<Professeur> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professeur
	 * @throws NoSuchProfesseurException if a matching professeur could not be found
	 */
	@Override
	public Professeur findByUuid_Last(
			String uuid, OrderByComparator<Professeur> orderByComparator)
		throws NoSuchProfesseurException {

		Professeur professeur = fetchByUuid_Last(uuid, orderByComparator);

		if (professeur != null) {
			return professeur;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProfesseurException(sb.toString());
	}

	/**
	 * Returns the last professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professeur, or <code>null</code> if a matching professeur could not be found
	 */
	@Override
	public Professeur fetchByUuid_Last(
		String uuid, OrderByComparator<Professeur> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Professeur> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the professeurs before and after the current professeur in the ordered set where uuid = &#63;.
	 *
	 * @param professeurId the primary key of the current professeur
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professeur
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	@Override
	public Professeur[] findByUuid_PrevAndNext(
			long professeurId, String uuid,
			OrderByComparator<Professeur> orderByComparator)
		throws NoSuchProfesseurException {

		uuid = Objects.toString(uuid, "");

		Professeur professeur = findByPrimaryKey(professeurId);

		Session session = null;

		try {
			session = openSession();

			Professeur[] array = new ProfesseurImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, professeur, uuid, orderByComparator, true);

			array[1] = professeur;

			array[2] = getByUuid_PrevAndNext(
				session, professeur, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Professeur getByUuid_PrevAndNext(
		Session session, Professeur professeur, String uuid,
		OrderByComparator<Professeur> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROFESSEUR_WHERE);

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
			sb.append(ProfesseurModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(professeur)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Professeur> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the professeurs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Professeur professeur :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(professeur);
		}
	}

	/**
	 * Returns the number of professeurs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professeurs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROFESSEUR_WHERE);

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
		"professeur.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(professeur.uuid IS NULL OR professeur.uuid = '')";

	public ProfesseurPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Professeur.class);

		setModelImplClass(ProfesseurImpl.class);
		setModelPKClass(long.class);

		setTable(ProfesseurTable.INSTANCE);
	}

	/**
	 * Caches the professeur in the entity cache if it is enabled.
	 *
	 * @param professeur the professeur
	 */
	@Override
	public void cacheResult(Professeur professeur) {
		entityCache.putResult(
			ProfesseurImpl.class, professeur.getPrimaryKey(), professeur);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the professeurs in the entity cache if it is enabled.
	 *
	 * @param professeurs the professeurs
	 */
	@Override
	public void cacheResult(List<Professeur> professeurs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (professeurs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Professeur professeur : professeurs) {
			if (entityCache.getResult(
					ProfesseurImpl.class, professeur.getPrimaryKey()) == null) {

				cacheResult(professeur);
			}
		}
	}

	/**
	 * Clears the cache for all professeurs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProfesseurImpl.class);

		finderCache.clearCache(ProfesseurImpl.class);
	}

	/**
	 * Clears the cache for the professeur.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Professeur professeur) {
		entityCache.removeResult(ProfesseurImpl.class, professeur);
	}

	@Override
	public void clearCache(List<Professeur> professeurs) {
		for (Professeur professeur : professeurs) {
			entityCache.removeResult(ProfesseurImpl.class, professeur);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProfesseurImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProfesseurImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new professeur with the primary key. Does not add the professeur to the database.
	 *
	 * @param professeurId the primary key for the new professeur
	 * @return the new professeur
	 */
	@Override
	public Professeur create(long professeurId) {
		Professeur professeur = new ProfesseurImpl();

		professeur.setNew(true);
		professeur.setPrimaryKey(professeurId);

		String uuid = PortalUUIDUtil.generate();

		professeur.setUuid(uuid);

		return professeur;
	}

	/**
	 * Removes the professeur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur that was removed
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	@Override
	public Professeur remove(long professeurId)
		throws NoSuchProfesseurException {

		return remove((Serializable)professeurId);
	}

	/**
	 * Removes the professeur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the professeur
	 * @return the professeur that was removed
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	@Override
	public Professeur remove(Serializable primaryKey)
		throws NoSuchProfesseurException {

		Session session = null;

		try {
			session = openSession();

			Professeur professeur = (Professeur)session.get(
				ProfesseurImpl.class, primaryKey);

			if (professeur == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfesseurException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(professeur);
		}
		catch (NoSuchProfesseurException noSuchEntityException) {
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
	protected Professeur removeImpl(Professeur professeur) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(professeur)) {
				professeur = (Professeur)session.get(
					ProfesseurImpl.class, professeur.getPrimaryKeyObj());
			}

			if (professeur != null) {
				session.delete(professeur);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (professeur != null) {
			clearCache(professeur);
		}

		return professeur;
	}

	@Override
	public Professeur updateImpl(Professeur professeur) {
		boolean isNew = professeur.isNew();

		if (!(professeur instanceof ProfesseurModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(professeur.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(professeur);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in professeur proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Professeur implementation " +
					professeur.getClass());
		}

		ProfesseurModelImpl professeurModelImpl =
			(ProfesseurModelImpl)professeur;

		if (Validator.isNull(professeur.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			professeur.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(professeur);
			}
			else {
				professeur = (Professeur)session.merge(professeur);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProfesseurImpl.class, professeurModelImpl, false, true);

		if (isNew) {
			professeur.setNew(false);
		}

		professeur.resetOriginalValues();

		return professeur;
	}

	/**
	 * Returns the professeur with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the professeur
	 * @return the professeur
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	@Override
	public Professeur findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProfesseurException {

		Professeur professeur = fetchByPrimaryKey(primaryKey);

		if (professeur == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProfesseurException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return professeur;
	}

	/**
	 * Returns the professeur with the primary key or throws a <code>NoSuchProfesseurException</code> if it could not be found.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	@Override
	public Professeur findByPrimaryKey(long professeurId)
		throws NoSuchProfesseurException {

		return findByPrimaryKey((Serializable)professeurId);
	}

	/**
	 * Returns the professeur with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur, or <code>null</code> if a professeur with the primary key could not be found
	 */
	@Override
	public Professeur fetchByPrimaryKey(long professeurId) {
		return fetchByPrimaryKey((Serializable)professeurId);
	}

	/**
	 * Returns all the professeurs.
	 *
	 * @return the professeurs
	 */
	@Override
	public List<Professeur> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the professeurs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @return the range of professeurs
	 */
	@Override
	public List<Professeur> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the professeurs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of professeurs
	 */
	@Override
	public List<Professeur> findAll(
		int start, int end, OrderByComparator<Professeur> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the professeurs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of professeurs
	 */
	@Override
	public List<Professeur> findAll(
		int start, int end, OrderByComparator<Professeur> orderByComparator,
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

		List<Professeur> list = null;

		if (useFinderCache) {
			list = (List<Professeur>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROFESSEUR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROFESSEUR;

				sql = sql.concat(ProfesseurModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Professeur>)QueryUtil.list(
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
	 * Removes all the professeurs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Professeur professeur : findAll()) {
			remove(professeur);
		}
	}

	/**
	 * Returns the number of professeurs.
	 *
	 * @return the number of professeurs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROFESSEUR);

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
		return "professeurId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROFESSEUR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProfesseurModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the professeur persistence.
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

		ProfesseurUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProfesseurUtil.setPersistence(null);

		entityCache.removeCache(ProfesseurImpl.class.getName());
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

	private static final String _SQL_SELECT_PROFESSEUR =
		"SELECT professeur FROM Professeur professeur";

	private static final String _SQL_SELECT_PROFESSEUR_WHERE =
		"SELECT professeur FROM Professeur professeur WHERE ";

	private static final String _SQL_COUNT_PROFESSEUR =
		"SELECT COUNT(professeur) FROM Professeur professeur";

	private static final String _SQL_COUNT_PROFESSEUR_WHERE =
		"SELECT COUNT(professeur) FROM Professeur professeur WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "professeur.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Professeur exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Professeur exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProfesseurPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}