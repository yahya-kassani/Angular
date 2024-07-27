/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import professeur.exception.NoSuchProfClasseException;

import professeur.model.ProfClasse;

/**
 * The persistence interface for the prof classe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfClasseUtil
 * @generated
 */
@ProviderType
public interface ProfClassePersistence extends BasePersistence<ProfClasse> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProfClasseUtil} to access the prof classe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the prof classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching prof classes
	 */
	public java.util.List<ProfClasse> findByUuid(String uuid);

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
	public java.util.List<ProfClasse> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProfClasse> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

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
	public java.util.List<ProfClasse> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public ProfClasse findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Returns the first prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public ProfClasse fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

	/**
	 * Returns the last prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public ProfClasse findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Returns the last prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public ProfClasse fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

	/**
	 * Returns the prof classes before and after the current prof classe in the ordered set where uuid = &#63;.
	 *
	 * @param profClasseId the primary key of the current prof classe
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public ProfClasse[] findByUuid_PrevAndNext(
			long profClasseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Removes all the prof classes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of prof classes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching prof classes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the prof classes where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the matching prof classes
	 */
	public java.util.List<ProfClasse> findByProfesseurId(long professeurId);

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
	public java.util.List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end);

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
	public java.util.List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

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
	public java.util.List<ProfClasse> findByProfesseurId(
		long professeurId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public ProfClasse findByProfesseurId_First(
			long professeurId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Returns the first prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public ProfClasse fetchByProfesseurId_First(
		long professeurId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

	/**
	 * Returns the last prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public ProfClasse findByProfesseurId_Last(
			long professeurId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Returns the last prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public ProfClasse fetchByProfesseurId_Last(
		long professeurId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

	/**
	 * Returns the prof classes before and after the current prof classe in the ordered set where professeurId = &#63;.
	 *
	 * @param profClasseId the primary key of the current prof classe
	 * @param professeurId the professeur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public ProfClasse[] findByProfesseurId_PrevAndNext(
			long profClasseId, long professeurId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Removes all the prof classes where professeurId = &#63; from the database.
	 *
	 * @param professeurId the professeur ID
	 */
	public void removeByProfesseurId(long professeurId);

	/**
	 * Returns the number of prof classes where professeurId = &#63;.
	 *
	 * @param professeurId the professeur ID
	 * @return the number of matching prof classes
	 */
	public int countByProfesseurId(long professeurId);

	/**
	 * Returns all the prof classes where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the matching prof classes
	 */
	public java.util.List<ProfClasse> findByclasseId(long classeId);

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
	public java.util.List<ProfClasse> findByclasseId(
		long classeId, int start, int end);

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
	public java.util.List<ProfClasse> findByclasseId(
		long classeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

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
	public java.util.List<ProfClasse> findByclasseId(
		long classeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public ProfClasse findByclasseId_First(
			long classeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Returns the first prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public ProfClasse fetchByclasseId_First(
		long classeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

	/**
	 * Returns the last prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe
	 * @throws NoSuchProfClasseException if a matching prof classe could not be found
	 */
	public ProfClasse findByclasseId_Last(
			long classeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Returns the last prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prof classe, or <code>null</code> if a matching prof classe could not be found
	 */
	public ProfClasse fetchByclasseId_Last(
		long classeId,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

	/**
	 * Returns the prof classes before and after the current prof classe in the ordered set where classeId = &#63;.
	 *
	 * @param profClasseId the primary key of the current prof classe
	 * @param classeId the classe ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public ProfClasse[] findByclasseId_PrevAndNext(
			long profClasseId, long classeId,
			com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
				orderByComparator)
		throws NoSuchProfClasseException;

	/**
	 * Removes all the prof classes where classeId = &#63; from the database.
	 *
	 * @param classeId the classe ID
	 */
	public void removeByclasseId(long classeId);

	/**
	 * Returns the number of prof classes where classeId = &#63;.
	 *
	 * @param classeId the classe ID
	 * @return the number of matching prof classes
	 */
	public int countByclasseId(long classeId);

	/**
	 * Caches the prof classe in the entity cache if it is enabled.
	 *
	 * @param profClasse the prof classe
	 */
	public void cacheResult(ProfClasse profClasse);

	/**
	 * Caches the prof classes in the entity cache if it is enabled.
	 *
	 * @param profClasses the prof classes
	 */
	public void cacheResult(java.util.List<ProfClasse> profClasses);

	/**
	 * Creates a new prof classe with the primary key. Does not add the prof classe to the database.
	 *
	 * @param profClasseId the primary key for the new prof classe
	 * @return the new prof classe
	 */
	public ProfClasse create(long profClasseId);

	/**
	 * Removes the prof classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe that was removed
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public ProfClasse remove(long profClasseId)
		throws NoSuchProfClasseException;

	public ProfClasse updateImpl(ProfClasse profClasse);

	/**
	 * Returns the prof classe with the primary key or throws a <code>NoSuchProfClasseException</code> if it could not be found.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe
	 * @throws NoSuchProfClasseException if a prof classe with the primary key could not be found
	 */
	public ProfClasse findByPrimaryKey(long profClasseId)
		throws NoSuchProfClasseException;

	/**
	 * Returns the prof classe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe, or <code>null</code> if a prof classe with the primary key could not be found
	 */
	public ProfClasse fetchByPrimaryKey(long profClasseId);

	/**
	 * Returns all the prof classes.
	 *
	 * @return the prof classes
	 */
	public java.util.List<ProfClasse> findAll();

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
	public java.util.List<ProfClasse> findAll(int start, int end);

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
	public java.util.List<ProfClasse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator);

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
	public java.util.List<ProfClasse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProfClasse>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the prof classes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of prof classes.
	 *
	 * @return the number of prof classes
	 */
	public int countAll();

}