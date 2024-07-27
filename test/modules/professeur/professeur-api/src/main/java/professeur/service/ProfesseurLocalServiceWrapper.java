/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProfesseurLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfesseurLocalService
 * @generated
 */
public class ProfesseurLocalServiceWrapper
	implements ProfesseurLocalService, ServiceWrapper<ProfesseurLocalService> {

	public ProfesseurLocalServiceWrapper() {
		this(null);
	}

	public ProfesseurLocalServiceWrapper(
		ProfesseurLocalService professeurLocalService) {

		_professeurLocalService = professeurLocalService;
	}

	@Override
	public professeur.model.Professeur add(String nom, String prenom) {
		return _professeurLocalService.add(nom, prenom);
	}

	/**
	 * Adds the professeur to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfesseurLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professeur the professeur
	 * @return the professeur that was added
	 */
	@Override
	public professeur.model.Professeur addProfesseur(
		professeur.model.Professeur professeur) {

		return _professeurLocalService.addProfesseur(professeur);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professeurLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new professeur with the primary key. Does not add the professeur to the database.
	 *
	 * @param professeurId the primary key for the new professeur
	 * @return the new professeur
	 */
	@Override
	public professeur.model.Professeur createProfesseur(long professeurId) {
		return _professeurLocalService.createProfesseur(professeurId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professeurLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the professeur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfesseurLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur that was removed
	 * @throws PortalException if a professeur with the primary key could not be found
	 */
	@Override
	public professeur.model.Professeur deleteProfesseur(long professeurId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professeurLocalService.deleteProfesseur(professeurId);
	}

	/**
	 * Deletes the professeur from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfesseurLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professeur the professeur
	 * @return the professeur that was removed
	 */
	@Override
	public professeur.model.Professeur deleteProfesseur(
		professeur.model.Professeur professeur) {

		return _professeurLocalService.deleteProfesseur(professeur);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _professeurLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _professeurLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _professeurLocalService.dynamicQuery();
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

		return _professeurLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>professeur.model.impl.ProfesseurModelImpl</code>.
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

		return _professeurLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>professeur.model.impl.ProfesseurModelImpl</code>.
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

		return _professeurLocalService.dynamicQuery(
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

		return _professeurLocalService.dynamicQueryCount(dynamicQuery);
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

		return _professeurLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public professeur.model.Professeur fetchProfesseur(long professeurId) {
		return _professeurLocalService.fetchProfesseur(professeurId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _professeurLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _professeurLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _professeurLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professeurLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the professeur with the primary key.
	 *
	 * @param professeurId the primary key of the professeur
	 * @return the professeur
	 * @throws PortalException if a professeur with the primary key could not be found
	 */
	@Override
	public professeur.model.Professeur getProfesseur(long professeurId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professeurLocalService.getProfesseur(professeurId);
	}

	/**
	 * Returns a range of all the professeurs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>professeur.model.impl.ProfesseurModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professeurs
	 * @param end the upper bound of the range of professeurs (not inclusive)
	 * @return the range of professeurs
	 */
	@Override
	public java.util.List<professeur.model.Professeur> getProfesseurs(
		int start, int end) {

		return _professeurLocalService.getProfesseurs(start, end);
	}

	/**
	 * Returns the number of professeurs.
	 *
	 * @return the number of professeurs
	 */
	@Override
	public int getProfesseursCount() {
		return _professeurLocalService.getProfesseursCount();
	}

	@Override
	public professeur.model.Professeur update(
			long professeurId, String nom, String prenom)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professeurLocalService.update(professeurId, nom, prenom);
	}

	/**
	 * Updates the professeur in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfesseurLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professeur the professeur
	 * @return the professeur that was updated
	 */
	@Override
	public professeur.model.Professeur updateProfesseur(
		professeur.model.Professeur professeur) {

		return _professeurLocalService.updateProfesseur(professeur);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _professeurLocalService.getBasePersistence();
	}

	@Override
	public ProfesseurLocalService getWrappedService() {
		return _professeurLocalService;
	}

	@Override
	public void setWrappedService(
		ProfesseurLocalService professeurLocalService) {

		_professeurLocalService = professeurLocalService;
	}

	private ProfesseurLocalService _professeurLocalService;

}