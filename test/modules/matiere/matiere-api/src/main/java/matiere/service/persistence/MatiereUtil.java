/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import matiere.model.Matiere;

/**
 * The persistence utility for the matiere service. This utility wraps <code>matiere.service.persistence.impl.MatierePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatierePersistence
 * @generated
 */
public class MatiereUtil {

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
	public static void clearCache(Matiere matiere) {
		getPersistence().clearCache(matiere);
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
	public static Map<Serializable, Matiere> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Matiere> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Matiere> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Matiere> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Matiere update(Matiere matiere) {
		return getPersistence().update(matiere);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Matiere update(
		Matiere matiere, ServiceContext serviceContext) {

		return getPersistence().update(matiere, serviceContext);
	}

	/**
	 * Returns all the matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matieres
	 */
	public static List<Matiere> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Matiere> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Matiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Matiere> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Matiere> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public static Matiere findByUuid_First(
			String uuid, OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public static Matiere fetchByUuid_First(
		String uuid, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public static Matiere findByUuid_Last(
			String uuid, OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public static Matiere fetchByUuid_Last(
		String uuid, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Matiere[] findByUuid_PrevAndNext(
			long matiereId, String uuid,
			OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByUuid_PrevAndNext(
			matiereId, uuid, orderByComparator);
	}

	/**
	 * Removes all the matieres where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matieres
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the matieres where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the matching matieres
	 */
	public static List<Matiere> findByProfesseurId(long professeurId) {
		return getPersistence().findByProfesseurId(professeurId);
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
	public static List<Matiere> findByProfesseurId(
		long professeurId, int start, int end) {

		return getPersistence().findByProfesseurId(professeurId, start, end);
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
	public static List<Matiere> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().findByProfesseurId(
			professeurId, start, end, orderByComparator);
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
	public static List<Matiere> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<Matiere> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProfesseurId(
			professeurId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public static Matiere findByProfesseurId_First(
			long professeurId, OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByProfesseurId_First(
			professeurId, orderByComparator);
	}

	/**
	 * Returns the first matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public static Matiere fetchByProfesseurId_First(
		long professeurId, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().fetchByProfesseurId_First(
			professeurId, orderByComparator);
	}

	/**
	 * Returns the last matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public static Matiere findByProfesseurId_Last(
			long professeurId, OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByProfesseurId_Last(
			professeurId, orderByComparator);
	}

	/**
	 * Returns the last matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public static Matiere fetchByProfesseurId_Last(
		long professeurId, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().fetchByProfesseurId_Last(
			professeurId, orderByComparator);
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
	public static Matiere[] findByProfesseurId_PrevAndNext(
			long matiereId, long professeurId,
			OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByProfesseurId_PrevAndNext(
			matiereId, professeurId, orderByComparator);
	}

	/**
	 * Removes all the matieres where professeurId = &#63; from the database.
	 *
	 * @param professeurId the professeur ID
	 */
	public static void removeByProfesseurId(long professeurId) {
		getPersistence().removeByProfesseurId(professeurId);
	}

	/**
	 * Returns the number of matieres where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the number of matching matieres
	 */
	public static int countByProfesseurId(long professeurId) {
		return getPersistence().countByProfesseurId(professeurId);
	}

	/**
	 * Returns all the matieres where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the matching matieres
	 */
	public static List<Matiere> findByclasseId(long classeId) {
		return getPersistence().findByclasseId(classeId);
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
	public static List<Matiere> findByclasseId(
		long classeId, int start, int end) {

		return getPersistence().findByclasseId(classeId, start, end);
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
	public static List<Matiere> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().findByclasseId(
			classeId, start, end, orderByComparator);
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
	public static List<Matiere> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<Matiere> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByclasseId(
			classeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public static Matiere findByclasseId_First(
			long classeId, OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByclasseId_First(
			classeId, orderByComparator);
	}

	/**
	 * Returns the first matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public static Matiere fetchByclasseId_First(
		long classeId, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().fetchByclasseId_First(
			classeId, orderByComparator);
	}

	/**
	 * Returns the last matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public static Matiere findByclasseId_Last(
			long classeId, OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByclasseId_Last(
			classeId, orderByComparator);
	}

	/**
	 * Returns the last matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public static Matiere fetchByclasseId_Last(
		long classeId, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().fetchByclasseId_Last(
			classeId, orderByComparator);
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
	public static Matiere[] findByclasseId_PrevAndNext(
			long matiereId, long classeId,
			OrderByComparator<Matiere> orderByComparator)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByclasseId_PrevAndNext(
			matiereId, classeId, orderByComparator);
	}

	/**
	 * Removes all the matieres where classeId = &#63; from the database.
	 *
	 * @param classeId the classe ID
	 */
	public static void removeByclasseId(long classeId) {
		getPersistence().removeByclasseId(classeId);
	}

	/**
	 * Returns the number of matieres where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the number of matching matieres
	 */
	public static int countByclasseId(long classeId) {
		return getPersistence().countByclasseId(classeId);
	}

	/**
	 * Caches the matiere in the entity cache if it is enabled.
	 *
	 * @param matiere the matiere
	 */
	public static void cacheResult(Matiere matiere) {
		getPersistence().cacheResult(matiere);
	}

	/**
	 * Caches the matieres in the entity cache if it is enabled.
	 *
	 * @param matieres the matieres
	 */
	public static void cacheResult(List<Matiere> matieres) {
		getPersistence().cacheResult(matieres);
	}

	/**
	 * Creates a new matiere with the primary key. Does not add the matiere to the database.
	 *
	 * @param matiereId the primary key for the new matiere
	 * @return the new matiere
	 */
	public static Matiere create(long matiereId) {
		return getPersistence().create(matiereId);
	}

	/**
	 * Removes the matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere that was removed
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public static Matiere remove(long matiereId)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().remove(matiereId);
	}

	public static Matiere updateImpl(Matiere matiere) {
		return getPersistence().updateImpl(matiere);
	}

	/**
	 * Returns the matiere with the primary key or throws a <code>NoSuchMatiereException</code> if it could not be found.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public static Matiere findByPrimaryKey(long matiereId)
		throws matiere.exception.NoSuchMatiereException {

		return getPersistence().findByPrimaryKey(matiereId);
	}

	/**
	 * Returns the matiere with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere, or <code>null</code> if a matiere with the primary key could not be found
	 */
	public static Matiere fetchByPrimaryKey(long matiereId) {
		return getPersistence().fetchByPrimaryKey(matiereId);
	}

	/**
	 * Returns all the matieres.
	 *
	 * @return the matieres
	 */
	public static List<Matiere> findAll() {
		return getPersistence().findAll();
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
	public static List<Matiere> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Matiere> findAll(
		int start, int end, OrderByComparator<Matiere> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Matiere> findAll(
		int start, int end, OrderByComparator<Matiere> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the matieres from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of matieres.
	 *
	 * @return the number of matieres
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MatierePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MatierePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MatierePersistence _persistence;

}