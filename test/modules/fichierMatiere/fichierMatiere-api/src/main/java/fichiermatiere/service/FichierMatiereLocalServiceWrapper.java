/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FichierMatiereLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiereLocalService
 * @generated
 */
public class FichierMatiereLocalServiceWrapper
	implements FichierMatiereLocalService,
			   ServiceWrapper<FichierMatiereLocalService> {

	public FichierMatiereLocalServiceWrapper() {
		this(null);
	}

	public FichierMatiereLocalServiceWrapper(
		FichierMatiereLocalService fichierMatiereLocalService) {

		_fichierMatiereLocalService = fichierMatiereLocalService;
	}

	@Override
	public fichiermatiere.model.FichierMatiere add(
		long matiereId, long fichierId) {

		return _fichierMatiereLocalService.add(matiereId, fichierId);
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
	@Override
	public fichiermatiere.model.FichierMatiere addFichierMatiere(
		fichiermatiere.model.FichierMatiere fichierMatiere) {

		return _fichierMatiereLocalService.addFichierMatiere(fichierMatiere);
	}

	/**
	 * Creates a new fichier matiere with the primary key. Does not add the fichier matiere to the database.
	 *
	 * @param fichierMatiereId the primary key for the new fichier matiere
	 * @return the new fichier matiere
	 */
	@Override
	public fichiermatiere.model.FichierMatiere createFichierMatiere(
		long fichierMatiereId) {

		return _fichierMatiereLocalService.createFichierMatiere(
			fichierMatiereId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fichierMatiereLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public fichiermatiere.model.FichierMatiere deleteFichierMatiere(
		fichiermatiere.model.FichierMatiere fichierMatiere) {

		return _fichierMatiereLocalService.deleteFichierMatiere(fichierMatiere);
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
	@Override
	public fichiermatiere.model.FichierMatiere deleteFichierMatiere(
			long fichierMatiereId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fichierMatiereLocalService.deleteFichierMatiere(
			fichierMatiereId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fichierMatiereLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fichierMatiereLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fichierMatiereLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fichierMatiereLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _fichierMatiereLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _fichierMatiereLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _fichierMatiereLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _fichierMatiereLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _fichierMatiereLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public fichiermatiere.model.FichierMatiere fetchFichierMatiere(
		long fichierMatiereId) {

		return _fichierMatiereLocalService.fetchFichierMatiere(
			fichierMatiereId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fichierMatiereLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the fichier matiere with the primary key.
	 *
	 * @param fichierMatiereId the primary key of the fichier matiere
	 * @return the fichier matiere
	 * @throws PortalException if a fichier matiere with the primary key could not be found
	 */
	@Override
	public fichiermatiere.model.FichierMatiere getFichierMatiere(
			long fichierMatiereId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fichierMatiereLocalService.getFichierMatiere(fichierMatiereId);
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
	@Override
	public java.util.List<fichiermatiere.model.FichierMatiere>
		getFichierMatieres(int start, int end) {

		return _fichierMatiereLocalService.getFichierMatieres(start, end);
	}

	/**
	 * Returns the number of fichier matieres.
	 *
	 * @return the number of fichier matieres
	 */
	@Override
	public int getFichierMatieresCount() {
		return _fichierMatiereLocalService.getFichierMatieresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fichierMatiereLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fichierMatiereLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fichierMatiereLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public fichiermatiere.model.FichierMatiere update(
			long fichierMatiereId, long fichierId, long matiereId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fichierMatiereLocalService.update(
			fichierMatiereId, fichierId, matiereId);
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
	@Override
	public fichiermatiere.model.FichierMatiere updateFichierMatiere(
		fichiermatiere.model.FichierMatiere fichierMatiere) {

		return _fichierMatiereLocalService.updateFichierMatiere(fichierMatiere);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _fichierMatiereLocalService.getBasePersistence();
	}

	@Override
	public FichierMatiereLocalService getWrappedService() {
		return _fichierMatiereLocalService;
	}

	@Override
	public void setWrappedService(
		FichierMatiereLocalService fichierMatiereLocalService) {

		_fichierMatiereLocalService = fichierMatiereLocalService;
	}

	private FichierMatiereLocalService _fichierMatiereLocalService;

}