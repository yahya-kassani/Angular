/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fichiermatiere.model.FichierMatiere;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the fichier matiere service. This utility wraps <code>fichiermatiere.service.persistence.impl.FichierMatierePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatierePersistence
 * @generated
 */
public class FichierMatiereUtil {

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
	public static void clearCache(FichierMatiere fichierMatiere) {
		getPersistence().clearCache(fichierMatiere);
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
	public static Map<Serializable, FichierMatiere> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FichierMatiere> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FichierMatiere> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FichierMatiere> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FichierMatiere update(FichierMatiere fichierMatiere) {
		return getPersistence().update(fichierMatiere);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FichierMatiere update(
		FichierMatiere fichierMatiere, ServiceContext serviceContext) {

		return getPersistence().update(fichierMatiere, serviceContext);
	}

	/**
	 * Returns all the fichier matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fichier matieres
	 */
	public static List<FichierMatiere> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<FichierMatiere> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<FichierMatiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<FichierMatiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fichier matiere
	 * @throws NoSuchFichierMatiereException if a matching fichier matiere could not be found
	 */
	public static FichierMatiere findByUuid_First(
			String uuid, OrderByComparator<FichierMatiere> orderByComparator)
		throws fichiermatiere.exception.NoSuchFichierMatiereException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fichier matiere, or <code>null</code> if a matching fichier matiere could not be found
	 */
	public static FichierMatiere fetchByUuid_First(
		String uuid, OrderByComparator<FichierMatiere> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fichier matiere
	 * @throws NoSuchFichierMatiereException if a matching fichier matiere could not be found
	 */
	public static FichierMatiere findByUuid_Last(
			String uuid, OrderByComparator<FichierMatiere> orderByComparator)
		throws fichiermatiere.exception.NoSuchFichierMatiereException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fichier matiere, or <code>null</code> if a matching fichier matiere could not be found
	 */
	public static FichierMatiere fetchByUuid_Last(
		String uuid, OrderByComparator<FichierMatiere> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static FichierMatiere[] findByUuid_PrevAndNext(
			long fichierMatiereId, String uuid,
			OrderByComparator<FichierMatiere> orderByComparator)
		throws fichiermatiere.exception.NoSuchFichierMatiereException {

		return getPersistence().findByUuid_PrevAndNext(
			fichierMatiereId, uuid, orderByComparator);
	}

	/**
	 * Removes all the fichier matieres where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of fichier matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fichier matieres
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the fichier matiere in the entity cache if it is enabled.
	 *
	 * @param fichierMatiere the fichier matiere
	 */
	public static void cacheResult(FichierMatiere fichierMatiere) {
		getPersistence().cacheResult(fichierMatiere);
	}

	/**
	 * Caches the fichier matieres in the entity cache if it is enabled.
	 *
	 * @param fichierMatieres the fichier matieres
	 */
	public static void cacheResult(List<FichierMatiere> fichierMatieres) {
		getPersistence().cacheResult(fichierMatieres);
	}

	/**
	 * Creates a new fichier matiere with the primary key. Does not add the fichier matiere to the database.
	 *
	 * @param fichierMatiereId the primary key for the new fichier matiere
	 * @return the new fichier matiere
	 */
	public static FichierMatiere create(long fichierMatiereId) {
		return getPersistence().create(fichierMatiereId);
	}

	/**
	 * Removes the fichier matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere that was removed
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	public static FichierMatiere remove(long fichierMatiereId)
		throws fichiermatiere.exception.NoSuchFichierMatiereException {

		return getPersistence().remove(fichierMatiereId);
	}

	public static FichierMatiere updateImpl(FichierMatiere fichierMatiere) {
		return getPersistence().updateImpl(fichierMatiere);
	}

	/**
	 * Returns the fichier matiere with the primary key or throws a <code>NoSuchFichierMatiereException</code> if it could not be found.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	public static FichierMatiere findByPrimaryKey(long fichierMatiereId)
		throws fichiermatiere.exception.NoSuchFichierMatiereException {

		return getPersistence().findByPrimaryKey(fichierMatiereId);
	}

	/**
	 * Returns the fichier matiere with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere, or <code>null</code> if a fichier matiere with the primary key could not be found
	 */
	public static FichierMatiere fetchByPrimaryKey(long fichierMatiereId) {
		return getPersistence().fetchByPrimaryKey(fichierMatiereId);
	}

	/**
	 * Returns all the fichier matieres.
	 *
	 * @return the fichier matieres
	 */
	public static List<FichierMatiere> findAll() {
		return getPersistence().findAll();
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
	public static List<FichierMatiere> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<FichierMatiere> findAll(
		int start, int end,
		OrderByComparator<FichierMatiere> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<FichierMatiere> findAll(
		int start, int end, OrderByComparator<FichierMatiere> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fichier matieres from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fichier matieres.
	 *
	 * @return the number of fichier matieres
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FichierMatierePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FichierMatierePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FichierMatierePersistence _persistence;

}