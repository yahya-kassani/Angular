/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.service.persistence;

import classe.exception.NoSuchClasseException;

import classe.model.Classe;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the classe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClasseUtil
 * @generated
 */
@ProviderType
public interface ClassePersistence extends BasePersistence<Classe> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClasseUtil} to access the classe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching classes
	 */
	public java.util.List<Classe> findByUuid(String uuid);

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
	public java.util.List<Classe> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Classe> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Classe>
			orderByComparator);

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
	public java.util.List<Classe> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Classe>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching classe
	 * @throws NoSuchClasseException if a matching classe could not be found
	 */
	public Classe findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Classe>
				orderByComparator)
		throws NoSuchClasseException;

	/**
	 * Returns the first classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching classe, or <code>null</code> if a matching classe could not be found
	 */
	public Classe fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Classe>
			orderByComparator);

	/**
	 * Returns the last classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching classe
	 * @throws NoSuchClasseException if a matching classe could not be found
	 */
	public Classe findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Classe>
				orderByComparator)
		throws NoSuchClasseException;

	/**
	 * Returns the last classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching classe, or <code>null</code> if a matching classe could not be found
	 */
	public Classe fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Classe>
			orderByComparator);

	/**
	 * Returns the classes before and after the current classe in the ordered set where uuid = &#63;.
	 *
	 * @param classeId the primary key of the current classe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	public Classe[] findByUuid_PrevAndNext(
			long classeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Classe>
				orderByComparator)
		throws NoSuchClasseException;

	/**
	 * Removes all the classes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching classes
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the classe in the entity cache if it is enabled.
	 *
	 * @param classe the classe
	 */
	public void cacheResult(Classe classe);

	/**
	 * Caches the classes in the entity cache if it is enabled.
	 *
	 * @param classes the classes
	 */
	public void cacheResult(java.util.List<Classe> classes);

	/**
	 * Creates a new classe with the primary key. Does not add the classe to the database.
	 *
	 * @param classeId the primary key for the new classe
	 * @return the new classe
	 */
	public Classe create(long classeId);

	/**
	 * Removes the classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe that was removed
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	public Classe remove(long classeId) throws NoSuchClasseException;

	public Classe updateImpl(Classe classe);

	/**
	 * Returns the classe with the primary key or throws a <code>NoSuchClasseException</code> if it could not be found.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe
	 * @throws NoSuchClasseException if a classe with the primary key could not be found
	 */
	public Classe findByPrimaryKey(long classeId) throws NoSuchClasseException;

	/**
	 * Returns the classe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe, or <code>null</code> if a classe with the primary key could not be found
	 */
	public Classe fetchByPrimaryKey(long classeId);

	/**
	 * Returns all the classes.
	 *
	 * @return the classes
	 */
	public java.util.List<Classe> findAll();

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
	public java.util.List<Classe> findAll(int start, int end);

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
	public java.util.List<Classe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Classe>
			orderByComparator);

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
	public java.util.List<Classe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Classe>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the classes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of classes.
	 *
	 * @return the number of classes
	 */
	public int countAll();

}