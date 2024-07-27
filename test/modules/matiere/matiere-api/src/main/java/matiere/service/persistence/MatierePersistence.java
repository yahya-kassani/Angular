/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import matiere.exception.NoSuchMatiereException;

import matiere.model.Matiere;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the matiere service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatiereUtil
 * @generated
 */
@ProviderType
public interface MatierePersistence extends BasePersistence<Matiere> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MatiereUtil} to access the matiere persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matieres
	 */
	public java.util.List<Matiere> findByUuid(String uuid);

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
	public java.util.List<Matiere> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Matiere> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

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
	public java.util.List<Matiere> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public Matiere findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Returns the first matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public Matiere fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

	/**
	 * Returns the last matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public Matiere findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Returns the last matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public Matiere fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

	/**
	 * Returns the matieres before and after the current matiere in the ordered set where uuid = &#63;.
	 *
	 * @param matiereId the primary key of the current matiere
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public Matiere[] findByUuid_PrevAndNext(
			long matiereId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Removes all the matieres where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matieres
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the matieres where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the matching matieres
	 */
	public java.util.List<Matiere> findByProfesseurId(long professeurId);

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
	public java.util.List<Matiere> findByProfesseurId(
		long professeurId, int start, int end);

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
	public java.util.List<Matiere> findByProfesseurId(
		long professeurId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

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
	public java.util.List<Matiere> findByProfesseurId(
		long professeurId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public Matiere findByProfesseurId_First(
			long professeurId,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Returns the first matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public Matiere fetchByProfesseurId_First(
		long professeurId,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

	/**
	 * Returns the last matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public Matiere findByProfesseurId_Last(
			long professeurId,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Returns the last matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public Matiere fetchByProfesseurId_Last(
		long professeurId,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

	/**
	 * Returns the matieres before and after the current matiere in the ordered set where professeurId = &#63;.
	 *
	 * @param matiereId the primary key of the current matiere
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public Matiere[] findByProfesseurId_PrevAndNext(
			long matiereId, long professeurId,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Removes all the matieres where professeurId = &#63; from the database.
	 *
	 * @param professeurId the professeur ID
	 */
	public void removeByProfesseurId(long professeurId);

	/**
	 * Returns the number of matieres where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the number of matching matieres
	 */
	public int countByProfesseurId(long professeurId);

	/**
	 * Returns all the matieres where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the matching matieres
	 */
	public java.util.List<Matiere> findByclasseId(long classeId);

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
	public java.util.List<Matiere> findByclasseId(
		long classeId, int start, int end);

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
	public java.util.List<Matiere> findByclasseId(
		long classeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

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
	public java.util.List<Matiere> findByclasseId(
		long classeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public Matiere findByclasseId_First(
			long classeId,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Returns the first matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public Matiere fetchByclasseId_First(
		long classeId,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

	/**
	 * Returns the last matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere
	 * @throws NoSuchMatiereException if a matching matiere could not be found
	 */
	public Matiere findByclasseId_Last(
			long classeId,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Returns the last matiere in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matiere, or <code>null</code> if a matching matiere could not be found
	 */
	public Matiere fetchByclasseId_Last(
		long classeId,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

	/**
	 * Returns the matieres before and after the current matiere in the ordered set where classeId = &#63;.
	 *
	 * @param matiereId the primary key of the current matiere
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public Matiere[] findByclasseId_PrevAndNext(
			long matiereId, long classeId,
			com.liferay.portal.kernel.util.OrderByComparator<Matiere>
				orderByComparator)
		throws NoSuchMatiereException;

	/**
	 * Removes all the matieres where classeId = &#63; from the database.
	 *
	 * @param classeId the classe ID
	 */
	public void removeByclasseId(long classeId);

	/**
	 * Returns the number of matieres where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the number of matching matieres
	 */
	public int countByclasseId(long classeId);

	/**
	 * Caches the matiere in the entity cache if it is enabled.
	 *
	 * @param matiere the matiere
	 */
	public void cacheResult(Matiere matiere);

	/**
	 * Caches the matieres in the entity cache if it is enabled.
	 *
	 * @param matieres the matieres
	 */
	public void cacheResult(java.util.List<Matiere> matieres);

	/**
	 * Creates a new matiere with the primary key. Does not add the matiere to the database.
	 *
	 * @param matiereId the primary key for the new matiere
	 * @return the new matiere
	 */
	public Matiere create(long matiereId);

	/**
	 * Removes the matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere that was removed
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public Matiere remove(long matiereId) throws NoSuchMatiereException;

	public Matiere updateImpl(Matiere matiere);

	/**
	 * Returns the matiere with the primary key or throws a <code>NoSuchMatiereException</code> if it could not be found.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere
	 * @throws NoSuchMatiereException if a matiere with the primary key could not be found
	 */
	public Matiere findByPrimaryKey(long matiereId)
		throws NoSuchMatiereException;

	/**
	 * Returns the matiere with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere, or <code>null</code> if a matiere with the primary key could not be found
	 */
	public Matiere fetchByPrimaryKey(long matiereId);

	/**
	 * Returns all the matieres.
	 *
	 * @return the matieres
	 */
	public java.util.List<Matiere> findAll();

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
	public java.util.List<Matiere> findAll(int start, int end);

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
	public java.util.List<Matiere> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator);

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
	public java.util.List<Matiere> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Matiere>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the matieres from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of matieres.
	 *
	 * @return the number of matieres
	 */
	public int countAll();

}