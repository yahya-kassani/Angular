/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import fichiermatiere.model.FichierMatiere;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FichierMatiere. This utility wraps
 * <code>fichiermatiere.service.impl.FichierMatiereLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiereLocalService
 * @generated
 */
public class FichierMatiereLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>fichiermatiere.service.impl.FichierMatiereLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static FichierMatiere add(long matiereId, long fichierId) {
		return getService().add(matiereId, fichierId);
	}

	/**
	 * Adds the fichier matiere to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FichierMatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fichierMatiere the fichier matiere
	 * @return the fichier matiere that was added
	 */
	public static FichierMatiere addFichierMatiere(
		FichierMatiere fichierMatiere) {

		return getService().addFichierMatiere(fichierMatiere);
	}

	/**
	 * Creates a new fichier matiere with the primary key. Does not add the fichier matiere to the database.
	 *
	 * @param fichierMatiereId the primary key for the new fichier matiere
	 * @return the new fichier matiere
	 */
	public static FichierMatiere createFichierMatiere(long fichierMatiereId) {
		return getService().createFichierMatiere(fichierMatiereId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the fichier matiere from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FichierMatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fichierMatiere the fichier matiere
	 * @return the fichier matiere that was removed
	 */
	public static FichierMatiere deleteFichierMatiere(
		FichierMatiere fichierMatiere) {

		return getService().deleteFichierMatiere(fichierMatiere);
	}

	/**
	 * Deletes the fichier matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FichierMatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere that was removed
	 * @throws PortalException if a fichier matiere with the primary key could not be found
	 */
	public static FichierMatiere deleteFichierMatiere(long fichierMatiereId)
		throws PortalException {

		return getService().deleteFichierMatiere(fichierMatiereId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fichiermatiere.model.impl.FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fichiermatiere.model.impl.FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FichierMatiere fetchFichierMatiere(long fichierMatiereId) {
		return getService().fetchFichierMatiere(fichierMatiereId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the fichier matiere with the primary key.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere
	 * @throws PortalException if a fichier matiere with the primary key could not be found
	 */
	public static FichierMatiere getFichierMatiere(long fichierMatiereId)
		throws PortalException {

		return getService().getFichierMatiere(fichierMatiereId);
	}

	/**
	 * Returns a range of all the fichier matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>fichiermatiere.model.impl.FichierMatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fichier matieres
	 * @param end the upper bound of the range of fichier matieres (not inclusive)
	 * @return the range of fichier matieres
	 */
	public static List<FichierMatiere> getFichierMatieres(int start, int end) {
		return getService().getFichierMatieres(start, end);
	}

	/**
	 * Returns the number of fichier matieres.
	 *
	 * @return the number of fichier matieres
	 */
	public static int getFichierMatieresCount() {
		return getService().getFichierMatieresCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static FichierMatiere update(
			long fichierMatiereId, long fichierId, long matiereId)
		throws PortalException {

		return getService().update(fichierMatiereId, fichierId, matiereId);
	}

	/**
	 * Updates the fichier matiere in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FichierMatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fichierMatiere the fichier matiere
	 * @return the fichier matiere that was updated
	 */
	public static FichierMatiere updateFichierMatiere(
		FichierMatiere fichierMatiere) {

		return getService().updateFichierMatiere(fichierMatiere);
	}

	public static FichierMatiereLocalService getService() {
		return _service;
	}

	public static void setService(FichierMatiereLocalService service) {
		_service = service;
	}

	private static volatile FichierMatiereLocalService _service;

}