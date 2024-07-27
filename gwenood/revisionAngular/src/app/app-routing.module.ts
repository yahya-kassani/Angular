import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EtudiantComponent } from './CRUD-ETUDIANT/etudiant/etudiant.component';
import { ClasseComponent } from './CRUD-CLASSE/classe/classe.component';
import { ProfesseurComponent } from './CRUD-PROFS/professeur/professeur.component';
import { ProfClasseComponent } from './prof-classe/prof-classe.component';
import { MatiereComponent } from './matiere/matiere.component';
import { FilematiereComponent } from './filematiere/filematiere.component';
import { AffichageComponent } from './VIEWS/affichage/affichage.component';
import { DisplayOptionsComponent } from './VIEWS/display-options/display-options.component';
import { AffichageClasseComponent } from './VIEWS/affichage-classe/affichage-classe.component';
import { AffichageProfComponent } from './VIEWS/affichage-prof/affichage-prof.component';
import { AffichageMatiereComponent } from './VIEWS/affichage-matiere/affichage-matiere.component';


const routes: Routes = [
  { path: 'etudiant', component: EtudiantComponent },
  
  { path: 'classe', component: ClasseComponent },
  
  { path: 'professeur', component: ProfesseurComponent },
  
  { path: 'affecter', component: ProfClasseComponent },
  
  { path: 'matiere', component: MatiereComponent },
  
  { path: 'file', component: FilematiereComponent },
  
  { path: 'afficher-etudiants', component: AffichageComponent },
  
  { path: 'afficher-classes', component: AffichageClasseComponent },
 
  { path: '', component: DisplayOptionsComponent },
  
  { path: 'display-options', component: DisplayOptionsComponent },

  { path: 'afficher-profs', component: AffichageProfComponent },

  { path: 'afficher-matieres', component: AffichageMatiereComponent },

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
