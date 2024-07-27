/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import professeur.model.ProfClasse;
import professeur.model.Professeur;
import professeur.service.base.ProfClasseLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=professeur.model.ProfClasse",
	service = AopService.class
)
public class ProfClasseLocalServiceImpl extends ProfClasseLocalServiceBaseImpl {
	final private static Log _log = LogFactoryUtil.getLog(ProfClasseLocalServiceImpl.class);
	public ProfClasse add(long porfesseurId, long classeId){
		ProfClasse profClasse = profClassePersistence.create(counterLocalService.increment());
		profClasse.setProfesseurId(porfesseurId);
		profClasse.setClasseId(classeId);
		return profClassePersistence.update(profClasse);
	}


	public List<Professeur> getProfesseurByClasseId(long classeId, int start, int end){
		final List<ProfClasse> profClasses = profClassePersistence.findByclasseId(classeId,start,end);
		final List<Professeur> professeurs = new ArrayList<Professeur>();

		for(var profClasse : profClasses){
			try{
				final Professeur p = professeurPersistence.findByPrimaryKey(profClasse.getProfesseurId());
				professeurs.add(p);
			}catch (Exception e){
				_log.error("impossible de recuperer le professeur avec Id :"+profClasse.getProfesseurId(),e);
			}
		}
		return professeurs;
	}

	public List<ProfClasse> getClasseIdsByProfesseurId(long professeurId){
		return profClassePersistence.findByProfesseurId(professeurId);
	}
}