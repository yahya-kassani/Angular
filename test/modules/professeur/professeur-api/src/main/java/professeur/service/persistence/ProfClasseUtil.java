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

import professeur.model.ProfClasse;

/**
 * The persistence utility for the prof classe service. This utility wraps <code>professeur.service.persistence.impl.ProfClassePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfClassePersistence
 * @generated
 */
public class ProfClasseUtil {

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
	public static void clearCache(ProfClasse profClasse) {
		getPersistence().clearCache(profClasse);
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
	public static Map<Serializable, ProfClasse> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfClasse> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfClasse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfClasse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfClasse update(ProfClasse profClasse) {
		return getPersistence().update(profClasse);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfClasse update(
		ProfClasse profClasse, ServiceContext serviceContext) {

		return getPersistence().update(profClasse, serviceContext);
	}

	/**
	 * Returns all the prof classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prof classes
	 */
	public static List<ProfClasse> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<ProfClasse> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<ProfClasse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<ProfClasse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public static ProfClasse findByUuid_First(
			String uuid, OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public static ProfClasse fetchByUuid_First(
		String uuid, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public static ProfClasse findByUuid_Last(
			String uuid, OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public static ProfClasse fetchByUuid_Last(
		String uuid, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static ProfClasse[] findByUuid_PrevAndNext(
			long profClasseId, String uuid,
			OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByUuid_PrevAndNext(
			profClasseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the prof classes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of prof classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prof classes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the prof classes where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the matching prof classes
	 */
	public static List<ProfClasse> findByProfesseurId(long professeurId) {
		return getPersistence().findByProfesseurId(professeurId);
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
	public static List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end) {

		return getPersistence().findByProfesseurId(professeurId, start, end);
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
	public static List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().findByProfesseurId(
			professeurId, start, end, orderByComparator);
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
	public static List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProfesseurId(
			professeurId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public static ProfClasse findByProfesseurId_First(
			long professeurId, OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByProfesseurId_First(
			professeurId, orderByComparator);
	}

	/**
	 * Returns the first prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public static ProfClasse fetchByProfesseurId_First(
		long professeurId, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().fetchByProfesseurId_First(
			professeurId, orderByComparator);
	}

	/**
	 * Returns the last prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public static ProfClasse findByProfesseurId_Last(
			long professeurId, OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByProfesseurId_Last(
			professeurId, orderByComparator);
	}

	/**
	 * Returns the last prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public static ProfClasse fetchByProfesseurId_Last(
		long professeurId, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().fetchByProfesseurId_Last(
			professeurId, orderByComparator);
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
	public static ProfClasse[] findByProfesseurId_PrevAndNext(
			long profClasseId, long professeurId,
			OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByProfesseurId_PrevAndNext(
			profClasseId, professeurId, orderByComparator);
	}

	/**
	 * Removes all the prof classes where professeurId = &#63; from the database.
	 *
	 * @param professeurId the professeur ID
	 */
	public static void removeByProfesseurId(long professeurId) {
		getPersistence().removeByProfesseurId(professeurId);
	}

	/**
	 * Returns the number of prof classes where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the number of matching prof classes
	 */
	public static int countByProfesseurId(long professeurId) {
		return getPersistence().countByProfesseurId(professeurId);
	}

	/**
	 * Returns all the prof classes where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the matching prof classes
	 */
	public static List<ProfClasse> findByclasseId(long classeId) {
		return getPersistence().findByclasseId(classeId);
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
	public static List<ProfClasse> findByclasseId(
		long classeId, int start, int end) {

		return getPersistence().findByclasseId(classeId, start, end);
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
	public static List<ProfClasse> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().findByclasseId(
			classeId, start, end, orderByComparator);
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
	public static List<ProfClasse> findByclasseId(
		long classeId, int start, int end,
		OrderByComparator<ProfClasse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByclasseId(
			classeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public static ProfClasse findByclasseId_First(
			long classeId, OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByclasseId_First(
			classeId, orderByComparator);
	}

	/**
	 * Returns the first prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public static ProfClasse fetchByclasseId_First(
		long classeId, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().fetchByclasseId_First(
			classeId, orderByComparator);
	}

	/**
	 * Returns the last prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public static ProfClasse findByclasseId_Last(
			long classeId, OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByclasseId_Last(
			classeId, orderByComparator);
	}

	/**
	 * Returns the last prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public static ProfClasse fetchByclasseId_Last(
		long classeId, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().fetchByclasseId_Last(
			classeId, orderByComparator);
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
	public static ProfClasse[] findByclasseId_PrevAndNext(
			long profClasseId, long classeId,
			OrderByComparator<ProfClasse> orderByComparator)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByclasseId_PrevAndNext(
			profClasseId, classeId, orderByComparator);
	}

	/**
	 * Removes all the prof classes where classeId = &#63; from the database.
	 *
	 * @param classeId the classe ID
	 */
	public static void removeByclasseId(long classeId) {
		getPersistence().removeByclasseId(classeId);
	}

	/**
	 * Returns the number of prof classes where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the number of matching prof classes
	 */
	public static int countByclasseId(long classeId) {
		return getPersistence().countByclasseId(classeId);
	}

	/**
	 * Caches the prof classe in the entity cache if it is enabled.
	 *
	 * @param profClasse the prof classe
	 */
	public static void cacheResult(ProfClasse profClasse) {
		getPersistence().cacheResult(profClasse);
	}

	/**
	 * Caches the prof classes in the entity cache if it is enabled.
	 *
	 * @param profClasses the prof classes
	 */
	public static void cacheResult(List<ProfClasse> profClasses) {
		getPersistence().cacheResult(profClasses);
	}

	/**
	 * Creates a new prof classe with the primary key. Does not add the prof classe to the database.
	 *
	 * @param profClasseId the primary key for the new prof classe
	 * @return the new prof classe
	 */
	public static ProfClasse create(long profClasseId) {
		return getPersistence().create(profClasseId);
	}

	/**
	 * Removes the prof classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe that was removed
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public static ProfClasse remove(long profClasseId)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().remove(profClasseId);
	}

	public static ProfClasse updateImpl(ProfClasse profClasse) {
		return getPersistence().updateImpl(profClasse);
	}

	/**
	 * Returns the prof classe with the primary key or throws a <code>NoSuchProfClasseException</code> if it could not be found.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public static ProfClasse findByPrimaryKey(long profClasseId)
		throws professeur.exception.NoSuchProfClasseException {

		return getPersistence().findByPrimaryKey(profClasseId);
	}

	/**
	 * Returns the prof classe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe, or <code>null</code> if a prof classe with the primary key could not be found
	 */
	public static ProfClasse fetchByPrimaryKey(long profClasseId) {
		return getPersistence().fetchByPrimaryKey(profClasseId);
	}

	/**
	 * Returns all the prof classes.
	 *
	 * @return the prof classes
	 */
	public static List<ProfClasse> findAll() {
		return getPersistence().findAll();
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
	public static List<ProfClasse> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ProfClasse> findAll(
		int start, int end, OrderByComparator<ProfClasse> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ProfClasse> findAll(
		int start, int end, OrderByComparator<ProfClasse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the prof classes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of prof classes.
	 *
	 * @return the number of prof classes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfClassePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProfClassePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProfClassePersistence _persistence;

}