/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.service.persistence.impl;

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

import matiere.exception.NoSuchMatiereException;

import matiere.model.Matiere;
import matiere.model.MatiereTable;
import matiere.model.impl.MatiereImpl;
import matiere.model.impl.MatiereModelImpl;

import matiere.service.persistence.MatierePersistence;
import matiere.service.persistence.MatiereUtil;
import matiere.service.persistence.impl.constants.LLPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the matiere service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MatierePersistence.class)
public class MatierePersistenceImpl
	extends BasePersistenceImpl<Matiere> implements MatierePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MatiereUtil</code> to access the matiere persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MatiereImpl.class.getName();

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
	 * Returns all the matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matieres
	 */
	@Override
	public List<Matiere> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the matieres where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @return the range of matching matieres
	 */
	@Override
	public List<Matiere> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the matieres where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matieres
	 */
	@Override
	public List<Matiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the matieres where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matieres
	 */
	@Override
	public List<Matiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Matiere> orderByComparator, boolean useFinderCache) {

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

		List<Matiere> list = null;

		if (useFinderCache) {
			list = (List<Matiere>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Matiere matiere : list) {
					if (!uuid.equals(matiere.getUuid())) {
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

			sb.append(_SQL_SELECT_MATIERE_WHERE);

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
				sb.append(MatiereModelImpl.ORDER_BY_JPQL);
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

				list = (List<Matiere>)QueryUtil.list(
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
	 * Returns the first matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	@Override
	public Matiere findByUuid_First(
			String uuid, OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByUuid_First(uuid, orderByComparator);

		if (matiere != null) {
			return matiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMatiereException(sb.toString());
	}

	/**
	 * Returns the first matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	@Override
	public Matiere fetchByUuid_First(
		String uuid, OrderByComparator<Matiere> orderByComparator) {

		List<Matiere> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	@Override
	public Matiere findByUuid_Last(
			String uuid, OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByUuid_Last(uuid, orderByComparator);

		if (matiere != null) {
			return matiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMatiereException(sb.toString());
	}

	/**
	 * Returns the last matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	@Override
	public Matiere fetchByUuid_Last(
		String uuid, OrderByComparator<Matiere> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Matiere> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the matieres before and after the current matiere in the ordered set where uuid = &#63;.
	 *
	 * @param matiereId the primary key of the current matiere
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere[] findByUuid_PrevAndNext(
			long matiereId, String uuid,
			OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		uuid = Objects.toString(uuid, "");

		Matiere matiere = findByPrimaryKey(matiereId);

		Session session = null;

		try {
			session = openSession();

			Matiere[] array = new MatiereImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, matiere, uuid, orderByComparator, true);

			array[1] = matiere;

			array[2] = getByUuid_PrevAndNext(
				session, matiere, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Matiere getByUuid_PrevAndNext(
		Session session, Matiere matiere, String uuid,
		OrderByComparator<Matiere> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATIERE_WHERE);

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
			sb.append(MatiereModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(matiere)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Matiere> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matieres where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Matiere matiere :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matiere);
		}
	}

	/**
	 * Returns the number of matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matieres
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATIERE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "matiere.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(matiere.uuid IS NULL OR matiere.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByProfesseurId;
	private FinderPath _finderPathWithoutPaginationFindByProfesseurId;
	private FinderPath _finderPathCountByProfesseurId;

	/**
	 * Returns all the matieres where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the matching matieres
	 */
	@Override
	public List<Matiere> findByProfesseurId(long professeurId) {
		return findByProfesseurId(
			professeurId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the matieres where professeurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param professeurId the professeur ID
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @return the range of matching matieres
	 */
	@Override
	public List<Matiere> findByProfesseurId(
		long professeurId, int start, int end) {

		return findByProfesseurId(professeurId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the matieres where professeurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param professeurId the professeur ID
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matieres
	 */
	@Override
	public List<Matiere> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return findByProfesseurId(
			professeurId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the matieres where professeurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param professeurId the professeur ID
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matieres
	 */
	@Override
	public List<Matiere> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<Matiere> orderByComparator, boolean useFinderCache) {

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

		List<Matiere> list = null;

		if (useFinderCache) {
			list = (List<Matiere>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Matiere matiere : list) {
					if (professeurId != matiere.getProfesseurId()) {
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

			sb.append(_SQL_SELECT_MATIERE_WHERE);

			sb.append(_FINDER_COLUMN_PROFESSEURID_PROFESSEURID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatiereModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(professeurId);

				list = (List<Matiere>)QueryUtil.list(
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
	 * Returns the first matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	@Override
	public Matiere findByProfesseurId_First(
			long professeurId, OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByProfesseurId_First(
			professeurId, orderByComparator);

		if (matiere != null) {
			return matiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("professeurId=");
		sb.append(professeurId);

		sb.append("}");

		throw new NoSuchMatiereException(sb.toString());
	}

	/**
	 * Returns the first matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	@Override
	public Matiere fetchByProfesseurId_First(
		long professeurId, OrderByComparator<Matiere> orderByComparator) {

		List<Matiere> list = findByProfesseurId(
			professeurId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	@Override
	public Matiere findByProfesseurId_Last(
			long professeurId, OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByProfesseurId_Last(
			professeurId, orderByComparator);

		if (matiere != null) {
			return matiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("professeurId=");
		sb.append(professeurId);

		sb.append("}");

		throw new NoSuchMatiereException(sb.toString());
	}

	/**
	 * Returns the last matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	@Override
	public Matiere fetchByProfesseurId_Last(
		long professeurId, OrderByComparator<Matiere> orderByComparator) {

		int count = countByProfesseurId(professeurId);

		if (count == 0) {
			return null;
		}

		List<Matiere> list = findByProfesseurId(
			professeurId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the matieres before and after the current matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param matiereId the primary key of the current matiere
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere[] findByProfesseurId_PrevAndNext(
			long matiereId, long professeurId,
			OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = findByPrimaryKey(matiereId);

		Session session = null;

		try {
			session = openSession();

			Matiere[] array = new MatiereImpl[3];

			array[0] = getByProfesseurId_PrevAndNext(
				session, matiere, professeurId, orderByComparator, true);

			array[1] = matiere;

			array[2] = getByProfesseurId_PrevAndNext(
				session, matiere, professeurId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Matiere getByProfesseurId_PrevAndNext(
		Session session, Matiere matiere, long professeurId,
		OrderByComparator<Matiere> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATIERE_WHERE);

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
			sb.append(MatiereModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(professeurId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matiere)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Matiere> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matieres where professeurId = &#63; from the database.
	 *
	 * @param professeurId the professeur ID
	 */
	@Override
	public void removeByProfesseurId(long professeurId) {
		for (Matiere matiere :
				findByProfesseurId(
					professeurId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matiere);
		}
	}

	/**
	 * Returns the number of matieres where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the number of matching matieres
	 */
	@Override
	public int countByProfesseurId(long professeurId) {
		FinderPath finderPath = _finderPathCountByProfesseurId;

		Object[] finderArgs = new Object[] {professeurId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATIERE_WHERE);

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
		"matiere.professeurId = ?";

	private FinderPath _finderPathWithPaginationFindByclasseId;
	private FinderPath _finderPathWithoutPaginationFindByclasseId;
	private FinderPath _finderPathCountByclasseId;

	/**
	 * Returns all the matieres where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the matching matieres
	 */
	@Override
	public List<Matiere> findByclasseId(long classeId) {
		return findByclasseId(
			classeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the matieres where classeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param classeId the classe ID
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @return the range of matching matieres
	 */
	@Override
	public List<Matiere> findByclasseId(long classeId, int start, int end) {
		return findByclasseId(classeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the matieres where classeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param classeId the classe ID
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matieres
	 */
	@Override
	public List<Matiere> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return findByclasseId(classeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the matieres where classeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param classeId the classe ID
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matieres
	 */
	@Override
	public List<Matiere> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<Matiere> orderByComparator, boolean useFinderCache) {

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

		List<Matiere> list = null;

		if (useFinderCache) {
			list = (List<Matiere>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Matiere matiere : list) {
					if (classeId != matiere.getClasseId()) {
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

			sb.append(_SQL_SELECT_MATIERE_WHERE);

			sb.append(_FINDER_COLUMN_CLASSEID_CLASSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatiereModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classeId);

				list = (List<Matiere>)QueryUtil.list(
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
	 * Returns the first matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	@Override
	public Matiere findByclasseId_First(
			long classeId, OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByclasseId_First(classeId, orderByComparator);

		if (matiere != null) {
			return matiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classeId=");
		sb.append(classeId);

		sb.append("}");

		throw new NoSuchMatiereException(sb.toString());
	}

	/**
	 * Returns the first matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	@Override
	public Matiere fetchByclasseId_First(
		long classeId, OrderByComparator<Matiere> orderByComparator) {

		List<Matiere> list = findByclasseId(classeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	@Override
	public Matiere findByclasseId_Last(
			long classeId, OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByclasseId_Last(classeId, orderByComparator);

		if (matiere != null) {
			return matiere;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("classeId=");
		sb.append(classeId);

		sb.append("}");

		throw new NoSuchMatiereException(sb.toString());
	}

	/**
	 * Returns the last matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	@Override
	public Matiere fetchByclasseId_Last(
		long classeId, OrderByComparator<Matiere> orderByComparator) {

		int count = countByclasseId(classeId);

		if (count == 0) {
			return null;
		}

		List<Matiere> list = findByclasseId(
			classeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the matieres before and after the current matiere in the ordered set where classeId = &#63;.
	 *
	 * @param matiereId the primary key of the current matiere
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere[] findByclasseId_PrevAndNext(
			long matiereId, long classeId,
			OrderByComparator<Matiere> orderByComparator)
		throws NoSuchMatiereException {

		Matiere matiere = findByPrimaryKey(matiereId);

		Session session = null;

		try {
			session = openSession();

			Matiere[] array = new MatiereImpl[3];

			array[0] = getByclasseId_PrevAndNext(
				session, matiere, classeId, orderByComparator, true);

			array[1] = matiere;

			array[2] = getByclasseId_PrevAndNext(
				session, matiere, classeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Matiere getByclasseId_PrevAndNext(
		Session session, Matiere matiere, long classeId,
		OrderByComparator<Matiere> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATIERE_WHERE);

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
			sb.append(MatiereModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(classeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(matiere)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Matiere> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matieres where classeId = &#63; from the database.
	 *
	 * @param classeId the classe ID
	 */
	@Override
	public void removeByclasseId(long classeId) {
		for (Matiere matiere :
				findByclasseId(
					classeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matiere);
		}
	}

	/**
	 * Returns the number of matieres where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the number of matching matieres
	 */
	@Override
	public int countByclasseId(long classeId) {
		FinderPath finderPath = _finderPathCountByclasseId;

		Object[] finderArgs = new Object[] {classeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATIERE_WHERE);

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
		"matiere.classeId = ?";

	public MatierePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Matiere.class);

		setModelImplClass(MatiereImpl.class);
		setModelPKClass(long.class);

		setTable(MatiereTable.INSTANCE);
	}

	/**
	 * Caches the matiere in the entity cache if it is enabled.
	 *
	 * @param matiere the matiere
	 */
	@Override
	public void cacheResult(Matiere matiere) {
		entityCache.putResult(
			MatiereImpl.class, matiere.getPrimaryKey(), matiere);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the matieres in the entity cache if it is enabled.
	 *
	 * @param matieres the matieres
	 */
	@Override
	public void cacheResult(List<Matiere> matieres) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (matieres.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Matiere matiere : matieres) {
			if (entityCache.getResult(
					MatiereImpl.class, matiere.getPrimaryKey()) == null) {

				cacheResult(matiere);
			}
		}
	}

	/**
	 * Clears the cache for all matieres.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MatiereImpl.class);

		finderCache.clearCache(MatiereImpl.class);
	}

	/**
	 * Clears the cache for the matiere.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Matiere matiere) {
		entityCache.removeResult(MatiereImpl.class, matiere);
	}

	@Override
	public void clearCache(List<Matiere> matieres) {
		for (Matiere matiere : matieres) {
			entityCache.removeResult(MatiereImpl.class, matiere);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MatiereImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MatiereImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new matiere with the primary key. Does not add the matiere to the database.
	 *
	 * @param matiereId the primary key for the new matiere
	 * @return the new matiere
	 */
	@Override
	public Matiere create(long matiereId) {
		Matiere matiere = new MatiereImpl();

		matiere.setNew(true);
		matiere.setPrimaryKey(matiereId);

		String uuid = PortalUUIDUtil.generate();

		matiere.setUuid(uuid);

		return matiere;
	}

	/**
	 * Removes the matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere that was removed
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere remove(long matiereId) throws NoSuchMatiereException {
		return remove((Serializable)matiereId);
	}

	/**
	 * Removes the matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the matiere
	 * @return the matiere that was removed
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere remove(Serializable primaryKey)
		throws NoSuchMatiereException {

		Session session = null;

		try {
			session = openSession();

			Matiere matiere = (Matiere)session.get(
				MatiereImpl.class, primaryKey);

			if (matiere == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMatiereException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(matiere);
		}
		catch (NoSuchMatiereException noSuchEntityException) {
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
	protected Matiere removeImpl(Matiere matiere) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(matiere)) {
				matiere = (Matiere)session.get(
					MatiereImpl.class, matiere.getPrimaryKeyObj());
			}

			if (matiere != null) {
				session.delete(matiere);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (matiere != null) {
			clearCache(matiere);
		}

		return matiere;
	}

	@Override
	public Matiere updateImpl(Matiere matiere) {
		boolean isNew = matiere.isNew();

		if (!(matiere instanceof MatiereModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(matiere.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(matiere);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in matiere proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Matiere implementation " +
					matiere.getClass());
		}

		MatiereModelImpl matiereModelImpl = (MatiereModelImpl)matiere;

		if (Validator.isNull(matiere.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			matiere.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(matiere);
			}
			else {
				matiere = (Matiere)session.merge(matiere);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MatiereImpl.class, matiereModelImpl, false, true);

		if (isNew) {
			matiere.setNew(false);
		}

		matiere.resetOriginalValues();

		return matiere;
	}

	/**
	 * Returns the matiere with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the matiere
	 * @return the matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMatiereException {

		Matiere matiere = fetchByPrimaryKey(primaryKey);

		if (matiere == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMatiereException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return matiere;
	}

	/**
	 * Returns the matiere with the primary key or throws a <code>NoSuchMatiereException</code> if it could not be found.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere findByPrimaryKey(long matiereId)
		throws NoSuchMatiereException {

		return findByPrimaryKey((Serializable)matiereId);
	}

	/**
	 * Returns the matiere with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere, or <code>null</code> if a matiere with the primary key could not be found
	 */
	@Override
	public Matiere fetchByPrimaryKey(long matiereId) {
		return fetchByPrimaryKey((Serializable)matiereId);
	}

	/**
	 * Returns all the matieres.
	 *
	 * @return the matieres
	 */
	@Override
	public List<Matiere> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @return the range of matieres
	 */
	@Override
	public List<Matiere> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matieres
	 */
	@Override
	public List<Matiere> findAll(
		int start, int end, OrderByComparator<Matiere> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matieres
	 */
	@Override
	public List<Matiere> findAll(
		int start, int end, OrderByComparator<Matiere> orderByComparator,
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

		List<Matiere> list = null;

		if (useFinderCache) {
			list = (List<Matiere>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MATIERE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MATIERE;

				sql = sql.concat(MatiereModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Matiere>)QueryUtil.list(
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
	 * Removes all the matieres from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Matiere matiere : findAll()) {
			remove(matiere);
		}
	}

	/**
	 * Returns the number of matieres.
	 *
	 * @return the number of matieres
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MATIERE);

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
		return "matiereId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MATIERE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MatiereModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the matiere persistence.
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

		MatiereUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MatiereUtil.setPersistence(null);

		entityCache.removeCache(MatiereImpl.class.getName());
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

	private static final String _SQL_SELECT_MATIERE =
		"SELECT matiere FROM Matiere matiere";

	private static final String _SQL_SELECT_MATIERE_WHERE =
		"SELECT matiere FROM Matiere matiere WHERE ";

	private static final String _SQL_COUNT_MATIERE =
		"SELECT COUNT(matiere) FROM Matiere matiere";

	private static final String _SQL_COUNT_MATIERE_WHERE =
		"SELECT COUNT(matiere) FROM Matiere matiere WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "matiere.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Matiere exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Matiere exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MatierePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}