import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EditStudentComponent } from '../../CRUD-ETUDIANT/edit-student/edit-student.component';

@Component({
  selector: 'app-prof-edit',
  templateUrl: './prof-edit.component.html',
  styleUrl: './prof-edit.component.css'
})
export class ProfEditComponent {
  editProfForm:FormGroup;
  constructor(
    private fb:FormBuilder,
    private dialogRef:MatDialogRef<EditStudentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ){
    this.editProfForm=this.fb.group({
      id: [data.id, Validators.required],
      firstName: [data.firstName, Validators.required],
      lastName: [data.lastName, Validators.required]
    })
  }
  close() {
    this.dialogRef.close();
  }
  save(){
    if(this.editProfForm.valid){
      this.dialogRef.close(this.editProfForm.value);
    }
  }
}
