/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import professeur.model.Professeur;

/**
 * The persistence utility for the professeur service. This utility wraps <code>professeur.service.persistence.impl.ProfesseurPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfesseurPersistence
 * @generated
 */
public class ProfesseurUtil {

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
	public static void clearCache(Professeur professeur) {
		getPersistence().clearCache(professeur);
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
	public static Map<Serializable, Professeur> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Professeur> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Professeur> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Professeur> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Professeur> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Professeur update(Professeur professeur) {
		return getPersistence().update(professeur);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Professeur update(
		Professeur professeur, ServiceContext serviceContext) {

		return getPersistence().update(professeur, serviceContext);
	}

	/**
	 * Returns all the professeurs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professeurs
	 */
	public static List<Professeur> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Professeur> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Professeur> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Professeur> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Professeur> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Professeur> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professeur
	 * @throws NoSuchProfesseurException if a matching professeur could not be found
	 */
	public static Professeur findByUuid_First(
			String uuid, OrderByComparator<Professeur> orderByComparator)
		throws professeur.exception.NoSuchProfesseurException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professeur, or <code>null</code> if a matching professeur could not be found
	 */
	public static Professeur fetchByUuid_First(
		String uuid, OrderByComparator<Professeur> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professeur
	 * @throws NoSuchProfesseurException if a matching professeur could not be found
	 */
	public static Professeur findByUuid_Last(
			String uuid, OrderByComparator<Professeur> orderByComparator)
		throws professeur.exception.NoSuchProfesseurException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professeur, or <code>null</code> if a matching professeur could not be found
	 */
	public static Professeur fetchByUuid_Last(
		String uuid, OrderByComparator<Professeur> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Professeur[] findByUuid_PrevAndNext(
			long professeurId, String uuid,
			OrderByComparator<Professeur> orderByComparator)
		throws professeur.exception.NoSuchProfesseurException {

		return getPersistence().findByUuid_PrevAndNext(
			professeurId, uuid, orderByComparator);
	}

	/**
	 * Removes all the professeurs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of professeurs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professeurs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the professeur in the entity cache if it is enabled.
	 *
	 * @param professeur the professeur
	 */
	public static void cacheResult(Professeur professeur) {
		getPersistence().cacheResult(professeur);
	}

	/**
	 * Caches the professeurs in the entity cache if it is enabled.
	 *
	 * @param professeurs the professeurs
	 */
	public static void cacheResult(List<Professeur> professeurs) {
		getPersistence().cacheResult(professeurs);
	}

	/**
	 * Creates a new professeur with the primary key. Does not add the professeur to the database.
	 *
	 * @param professeurId the primary key for the new professeur
	 * @return the new professeur
	 */
	public static Professeur create(long professeurId) {
		return getPersistence().create(professeurId);
	}

	/**
	 * Removes the professeur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur that was removed
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	public static Professeur remove(long professeurId)
		throws professeur.exception.NoSuchProfesseurException {

		return getPersistence().remove(professeurId);
	}

	public static Professeur updateImpl(Professeur professeur) {
		return getPersistence().updateImpl(professeur);
	}

	/**
	 * Returns the professeur with the primary key or throws a <code>NoSuchProfesseurException</code> if it could not be found.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	public static Professeur findByPrimaryKey(long professeurId)
		throws professeur.exception.NoSuchProfesseurException {

		return getPersistence().findByPrimaryKey(professeurId);
	}

	/**
	 * Returns the professeur with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur, or <code>null</code> if a professeur with the primary key could not be found
	 */
	public static Professeur fetchByPrimaryKey(long professeurId) {
		return getPersistence().fetchByPrimaryKey(professeurId);
	}

	/**
	 * Returns all the professeurs.
	 *
	 * @return the professeurs
	 */
	public static List<Professeur> findAll() {
		return getPersistence().findAll();
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
	public static List<Professeur> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Professeur> findAll(
		int start, int end, OrderByComparator<Professeur> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Professeur> findAll(
		int start, int end, OrderByComparator<Professeur> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the professeurs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of professeurs.
	 *
	 * @return the number of professeurs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfesseurPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProfesseurPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProfesseurPersistence _persistence;

}