/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ClasseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClasseLocalService
 * @generated
 */
public class ClasseLocalServiceWrapper
	implements ClasseLocalService, ServiceWrapper<ClasseLocalService> {

	public ClasseLocalServiceWrapper() {
		this(null);
	}

	public ClasseLocalServiceWrapper(ClasseLocalService classeLocalService) {
		_classeLocalService = classeLocalService;
	}

	@Override
	public classe.model.Classe add(String intitule) {
		return _classeLocalService.add(intitule);
	}

	/**
	 * Adds the classe to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param classe the classe
	 * @return the classe that was added
	 */
	@Override
	public classe.model.Classe addClasse(classe.model.Classe classe) {
		return _classeLocalService.addClasse(classe);
	}

	/**
	 * Creates a new classe with the primary key. Does not add the classe to the database.
	 *
	 * @param classeId the primary key for the new classe
	 * @return the new classe
	 */
	@Override
	public classe.model.Classe createClasse(long classeId) {
		return _classeLocalService.createClasse(classeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _classeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the classe from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param classe the classe
	 * @return the classe that was removed
	 */
	@Override
	public classe.model.Classe deleteClasse(classe.model.Classe classe) {
		return _classeLocalService.deleteClasse(classe);
	}

	/**
	 * Deletes the classe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe that was removed
	 * @throws PortalException if a classe with the primary key could not be found
	 */
	@Override
	public classe.model.Classe deleteClasse(long classeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _classeLocalService.deleteClasse(classeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _classeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _classeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _classeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _classeLocalService.dynamicQuery();
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

		return _classeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>classe.model.impl.ClasseModelImpl</code>.
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

		return _classeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>classe.model.impl.ClasseModelImpl</code>.
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

		return _classeLocalService.dynamicQuery(
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

		return _classeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _classeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public classe.model.Classe fetchClasse(long classeId) {
		return _classeLocalService.fetchClasse(classeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _classeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the classe with the primary key.
	 *
	 * @param classeId the primary key of the classe
	 * @return the classe
	 * @throws PortalException if a classe with the primary key could not be found
	 */
	@Override
	public classe.model.Classe getClasse(long classeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _classeLocalService.getClasse(classeId);
	}

	/**
	 * Returns a range of all the classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>classe.model.impl.ClasseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of classes
	 * @param end the upper bound of the range of classes (not inclusive)
	 * @return the range of classes
	 */
	@Override
	public java.util.List<classe.model.Classe> getClasses(int start, int end) {
		return _classeLocalService.getClasses(start, end);
	}

	/**
	 * Returns the number of classes.
	 *
	 * @return the number of classes
	 */
	@Override
	public int getClassesCount() {
		return _classeLocalService.getClassesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _classeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _classeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _classeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public classe.model.Classe update(long classeId, String intitule)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _classeLocalService.update(classeId, intitule);
	}

	/**
	 * Updates the classe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClasseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param classe the classe
	 * @return the classe that was updated
	 */
	@Override
	public classe.model.Classe updateClasse(classe.model.Classe classe) {
		return _classeLocalService.updateClasse(classe);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _classeLocalService.getBasePersistence();
	}

	@Override
	public ClasseLocalService getWrappedService() {
		return _classeLocalService;
	}

	@Override
	public void setWrappedService(ClasseLocalService classeLocalService) {
		_classeLocalService = classeLocalService;
	}

	private ClasseLocalService _classeLocalService;

}