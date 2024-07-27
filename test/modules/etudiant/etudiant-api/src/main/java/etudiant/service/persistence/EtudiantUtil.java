/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import etudiant.model.Etudiant;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the etudiant service. This utility wraps <code>etudiant.service.persistence.impl.EtudiantPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EtudiantPersistence
 * @generated
 */
public class EtudiantUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Etudiant etudiant) {
		getPersistence().clearCache(etudiant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Etudiant> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Etudiant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Etudiant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Etudiant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Etudiant> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Etudiant update(Etudiant etudiant) {
		return getPersistence().update(etudiant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Etudiant update(
		Etudiant etudiant, ServiceContext serviceContext) {

		return getPersistence().update(etudiant, serviceContext);
	}

	/**
	 * Returns all the etudiants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching etudiants
	 */
	public static List<Etudiant> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Etudiant> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Etudiant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Etudiant> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Etudiant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Etudiant> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etudiant
	 * @throws NoSuchEtudiantException if a matching etudiant could not be found
	 */
	public static Etudiant findByUuid_First(
			String uuid, OrderByComparator<Etudiant> orderByComparator)
		throws etudiant.exception.NoSuchEtudiantException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etudiant, or <code>null</code> if a matching etudiant could not be found
	 */
	public static Etudiant fetchByUuid_First(
		String uuid, OrderByComparator<Etudiant> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etudiant
	 * @throws NoSuchEtudiantException if a matching etudiant could not be found
	 */
	public static Etudiant findByUuid_Last(
			String uuid, OrderByComparator<Etudiant> orderByComparator)
		throws etudiant.exception.NoSuchEtudiantException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etudiant, or <code>null</code> if a matching etudiant could not be found
	 */
	public static Etudiant fetchByUuid_Last(
		String uuid, OrderByComparator<Etudiant> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Etudiant[] findByUuid_PrevAndNext(
			long etudiantId, String uuid,
			OrderByComparator<Etudiant> orderByComparator)
		throws etudiant.exception.NoSuchEtudiantException {

		return getPersistence().findByUuid_PrevAndNext(
			etudiantId, uuid, orderByComparator);
	}

	/**
	 * Removes all the etudiants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of etudiants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching etudiants
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the etudiant in the entity cache if it is enabled.
	 *
	 * @param etudiant the etudiant
	 */
	public static void cacheResult(Etudiant etudiant) {
		getPersistence().cacheResult(etudiant);
	}

	/**
	 * Caches the etudiants in the entity cache if it is enabled.
	 *
	 * @param etudiants the etudiants
	 */
	public static void cacheResult(List<Etudiant> etudiants) {
		getPersistence().cacheResult(etudiants);
	}

	/**
	 * Creates a new etudiant with the primary key. Does not add the etudiant to the database.
	 *
	 * @param etudiantId the primary key for the new etudiant
	 * @return the new etudiant
	 */
	public static Etudiant create(long etudiantId) {
		return getPersistence().create(etudiantId);
	}

	/**
	 * Removes the etudiant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant that was removed
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	public static Etudiant remove(long etudiantId)
		throws etudiant.exception.NoSuchEtudiantException {

		return getPersistence().remove(etudiantId);
	}

	public static Etudiant updateImpl(Etudiant etudiant) {
		return getPersistence().updateImpl(etudiant);
	}

	/**
	 * Returns the etudiant with the primary key or throws a <code>NoSuchEtudiantException</code> if it could not be found.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	public static Etudiant findByPrimaryKey(long etudiantId)
		throws etudiant.exception.NoSuchEtudiantException {

		return getPersistence().findByPrimaryKey(etudiantId);
	}

	/**
	 * Returns the etudiant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant, or <code>null</code> if a etudiant with the primary key could not be found
	 */
	public static Etudiant fetchByPrimaryKey(long etudiantId) {
		return getPersistence().fetchByPrimaryKey(etudiantId);
	}

	/**
	 * Returns all the etudiants.
	 *
	 * @return the etudiants
	 */
	public static List<Etudiant> findAll() {
		return getPersistence().findAll();
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
	public static List<Etudiant> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Etudiant> findAll(
		int start, int end, OrderByComparator<Etudiant> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Etudiant> findAll(
		int start, int end, OrderByComparator<Etudiant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the etudiants from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of etudiants.
	 *
	 * @return the number of etudiants
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EtudiantPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EtudiantPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EtudiantPersistence _persistence;

}