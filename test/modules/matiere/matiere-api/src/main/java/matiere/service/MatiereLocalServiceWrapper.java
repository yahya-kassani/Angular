/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MatiereLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatiereLocalService
 * @generated
 */
public class MatiereLocalServiceWrapper
	implements MatiereLocalService, ServiceWrapper<MatiereLocalService> {

	public MatiereLocalServiceWrapper() {
		this(null);
	}

	public MatiereLocalServiceWrapper(MatiereLocalService matiereLocalService) {
		_matiereLocalService = matiereLocalService;
	}

	@Override
	public matiere.model.Matiere add(
		long classeId, long professeurId, String intitule) {

		return _matiereLocalService.add(classeId, professeurId, intitule);
	}

	/**
	 * Adds the matiere to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matiere the matiere
	 * @return the matiere that was added
	 */
	@Override
	public matiere.model.Matiere addMatiere(matiere.model.Matiere matiere) {
		return _matiereLocalService.addMatiere(matiere);
	}

	/**
	 * Creates a new matiere with the primary key. Does not add the matiere to the database.
	 *
	 * @param matiereId the primary key for the new matiere
	 * @return the new matiere
	 */
	@Override
	public matiere.model.Matiere createMatiere(long matiereId) {
		return _matiereLocalService.createMatiere(matiereId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matiereLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the matiere with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere that was removed
	 * @throws PortalException if a matiere with the primary key could not be found
	 */
	@Override
	public matiere.model.Matiere deleteMatiere(long matiereId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matiereLocalService.deleteMatiere(matiereId);
	}

	/**
	 * Deletes the matiere from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matiere the matiere
	 * @return the matiere that was removed
	 */
	@Override
	public matiere.model.Matiere deleteMatiere(matiere.model.Matiere matiere) {
		return _matiereLocalService.deleteMatiere(matiere);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matiereLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _matiereLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _matiereLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _matiereLocalService.dynamicQuery();
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

		return _matiereLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>matiere.model.impl.MatiereModelImpl</code>.
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

		return _matiereLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>matiere.model.impl.MatiereModelImpl</code>.
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

		return _matiereLocalService.dynamicQuery(
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

		return _matiereLocalService.dynamicQueryCount(dynamicQuery);
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

		return _matiereLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public matiere.model.Matiere fetchMatiere(long matiereId) {
		return _matiereLocalService.fetchMatiere(matiereId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _matiereLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _matiereLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the matiere with the primary key.
	 *
	 * @param matiereId the primary key of the matiere
	 * @return the matiere
	 * @throws PortalException if a matiere with the primary key could not be found
	 */
	@Override
	public matiere.model.Matiere getMatiere(long matiereId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matiereLocalService.getMatiere(matiereId);
	}

	/**
	 * Returns a range of all the matieres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>matiere.model.impl.MatiereModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matieres
	 * @param end the upper bound of the range of matieres (not inclusive)
	 * @return the range of matieres
	 */
	@Override
	public java.util.List<matiere.model.Matiere> getMatieres(
		int start, int end) {

		return _matiereLocalService.getMatieres(start, end);
	}

	/**
	 * Returns the number of matieres.
	 *
	 * @return the number of matieres
	 */
	@Override
	public int getMatieresCount() {
		return _matiereLocalService.getMatieresCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matiereLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matiereLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public matiere.model.Matiere update(
			long matiereId, long classeId, long professeurId, String intitule)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matiereLocalService.update(
			matiereId, classeId, professeurId, intitule);
	}

	/**
	 * Updates the matiere in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatiereLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matiere the matiere
	 * @return the matiere that was updated
	 */
	@Override
	public matiere.model.Matiere updateMatiere(matiere.model.Matiere matiere) {
		return _matiereLocalService.updateMatiere(matiere);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _matiereLocalService.getBasePersistence();
	}

	@Override
	public MatiereLocalService getWrappedService() {
		return _matiereLocalService;
	}

	@Override
	public void setWrappedService(MatiereLocalService matiereLocalService) {
		_matiereLocalService = matiereLocalService;
	}

	private MatiereLocalService _matiereLocalService;

}