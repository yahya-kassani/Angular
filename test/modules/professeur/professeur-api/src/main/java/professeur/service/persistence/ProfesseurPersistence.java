/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import professeur.exception.NoSuchProfesseurException;

import professeur.model.Professeur;

/**
 * The persistence interface for the professeur service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfesseurUtil
 * @generated
 */
@ProviderType
public interface ProfesseurPersistence extends BasePersistence<Professeur> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfesseurUtil} to access the professeur persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the professeurs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professeurs
	 */
	public java.util.List<Professeur> findByUuid(String uuid);

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
	public java.util.List<Professeur> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Professeur> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Professeur>
			orderByComparator);

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
	public java.util.List<Professeur> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Professeur>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professeur
	 * @throws NoSuchProfesseurException if a matching professeur could not be found
	 */
	public Professeur findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Professeur>
				orderByComparator)
		throws NoSuchProfesseurException;

	/**
	 * Returns the first professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professeur, or <code>null</code> if a matching professeur could not be found
	 */
	public Professeur fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Professeur>
			orderByComparator);

	/**
	 * Returns the last professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professeur
	 * @throws NoSuchProfesseurException if a matching professeur could not be found
	 */
	public Professeur findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Professeur>
				orderByComparator)
		throws NoSuchProfesseurException;

	/**
	 * Returns the last professeur in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professeur, or <code>null</code> if a matching professeur could not be found
	 */
	public Professeur fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Professeur>
			orderByComparator);

	/**
	 * Returns the professeurs before and after the current professeur in the ordered set where uuid = &#63;.
	 *
	 * @param professeurId the primary key of the current professeur
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professeur
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	public Professeur[] findByUuid_PrevAndNext(
			long professeurId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Professeur>
				orderByComparator)
		throws NoSuchProfesseurException;

	/**
	 * Removes all the professeurs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of professeurs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professeurs
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the professeur in the entity cache if it is enabled.
	 *
	 * @param professeur the professeur
	 */
	public void cacheResult(Professeur professeur);

	/**
	 * Caches the professeurs in the entity cache if it is enabled.
	 *
	 * @param professeurs the professeurs
	 */
	public void cacheResult(java.util.List<Professeur> professeurs);

	/**
	 * Creates a new professeur with the primary key. Does not add the professeur to the database.
	 *
	 * @param professeurId the primary key for the new professeur
	 * @return the new professeur
	 */
	public Professeur create(long professeurId);

	/**
	 * Removes the professeur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur that was removed
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	public Professeur remove(long professeurId)
		throws NoSuchProfesseurException;

	public Professeur updateImpl(Professeur professeur);

	/**
	 * Returns the professeur with the primary key or throws a <code>NoSuchProfesseurException</code> if it could not be found.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur
	 * @throws NoSuchProfesseurException if a professeur with the primary key could not be found
	 */
	public Professeur findByPrimaryKey(long professeurId)
		throws NoSuchProfesseurException;

	/**
	 * Returns the professeur with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur, or <code>null</code> if a professeur with the primary key could not be found
	 */
	public Professeur fetchByPrimaryKey(long professeurId);

	/**
	 * Returns all the professeurs.
	 *
	 * @return the professeurs
	 */
	public java.util.List<Professeur> findAll();

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
	public java.util.List<Professeur> findAll(int start, int end);

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
	public java.util.List<Professeur> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Professeur>
			orderByComparator);

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
	public java.util.List<Professeur> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Professeur>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the professeurs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of professeurs.
	 *
	 * @return the number of professeurs
	 */
	public int countAll();

}