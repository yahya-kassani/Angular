/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fichiermatiere.exception.NoSuchFichierMatiereException;

import fichiermatiere.model.FichierMatiere;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fichier matiere service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiereUtil
 * @generated
 */
@ProviderType
public interface FichierMatierePersistence
	extends BasePersistence<FichierMatiere> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FichierMatiereUtil} to access the fichier matiere persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fichier matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fichier matieres
	 */
	public java.util.List<FichierMatiere> findByUuid(String uuid);

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
	public java.util.List<FichierMatiere> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FichierMatiere> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
			orderByComparator);

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
	public java.util.List<FichierMatiere> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fichier matiere
	 * @throws NoSuchFichierMatiereException if a matching fichier matiere could not be found
	 */
	public FichierMatiere findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
				orderByComparator)
		throws NoSuchFichierMatiereException;

	/**
	 * Returns the first fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fichier matiere, or <code>null</code> if a matching fichier matiere could not be found
	 */
	public FichierMatiere fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
			orderByComparator);

	/**
	 * Returns the last fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fichier matiere
	 * @throws NoSuchFichierMatiereException if a matching fichier matiere could not be found
	 */
	public FichierMatiere findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
				orderByComparator)
		throws NoSuchFichierMatiereException;

	/**
	 * Returns the last fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fichier matiere, or <code>null</code> if a matching fichier matiere could not be found
	 */
	public FichierMatiere fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
			orderByComparator);

	/**
	 * Returns the fichier matieres before and after the current fichier matiere in the ordered set where uuid = &#63;.
	 *
	 * @param fichierMatiereId the primary key of the current fichier matiere
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fichier matiere
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	public FichierMatiere[] findByUuid_PrevAndNext(
			long fichierMatiereId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
				orderByComparator)
		throws NoSuchFichierMatiereException;

	/**
	 * Removes all the fichier matieres where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of fichier matieres where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fichier matieres
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the fichier matiere in the entity cache if it is enabled.
	 *
	 * @param fichierMatiere the fichier matiere
	 */
	public void cacheResult(FichierMatiere fichierMatiere);

	/**
	 * Caches the fichier matieres in the entity cache if it is enabled.
	 *
	 * @param fichierMatieres the fichier matieres
	 */
	public void cacheResult(java.util.List<FichierMatiere> fichierMatieres);

	/**
	 * Creates a new fichier matiere with the primary key. Does not add the fichier matiere to the database.
	 *
	 * @param fichierMatiereId the primary key for the new fichier matiere
	 * @return the new fichier matiere
	 */
	public FichierMatiere create(long fichierMatiereId);

	/**
	 * Removes the fichier matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere that was removed
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	public FichierMatiere remove(long fichierMatiereId)
		throws NoSuchFichierMatiereException;

	public FichierMatiere updateImpl(FichierMatiere fichierMatiere);

	/**
	 * Returns the fichier matiere with the primary key or throws a <code>NoSuchFichierMatiereException</code> if it could not be found.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere
	 * @throws NoSuchFichierMatiereException if a fichier matiere with the primary key could not be found
	 */
	public FichierMatiere findByPrimaryKey(long fichierMatiereId)
		throws NoSuchFichierMatiereException;

	/**
	 * Returns the fichier matiere with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere, or <code>null</code> if a fichier matiere with the primary key could not be found
	 */
	public FichierMatiere fetchByPrimaryKey(long fichierMatiereId);

	/**
	 * Returns all the fichier matieres.
	 *
	 * @return the fichier matieres
	 */
	public java.util.List<FichierMatiere> findAll();

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
	public java.util.List<FichierMatiere> findAll(int start, int end);

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
	public java.util.List<FichierMatiere> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
			orderByComparator);

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
	public java.util.List<FichierMatiere> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FichierMatiere>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fichier matieres from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fichier matieres.
	 *
	 * @return the number of fichier matieres
	 */
	public int countAll();

}