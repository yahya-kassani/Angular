import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ClasseServiceService } from '../../service/ClasseService/classe-service.service';
import Swal from 'sweetalert2';
//import { MatDialogModule } from '@angular/material/dialog';
@Component({
  selector: 'app-classe',
  templateUrl: './classe.component.html',
  styleUrl: './classe.component.css'
})
export class ClasseComponent {
  classForm:FormGroup;

  constructor(private _fb:FormBuilder,private _classeService:ClasseServiceService){
    this.classForm = this._fb.group({
      classe:'',
    });
  }
  onFormSubmit() {
    if(this.classForm.valid){
      this._classeService.addClass(this.classForm.value).subscribe({
        next:(val:any)=>{
          Swal.fire({
            title: 'Success',
            text: 'Student added successfully!',
            icon: 'success',
            confirmButtonText: 'OK'
          }).then(() => {
            this.classForm.reset();
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
      });
    }
  }

  resetForm(): void {
    this.classForm.reset();
  }
}
