import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProfService } from '../../service/ProfService/prof.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-professeur',
  templateUrl: './professeur.component.html',
  styleUrl: './professeur.component.css'
})
export class ProfesseurComponent {
  ProfForm:FormGroup;

  constructor(private _fb:FormBuilder,private _profService:ProfService){
    this.ProfForm=this._fb.group({
      firstName:'',
      lastName:'',
    });
  }
  onFormSubmit() {
    if(this.ProfForm.valid){
      this._profService.addProf(this.ProfForm.value).subscribe({
        next: (val: any) => {
          Swal.fire({
            title: 'Success',
            text: 'Prof added successfully!',
            icon: 'success',
            confirmButtonText: 'OK'
          }).then(() => {
            this.ProfForm.reset();
          });
        },
        error: (err: any) => {
          Swal.fire({
            title: 'Error',
            text: 'An error occurred while adding the student.',
            icon: 'error',
            confirmButtonText: 'OK'
          });
          console.error(err);
        }
      })
    }
  }
  resetForm(): void {
    this.ProfForm.reset();
  }
}
