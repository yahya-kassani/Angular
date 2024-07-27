/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import etudiant.exception.NoSuchEtudiantException;

import etudiant.model.Etudiant;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the etudiant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EtudiantUtil
 * @generated
 */
@ProviderType
public interface EtudiantPersistence extends BasePersistence<Etudiant> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EtudiantUtil} to access the etudiant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the etudiants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching etudiants
	 */
	public java.util.List<Etudiant> findByUuid(String uuid);

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
	public java.util.List<Etudiant> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Etudiant> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
			orderByComparator);

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
	public java.util.List<Etudiant> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etudiant
	 * @throws NoSuchEtudiantException if a matching etudiant could not be found
	 */
	public Etudiant findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
				orderByComparator)
		throws NoSuchEtudiantException;

	/**
	 * Returns the first etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching etudiant, or <code>null</code> if a matching etudiant could not be found
	 */
	public Etudiant fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
			orderByComparator);

	/**
	 * Returns the last etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etudiant
	 * @throws NoSuchEtudiantException if a matching etudiant could not be found
	 */
	public Etudiant findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
				orderByComparator)
		throws NoSuchEtudiantException;

	/**
	 * Returns the last etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching etudiant, or <code>null</code> if a matching etudiant could not be found
	 */
	public Etudiant fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
			orderByComparator);

	/**
	 * Returns the etudiants before and after the current etudiant in the ordered set where uuid = &#63;.
	 *
	 * @param etudiantId the primary key of the current etudiant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next etudiant
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	public Etudiant[] findByUuid_PrevAndNext(
			long etudiantId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
				orderByComparator)
		throws NoSuchEtudiantException;

	/**
	 * Removes all the etudiants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of etudiants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching etudiants
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the etudiant in the entity cache if it is enabled.
	 *
	 * @param etudiant the etudiant
	 */
	public void cacheResult(Etudiant etudiant);

	/**
	 * Caches the etudiants in the entity cache if it is enabled.
	 *
	 * @param etudiants the etudiants
	 */
	public void cacheResult(java.util.List<Etudiant> etudiants);

	/**
	 * Creates a new etudiant with the primary key. Does not add the etudiant to the database.
	 *
	 * @param etudiantId the primary key for the new etudiant
	 * @return the new etudiant
	 */
	public Etudiant create(long etudiantId);

	/**
	 * Removes the etudiant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant that was removed
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	public Etudiant remove(long etudiantId) throws NoSuchEtudiantException;

	public Etudiant updateImpl(Etudiant etudiant);

	/**
	 * Returns the etudiant with the primary key or throws a <code>NoSuchEtudiantException</code> if it could not be found.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant
	 * @throws NoSuchEtudiantException if a etudiant with the primary key could not be found
	 */
	public Etudiant findByPrimaryKey(long etudiantId)
		throws NoSuchEtudiantException;

	/**
	 * Returns the etudiant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant, or <code>null</code> if a etudiant with the primary key could not be found
	 */
	public Etudiant fetchByPrimaryKey(long etudiantId);

	/**
	 * Returns all the etudiants.
	 *
	 * @return the etudiants
	 */
	public java.util.List<Etudiant> findAll();

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
	public java.util.List<Etudiant> findAll(int start, int end);

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
	public java.util.List<Etudiant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
			orderByComparator);

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
	public java.util.List<Etudiant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Etudiant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the etudiants from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of etudiants.
	 *
	 * @return the number of etudiants
	 */
	public int countAll();

}