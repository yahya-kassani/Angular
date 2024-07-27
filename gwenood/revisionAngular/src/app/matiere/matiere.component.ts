import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProfService } from '../service/ProfService/prof.service';
import Swal from 'sweetalert2';
import { MatiereService } from '../service/matierService/matiere.service';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrl: './matiere.component.css'
})
export class MatiereComponent {
  years = ['1ère année', '2ème année', '3ème année', '4ème année', '5ème année'];
  selectedYear!: string;

  profs = ['TAHIRI AHMED', 'KHALID AISSAOUI', 'VIRI LIFERAY', 'AKHSSBI HASSNA', 'BOUAINE AMINE'];
  selectedprof!: string;

  matierForm:FormGroup;

  constructor(private _fb:FormBuilder,private _matierForm:MatiereService){
    this.matierForm=this._fb.group({
      nomIntitule:'',
      anneeSocolaire:'',
      nomProfs:'',
    });
  }

  resetForm(): void {
    this.matierForm.reset();
  }
  onFormSubmit(){
    if(this.matierForm.valid){
      console.log(this.matierForm.value);
      this._matierForm.addMatiere(this.matierForm.value).subscribe({
       
        next: (val: any) => {
          Swal.fire({
            title: 'Success',
            text: 'prof added successfully!',
            icon: 'success',
            confirmButtonText: 'OK'
          }).then(() => {
            this.matierForm.reset();
          });
        },
        error: (err: any) => {
          Swal.fire({
            title: 'Error',
            text: 'An error occurred while adding the .',
            icon: 'error',
            confirmButtonText: 'OK'
          });
          console.error(err);
        }
      })
    }
  }
}

