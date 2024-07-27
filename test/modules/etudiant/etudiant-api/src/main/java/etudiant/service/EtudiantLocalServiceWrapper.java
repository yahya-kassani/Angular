/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EtudiantLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EtudiantLocalService
 * @generated
 */
public class EtudiantLocalServiceWrapper
	implements EtudiantLocalService, ServiceWrapper<EtudiantLocalService> {

	public EtudiantLocalServiceWrapper() {
		this(null);
	}

	public EtudiantLocalServiceWrapper(
		EtudiantLocalService etudiantLocalService) {

		_etudiantLocalService = etudiantLocalService;
	}

	@Override
	public etudiant.model.Etudiant add(
		String nom, String prenom, long imageId, long classId) {

		return _etudiantLocalService.add(nom, prenom, imageId, classId);
	}

	/**
	 * Adds the etudiant to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EtudiantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param etudiant the etudiant
	 * @return the etudiant that was added
	 */
	@Override
	public etudiant.model.Etudiant addEtudiant(
		etudiant.model.Etudiant etudiant) {

		return _etudiantLocalService.addEtudiant(etudiant);
	}

	/**
	 * Creates a new etudiant with the primary key. Does not add the etudiant to the database.
	 *
	 * @param etudiantId the primary key for the new etudiant
	 * @return the new etudiant
	 */
	@Override
	public etudiant.model.Etudiant createEtudiant(long etudiantId) {
		return _etudiantLocalService.createEtudiant(etudiantId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _etudiantLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the etudiant from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EtudiantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param etudiant the etudiant
	 * @return the etudiant that was removed
	 */
	@Override
	public etudiant.model.Etudiant deleteEtudiant(
		etudiant.model.Etudiant etudiant) {

		return _etudiantLocalService.deleteEtudiant(etudiant);
	}

	/**
	 * Deletes the etudiant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EtudiantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant that was removed
	 * @throws PortalException if a etudiant with the primary key could not be found
	 */
	@Override
	public etudiant.model.Etudiant deleteEtudiant(long etudiantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _etudiantLocalService.deleteEtudiant(etudiantId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _etudiantLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _etudiantLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _etudiantLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _etudiantLocalService.dynamicQuery();
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

		return _etudiantLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>etudiant.model.impl.EtudiantModelImpl</code>.
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

		return _etudiantLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>etudiant.model.impl.EtudiantModelImpl</code>.
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

		return _etudiantLocalService.dynamicQuery(
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

		return _etudiantLocalService.dynamicQueryCount(dynamicQuery);
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

		return _etudiantLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public etudiant.model.Etudiant fetchEtudiant(long etudiantId) {
		return _etudiantLocalService.fetchEtudiant(etudiantId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _etudiantLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the etudiant with the primary key.
	 *
	 * @param etudiantId the primary key of the etudiant
	 * @return the etudiant
	 * @throws PortalException if a etudiant with the primary key could not be found
	 */
	@Override
	public etudiant.model.Etudiant getEtudiant(long etudiantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _etudiantLocalService.getEtudiant(etudiantId);
	}

	/**
	 * Returns a range of all the etudiants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>etudiant.model.impl.EtudiantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of etudiants
	 * @param end the upper bound of the range of etudiants (not inclusive)
	 * @return the range of etudiants
	 */
	@Override
	public java.util.List<etudiant.model.Etudiant> getEtudiants(
		int start, int end) {

		return _etudiantLocalService.getEtudiants(start, end);
	}

	/**
	 * Returns the number of etudiants.
	 *
	 * @return the number of etudiants
	 */
	@Override
	public int getEtudiantsCount() {
		return _etudiantLocalService.getEtudiantsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _etudiantLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _etudiantLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _etudiantLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public etudiant.model.Etudiant update(
			long etudiantId, String nom, String prenom, long imageId,
			long classId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _etudiantLocalService.update(
			etudiantId, nom, prenom, imageId, classId);
	}

	/**
	 * Updates the etudiant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EtudiantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param etudiant the etudiant
	 * @return the etudiant that was updated
	 */
	@Override
	public etudiant.model.Etudiant updateEtudiant(
		etudiant.model.Etudiant etudiant) {

		return _etudiantLocalService.updateEtudiant(etudiant);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _etudiantLocalService.getBasePersistence();
	}

	@Override
	public EtudiantLocalService getWrappedService() {
		return _etudiantLocalService;
	}

	@Override
	public void setWrappedService(EtudiantLocalService etudiantLocalService) {
		_etudiantLocalService = etudiantLocalService;
	}

	private EtudiantLocalService _etudiantLocalService;

}