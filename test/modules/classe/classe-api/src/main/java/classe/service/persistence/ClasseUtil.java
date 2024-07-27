/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.service.persistence;

import classe.model.Classe;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the classe service. This utility wraps <code>classe.service.persistence.impl.ClassePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClassePersistence
 * @generated
 */
public class ClasseUtil {

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
	public static void clearCache(Classe classe) {
		getPersistence().clearCache(classe);
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
	public static Map<Serializable, Classe> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Classe> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Classe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Classe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Classe> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Classe update(Classe classe) {
		return getPersistence().update(classe);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Classe update(Classe classe, ServiceContext serviceContext) {
		return getPersistence().update(classe, serviceContext);
	}

	/**
	 * Returns all the classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching classes
	 */
	public static List<Classe> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @return the range of matching classes
	 */
	public static List<Classe> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching classes
	 */
	public static List<Classe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Classe> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the classes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching classes
	 */
	public static List<Classe> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Classe> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching classe
	 * @throws NoSuchClasseException if a matching classe could not be found
	 */
	public static Classe findByUuid_First(
			String uuid, OrderByComparator<Classe> orderByComparator)
		throws classe.exception.NoSuchClasseException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching classe, or <code>null</code> if a matching classe could not be found
	 */
	public static Classe fetchByUuid_First(
		String uuid, OrderByComparator<Classe> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching classe
	 * @throws NoSuchClasseException if a matching classe could not be found
	 */
	public static Classe findByUuid_Last(
			String uuid, OrderByComparator<Classe> orderByComparator)
		throws classe.exception.NoSuchClasseException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching classe, or <code>null</code> if a matching classe could not be found
	 */
	public static Classe fetchByUuid_Last(
		String uuid, OrderByComparator<Classe> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the classes before and after the current classe in the ordered set where uuid = &#63;.
	 *
	 * @param classeId the primary key of the current classe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	public static Classe[] findByUuid_PrevAndNext(
			long classeId, String uuid,
			OrderByComparator<Classe> orderByComparator)
		throws classe.exception.NoSuchClasseException {

		return getPersistence().findByUuid_PrevAndNext(
			classeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the classes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching classes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the classe in the entity cache if it is enabled.
	 *
	 * @param classe the classe
	 */
	public static void cacheResult(Classe classe) {
		getPersistence().cacheResult(classe);
	}

	/**
	 * Caches the classes in the entity cache if it is enabled.
	 *
	 * @param classes the classes
	 */
	public static void cacheResult(List<Classe> classes) {
		getPersistence().cacheResult(classes);
	}

	/**
	 * Creates a new classe with the primary key. Does not add the classe to the database.
	 *
	 * @param classeId the primary key for the new classe
	 * @return the new classe
	 */
	public static Classe create(long classeId) {
		return getPersistence().create(classeId);
	}

	/**
	 * Removes the classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe that was removed
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	public static Classe remove(long classeId)
		throws classe.exception.NoSuchClasseException {

		return getPersistence().remove(classeId);
	}

	public static Classe updateImpl(Classe classe) {
		return getPersistence().updateImpl(classe);
	}

	/**
	 * Returns the classe with the primary key or throws a <code>NoSuchClasseException</code> if it could not be found.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	public static Classe findByPrimaryKey(long classeId)
		throws classe.exception.NoSuchClasseException {

		return getPersistence().findByPrimaryKey(classeId);
	}

	/**
	 * Returns the classe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe, or <code>null</code> if a classe with the primary key could not be found
	 */
	public static Classe fetchByPrimaryKey(long classeId) {
		return getPersistence().fetchByPrimaryKey(classeId);
	}

	/**
	 * Returns all the classes.
	 *
	 * @return the classes
	 */
	public static List<Classe> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @return the range of classes
	 */
	public static List<Classe> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of classes
	 */
	public static List<Classe> findAll(
		int start, int end, OrderByComparator<Classe> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of classes
	 */
	public static List<Classe> findAll(
		int start, int end, OrderByComparator<Classe> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the classes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of classes.
	 *
	 * @return the number of classes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ClassePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ClassePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ClassePersistence _persistence;

}