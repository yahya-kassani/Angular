import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EtudiantComponent } from './CRUD-ETUDIANT/etudiant/etudiant.component';


import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ClasseComponent } from './CRUD-CLASSE/classe/classe.component';
import { ProfesseurComponent } from './CRUD-PROFS/professeur/professeur.component';
import { ProfClasseComponent } from './prof-classe/prof-classe.component';
import { MatiereComponent } from './matiere/matiere.component';
import { FilematiereComponent } from './filematiere/filematiere.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { AffichageComponent } from './VIEWS/affichage/affichage.component';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { EditStudentComponent } from './CRUD-ETUDIANT/edit-student/edit-student.component';
import { DisplayOptionsComponent } from './VIEWS/display-options/display-options.component';
import { AffichageClasseComponent } from './VIEWS/affichage-classe/affichage-classe.component';
import { EditClassComponent } from './CRUD-CLASSE/edit-class/edit-class.component';
import { AffichageProfComponent } from './VIEWS/affichage-prof/affichage-prof.component';
import { ProfEditComponent } from './CRUD-PROFS/prof-edit/prof-edit.component';
import { AffichageMatiereComponent } from './VIEWS/affichage-matiere/affichage-matiere.component';


@NgModule({
  declarations: [
   AppComponent,
   AffichageComponent,
   EtudiantComponent,
   ClasseComponent,
   ProfesseurComponent,
   ProfClasseComponent,
   MatiereComponent,
   FilematiereComponent,
   EditStudentComponent,
   DisplayOptionsComponent,
   AffichageClasseComponent,
   EditClassComponent,
   AffichageProfComponent,
   ProfEditComponent,
   AffichageMatiereComponent
   
  ],
  imports: [
    
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    NgbModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginator,
    MatSort,

  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
