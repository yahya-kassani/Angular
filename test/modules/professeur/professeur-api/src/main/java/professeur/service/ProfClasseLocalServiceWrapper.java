/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProfClasseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfClasseLocalService
 * @generated
 */
public class ProfClasseLocalServiceWrapper
	implements ProfClasseLocalService, ServiceWrapper<ProfClasseLocalService> {

	public ProfClasseLocalServiceWrapper() {
		this(null);
	}

	public ProfClasseLocalServiceWrapper(
		ProfClasseLocalService profClasseLocalService) {

		_profClasseLocalService = profClasseLocalService;
	}

	@Override
	public professeur.model.ProfClasse add(long porfesseurId, long classeId) {
		return _profClasseLocalService.add(porfesseurId, classeId);
	}

	/**
	 * Adds the prof classe to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profClasse the prof classe
	 * @return the prof classe that was added
	 */
	@Override
	public professeur.model.ProfClasse addProfClasse(
		professeur.model.ProfClasse profClasse) {

		return _profClasseLocalService.addProfClasse(profClasse);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profClasseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new prof classe with the primary key. Does not add the prof classe to the database.
	 *
	 * @param profClasseId the primary key for the new prof classe
	 * @return the new prof classe
	 */
	@Override
	public professeur.model.ProfClasse createProfClasse(long profClasseId) {
		return _profClasseLocalService.createProfClasse(profClasseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profClasseLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the prof classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe that was removed
	 * @throws PortalException if a prof classe with the primary key could not be found
	 */
	@Override
	public professeur.model.ProfClasse deleteProfClasse(long profClasseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profClasseLocalService.deleteProfClasse(profClasseId);
	}

	/**
	 * Deletes the prof classe from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profClasse the prof classe
	 * @return the prof classe that was removed
	 */
	@Override
	public professeur.model.ProfClasse deleteProfClasse(
		professeur.model.ProfClasse profClasse) {

		return _profClasseLocalService.deleteProfClasse(profClasse);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _profClasseLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _profClasseLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _profClasseLocalService.dynamicQuery();
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

		return _profClasseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>professeur.model.impl.ProfClasseModelImpl</code>.
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

		return _profClasseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>professeur.model.impl.ProfClasseModelImpl</code>.
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

		return _profClasseLocalService.dynamicQuery(
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

		return _profClasseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _profClasseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public professeur.model.ProfClasse fetchProfClasse(long profClasseId) {
		return _profClasseLocalService.fetchProfClasse(profClasseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _profClasseLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<professeur.model.ProfClasse>
		getClasseIdsByProfesseurId(long professeurId) {

		return _profClasseLocalService.getClasseIdsByProfesseurId(professeurId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _profClasseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profClasseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profClasseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the prof classe with the primary key.
	 *
	 * @param profClasseId the primary key of the prof classe
	 * @return the prof classe
	 * @throws PortalException if a prof classe with the primary key could not be found
	 */
	@Override
	public professeur.model.ProfClasse getProfClasse(long profClasseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _profClasseLocalService.getProfClasse(profClasseId);
	}

	/**
	 * Returns a range of all the prof classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>professeur.model.impl.ProfClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of prof classes
	 * @param end the upper bound of the range of prof classes (not inclusive)
	 * @return the range of prof classes
	 */
	@Override
	public java.util.List<professeur.model.ProfClasse> getProfClasses(
		int start, int end) {

		return _profClasseLocalService.getProfClasses(start, end);
	}

	/**
	 * Returns the number of prof classes.
	 *
	 * @return the number of prof classes
	 */
	@Override
	public int getProfClassesCount() {
		return _profClasseLocalService.getProfClassesCount();
	}

	@Override
	public java.util.List<professeur.model.Professeur> getProfesseurByClasseId(
		long classeId, int start, int end) {

		return _profClasseLocalService.getProfesseurByClasseId(
			classeId, start, end);
	}

	/**
	 * Updates the prof classe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param profClasse the prof classe
	 * @return the prof classe that was updated
	 */
	@Override
	public professeur.model.ProfClasse updateProfClasse(
		professeur.model.ProfClasse profClasse) {

		return _profClasseLocalService.updateProfClasse(profClasse);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _profClasseLocalService.getBasePersistence();
	}

	@Override
	public ProfClasseLocalService getWrappedService() {
		return _profClasseLocalService;
	}

	@Override
	public void setWrappedService(
		ProfClasseLocalService profClasseLocalService) {

		_profClasseLocalService = profClasseLocalService;
	}

	private ProfClasseLocalService _profClasseLocalService;

}