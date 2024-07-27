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

import professeur.exception.NoSuchProfClasseException;

import professeur.model.ProfClasse;
import professeur.model.ProfClasseTable;
import professeur.model.impl.ProfClasseImpl;
import professeur.model.impl.ProfClasseModelImpl;

import professeur.service.persistence.ProfClassePersistence;
import professeur.service.persistence.ProfClasseUtil;
import professeur.service.persistence.impl.constants.LLPersistenceConstants;

/**
 * The persistence implementation for the prof classe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProfClassePersistence.class)
public class ProfClassePersistenceImpl
	extends BasePersistenceImpl<ProfClasse> implements ProfClassePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProfClasseUtil</code> to access the prof classe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProfClasseImpl.class.getName();

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
	 * Returns all the prof classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prof classes
	 */
	@Override
	public List<ProfClasse> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prof classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @return the range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prof classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prof classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator,
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

		List<ProfClasse> list = null;

		if (useFinderCache) {
			list = (List<ProfClasse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProfClasse profClasse : list) {
					if (!uuid.equals(profClasse.getUuid())) {
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

			sb.append(_SQL_SELECT_PROFCLASSE_WHERE);

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
				sb.append(ProfClasseModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProfClasse>)QueryUtil.list(
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
	 * Returns the first prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse findByUuid_First(
			String uuid, OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByUuid_First(uuid, orderByComparator);

		if (profClasse != null) {
			return profClasse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProfClasseException(sb.toString());
	}

	/**
	 * Returns the first prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse fetchByUuid_First(
		String uuid, OrderByComparator<ProfClasse> orderByComparator) {

		List<ProfClasse> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse findByUuid_Last(
			String uuid, OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByUuid_Last(uuid, orderByComparator);

		if (profClasse != null) {
			return profClasse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProfClasseException(sb.toString());
	}

	/**
	 * Returns the last prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse fetchByUuid_Last(
		String uuid, OrderByComparator<ProfClasse> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProfClasse> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prof classes before and after the current prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param profClasseId the primary key of the current prof classe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse[] findByUuid_PrevAndNext(
			long profClasseId, String uuid,
			OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		uuid = Objects.toString(uuid, "");

		ProfClasse profClasse = findByPrimaryKey(profClasseId);

		Session session = null;

		try {
			session = openSession();

			ProfClasse[] array = new ProfClasseImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, profClasse, uuid, orderByComparator, true);

			array[1] = profClasse;

			array[2] = getByUuid_PrevAndNext(
				session, profClasse, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfClasse getByUuid_PrevAndNext(
		Session session, ProfClasse profClasse, String uuid,
		OrderByComparator<ProfClasse> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROFCLASSE_WHERE);

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
			sb.append(ProfClasseModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(profClasse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProfClasse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prof classes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProfClasse profClasse :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(profClasse);
		}
	}

	/**
	 * Returns the number of prof classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prof classes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROFCLASSE_WHERE);

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
		"profClasse.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(profClasse.uuid IS NULL OR profClasse.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByProfesseurId;
	private FinderPath _finderPathWithoutPaginationFindByProfesseurId;
	private FinderPath _finderPathCountByProfesseurId;

	/**
	 * Returns all the prof classes where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the matching prof classes
	 */
	@Override
	public List<ProfClasse> findByProfesseurId(long professeurId) {
		return findByProfesseurId(
			professeurId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prof classes where professeurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param professeurId the professeur ID
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @return the range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end) {

		return findByProfesseurId(professeurId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prof classes where professeurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param professeurId the professeur ID
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return findByProfesseurId(
			professeurId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prof classes where professeurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param professeurId the professeur ID
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProfesseurId;
				finderArgs = new Object[] {professeurId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProfesseurId;
			finderArgs = new Object[] {
				professeurId, start, end, orderByComparator
			};
		}

		List<ProfClasse> list = null;

		if (useFinderCache) {
			list = (List<ProfClasse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProfClasse profClasse : list) {
					if (professeurId != profClasse.getProfesseurId()) {
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

			sb.append(_SQL_SELECT_PROFCLASSE_WHERE);

			sb.append(_FINDER_COLUMN_PROFESSEURID_PROFESSEURID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProfClasseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(professeurId);

				list = (List<ProfClasse>)QueryUtil.list(
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
	 * Returns the first prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse findByProfesseurId_First(
			long professeurId, OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByProfesseurId_First(
			professeurId, orderByComparator);

		if (profClasse != null) {
			return profClasse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("professeurId=");
		sb.append(professeurId);

		sb.append("}");

		throw new NoSuchProfClasseException(sb.toString());
	}

	/**
	 * Returns the first prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse fetchByProfesseurId_First(
		long professeurId, OrderByComparator<ProfClasse> orderByComparator) {

		List<ProfClasse> list = findByProfesseurId(
			professeurId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse findByProfesseurId_Last(
			long professeurId, OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByProfesseurId_Last(
			professeurId, orderByComparator);

		if (profClasse != null) {
			return profClasse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("professeurId=");
		sb.append(professeurId);

		sb.append("}");

		throw new NoSuchProfClasseException(sb.toString());
	}

	/**
	 * Returns the last prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse fetchByProfesseurId_Last(
		long professeurId, OrderByComparator<ProfClasse> orderByComparator) {

		int count = countByProfesseurId(professeurId);

		if (count == 0) {
			return null;
		}

		List<ProfClasse> list = findByProfesseurId(
			professeurId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prof classes before and after the current prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param profClasseId the primary key of the current prof classe
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse[] findByProfesseurId_PrevAndNext(
			long profClasseId, long professeurId,
			OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = findByPrimaryKey(profClasseId);

		Session session = null;

		try {
			session = openSession();

			ProfClasse[] array = new ProfClasseImpl[3];

			array[0] = getByProfesseurId_PrevAndNext(
				session, profClasse, professeurId, orderByComparator, true);

			array[1] = profClasse;

			array[2] = getByProfesseurId_PrevAndNext(
				session, profClasse, professeurId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfClasse getByProfesseurId_PrevAndNext(
		Session session, ProfClasse profClasse, long professeurId,
		OrderByComparator<ProfClasse> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROFCLASSE_WHERE);

		sb.append(_FINDER_COLUMN_PROFESSEURID_PROFESSEURID_2);

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
			sb.append(ProfClasseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(professeurId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(profClasse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProfClasse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prof classes where professeurId = &#63; from the database.
	 *
	 * @param professeurId the professeur ID
	 */
	@Override
	public void removeByProfesseurId(long professeurId) {
		for (ProfClasse profClasse :
				findByProfesseurId(
					professeurId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(profClasse);
		}
	}

	/**
	 * Returns the number of prof classes where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the number of matching prof classes
	 */
	@Override
	public int countByProfesseurId(long professeurId) {
		FinderPath finderPath = _finderPathCountByProfesseurId;

		Object[] finderArgs = new Object[] {professeurId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROFCLASSE_WHERE);

			sb.append(_FINDER_COLUMN_PROFESSEURID_PROFESSEURID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(professeurId);

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

	private static final String _FINDER_COLUMN_PROFESSEURID_PROFESSEURID_2 =
		"profClasse.professeurId = ?";

	private FinderPath _finderPathWithPaginationFindByclasseId;
	private FinderPath _finderPathWithoutPaginationFindByclasseId;
	private FinderPath _finderPathCountByclasseId;

	/**
	 * Returns all the prof classes where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the matching prof classes
	 */
	@Override
	public List<ProfClasse> findByclasseId(long classeId) {
		return findByclasseId(
			classeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prof classes where classeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param classeId the classe ID
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @return the range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByclasseId(long classeId, int start, int end) {
		return findByclasseId(classeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prof classes where classeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param classeId the classe ID
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return findByclasseId(classeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prof classes where classeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param classeId the classe ID
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching prof classes
	 */
	@Override
	public List<ProfClasse> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByclasseId;
				finderArgs = new Object[] {classeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByclasseId;
			finderArgs = new Object[] {classeId, start, end, orderByComparator};
		}

		List<ProfClasse> list = null;

		if (useFinderCache) {
			list = (List<ProfClasse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProfClasse profClasse : list) {
					if (classeId != profClasse.getClasseId()) {
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

			sb.append(_SQL_SELECT_PROFCLASSE_WHERE);

			sb.append(_FINDER_COLUMN_CLASSEID_CLASSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProfClasseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classeId);

				list = (List<ProfClasse>)QueryUtil.list(
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
	 * Returns the first prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse findByclasseId_First(
			long classeId, OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByclasseId_First(
			classeId, orderByComparator);

		if (profClasse != null) {
			return profClasse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classeId=");
		sb.append(classeId);

		sb.append("}");

		throw new NoSuchProfClasseException(sb.toString());
	}

	/**
	 * Returns the first prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse fetchByclasseId_First(
		long classeId, OrderByComparator<ProfClasse> orderByComparator) {

		List<ProfClasse> list = findByclasseId(
			classeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse findByclasseId_Last(
			long classeId, OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByclasseId_Last(
			classeId, orderByComparator);

		if (profClasse != null) {
			return profClasse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classeId=");
		sb.append(classeId);

		sb.append("}");

		throw new NoSuchProfClasseException(sb.toString());
	}

	/**
	 * Returns the last prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	@Override
	public ProfClasse fetchByclasseId_Last(
		long classeId, OrderByComparator<ProfClasse> orderByComparator) {

		int count = countByclasseId(classeId);

		if (count == 0) {
			return null;
		}

		List<ProfClasse> list = findByclasseId(
			classeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prof classes before and after the current prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param profClasseId the primary key of the current prof classe
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse[] findByclasseId_PrevAndNext(
			long profClasseId, long classeId,
			OrderByComparator<ProfClasse> orderByComparator)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = findByPrimaryKey(profClasseId);

		Session session = null;

		try {
			session = openSession();

			ProfClasse[] array = new ProfClasseImpl[3];

			array[0] = getByclasseId_PrevAndNext(
				session, profClasse, classeId, orderByComparator, true);

			array[1] = profClasse;

			array[2] = getByclasseId_PrevAndNext(
				session, profClasse, classeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProfClasse getByclasseId_PrevAndNext(
		Session session, ProfClasse profClasse, long classeId,
		OrderByComparator<ProfClasse> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROFCLASSE_WHERE);

		sb.append(_FINDER_COLUMN_CLASSEID_CLASSEID_2);

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
			sb.append(ProfClasseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(classeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(profClasse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProfClasse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prof classes where classeId = &#63; from the database.
	 *
	 * @param classeId the classe ID
	 */
	@Override
	public void removeByclasseId(long classeId) {
		for (ProfClasse profClasse :
				findByclasseId(
					classeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(profClasse);
		}
	}

	/**
	 * Returns the number of prof classes where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the number of matching prof classes
	 */
	@Override
	public int countByclasseId(long classeId) {
		FinderPath finderPath = _finderPathCountByclasseId;

		Object[] finderArgs = new Object[] {classeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROFCLASSE_WHERE);

			sb.append(_FINDER_COLUMN_CLASSEID_CLASSEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classeId);

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

	private static final String _FINDER_COLUMN_CLASSEID_CLASSEID_2 =
		"profClasse.classeId = ?";

	public ProfClassePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProfClasse.class);

		setModelImplClass(ProfClasseImpl.class);
		setModelPKClass(long.class);

		setTable(ProfClasseTable.INSTANCE);
	}

	/**
	 * Caches the prof classe in the entity cache if it is enabled.
	 *
	 * @param profClasse the prof classe
	 */
	@Override
	public void cacheResult(ProfClasse profClasse) {
		entityCache.putResult(
			ProfClasseImpl.class, profClasse.getPrimaryKey(), profClasse);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the prof classes in the entity cache if it is enabled.
	 *
	 * @param profClasses the prof classes
	 */
	@Override
	public void cacheResult(List<ProfClasse> profClasses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (profClasses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProfClasse profClasse : profClasses) {
			if (entityCache.getResult(
					ProfClasseImpl.class, profClasse.getPrimaryKey()) == null) {

				cacheResult(profClasse);
			}
		}
	}

	/**
	 * Clears the cache for all prof classes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProfClasseImpl.class);

		finderCache.clearCache(ProfClasseImpl.class);
	}

	/**
	 * Clears the cache for the prof classe.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProfClasse profClasse) {
		entityCache.removeResult(ProfClasseImpl.class, profClasse);
	}

	@Override
	public void clearCache(List<ProfClasse> profClasses) {
		for (ProfClasse profClasse : profClasses) {
			entityCache.removeResult(ProfClasseImpl.class, profClasse);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProfClasseImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProfClasseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new prof classe with the primary key. Does not add the prof classe to the database.
	 *
	 * @param profClasseId the primary key for the new prof classe
	 * @return the new prof classe
	 */
	@Override
	public ProfClasse create(long profClasseId) {
		ProfClasse profClasse = new ProfClasseImpl();

		profClasse.setNew(true);
		profClasse.setPrimaryKey(profClasseId);

		String uuid = PortalUUIDUtil.generate();

		profClasse.setUuid(uuid);

		return profClasse;
	}

	/**
	 * Removes the prof classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe that was removed
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse remove(long profClasseId)
		throws NoSuchProfClasseException {

		return remove((Serializable)profClasseId);
	}

	/**
	 * Removes the prof classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the prof classe
	 * @return the prof classe that was removed
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse remove(Serializable primaryKey)
		throws NoSuchProfClasseException {

		Session session = null;

		try {
			session = openSession();

			ProfClasse profClasse = (ProfClasse)session.get(
				ProfClasseImpl.class, primaryKey);

			if (profClasse == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfClasseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(profClasse);
		}
		catch (NoSuchProfClasseException noSuchEntityException) {
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
	protected ProfClasse removeImpl(ProfClasse profClasse) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(profClasse)) {
				profClasse = (ProfClasse)session.get(
					ProfClasseImpl.class, profClasse.getPrimaryKeyObj());
			}

			if (profClasse != null) {
				session.delete(profClasse);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (profClasse != null) {
			clearCache(profClasse);
		}

		return profClasse;
	}

	@Override
	public ProfClasse updateImpl(ProfClasse profClasse) {
		boolean isNew = profClasse.isNew();

		if (!(profClasse instanceof ProfClasseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(profClasse.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(profClasse);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in profClasse proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProfClasse implementation " +
					profClasse.getClass());
		}

		ProfClasseModelImpl profClasseModelImpl =
			(ProfClasseModelImpl)profClasse;

		if (Validator.isNull(profClasse.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			profClasse.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(profClasse);
			}
			else {
				profClasse = (ProfClasse)session.merge(profClasse);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProfClasseImpl.class, profClasseModelImpl, false, true);

		if (isNew) {
			profClasse.setNew(false);
		}

		profClasse.resetOriginalValues();

		return profClasse;
	}

	/**
	 * Returns the prof classe with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the prof classe
	 * @return the prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProfClasseException {

		ProfClasse profClasse = fetchByPrimaryKey(primaryKey);

		if (profClasse == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProfClasseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return profClasse;
	}

	/**
	 * Returns the prof classe with the primary key or throws a <code>NoSuchProfClasseException</code> if it could not be found.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse findByPrimaryKey(long profClasseId)
		throws NoSuchProfClasseException {

		return findByPrimaryKey((Serializable)profClasseId);
	}

	/**
	 * Returns the prof classe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe, or <code>null</code> if a prof classe with the primary key could not be found
	 */
	@Override
	public ProfClasse fetchByPrimaryKey(long profClasseId) {
		return fetchByPrimaryKey((Serializable)profClasseId);
	}

	/**
	 * Returns all the prof classes.
	 *
	 * @return the prof classes
	 */
	@Override
	public List<ProfClasse> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prof classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @return the range of prof classes
	 */
	@Override
	public List<ProfClasse> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the prof classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prof classes
	 */
	@Override
	public List<ProfClasse> findAll(
		int start, int end, OrderByComparator<ProfClasse> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prof classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of prof classes
	 */
	@Override
	public List<ProfClasse> findAll(
		int start, int end, OrderByComparator<ProfClasse> orderByComparator,
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

		List<ProfClasse> list = null;

		if (useFinderCache) {
			list = (List<ProfClasse>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROFCLASSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROFCLASSE;

				sql = sql.concat(ProfClasseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProfClasse>)QueryUtil.list(
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
	 * Removes all the prof classes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProfClasse profClasse : findAll()) {
			remove(profClasse);
		}
	}

	/**
	 * Returns the number of prof classes.
	 *
	 * @return the number of prof classes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROFCLASSE);

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
		return "profClasseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROFCLASSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProfClasseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the prof classe persistence.
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

		_finderPathWithPaginationFindByProfesseurId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProfesseurId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"professeurId"}, true);

		_finderPathWithoutPaginationFindByProfesseurId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProfesseurId",
			new String[] {Long.class.getName()}, new String[] {"professeurId"},
			true);

		_finderPathCountByProfesseurId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProfesseurId",
			new String[] {Long.class.getName()}, new String[] {"professeurId"},
			false);

		_finderPathWithPaginationFindByclasseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByclasseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"classeId"}, true);

		_finderPathWithoutPaginationFindByclasseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByclasseId",
			new String[] {Long.class.getName()}, new String[] {"classeId"},
			true);

		_finderPathCountByclasseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByclasseId",
			new String[] {Long.class.getName()}, new String[] {"classeId"},
			false);

		ProfClasseUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProfClasseUtil.setPersistence(null);

		entityCache.removeCache(ProfClasseImpl.class.getName());
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

	private static final String _SQL_SELECT_PROFCLASSE =
		"SELECT profClasse FROM ProfClasse profClasse";

	private static final String _SQL_SELECT_PROFCLASSE_WHERE =
		"SELECT profClasse FROM ProfClasse profClasse WHERE ";

	private static final String _SQL_COUNT_PROFCLASSE =
		"SELECT COUNT(profClasse) FROM ProfClasse profClasse";

	private static final String _SQL_COUNT_PROFCLASSE_WHERE =
		"SELECT COUNT(profClasse) FROM ProfClasse profClasse WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "profClasse.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProfClasse exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProfClasse exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProfClassePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}