import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import Swal from 'sweetalert2';
import { StudentService } from '../../service/StudentService/student.service';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrl: './etudiant.component.css'
})
export class EtudiantComponent {
 
  studForm:FormGroup;

  selectedFile: File | null = null;
 

  years = ['1ère année', '2ème année', '3ème année', '4ème année', '5ème année'];
  selectedYear!: string;

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
    }
  }
  constructor(private _fb:FormBuilder,private _studentService:StudentService){
    this.studForm = this._fb.group({
      firstName:'',
      lastName:'',
      image:'',
      year:'',
    });
  }

  resetForm(): void {
    this.studForm.reset();
  }
  
  onFormSubmit() {
    if (this.studForm.valid) {
      this._studentService.addStudent(this.studForm.value).subscribe({
        next: (val: any) => {
          Swal.fire({
            title: 'Success',
            text: 'Student added successfully!',
            icon: 'success',
            confirmButtonText: 'OK'
          }).then(() => {
            this.studForm.reset();
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
}
