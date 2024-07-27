
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-class',
  templateUrl: './edit-class.component.html',
  styleUrl: './edit-class.component.css'
})
export class EditClassComponent {
  editClassForm: FormGroup;
  constructor(
    private fb:FormBuilder,
    private dialogRef: MatDialogRef<EditClassComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ){
    this.editClassForm=this.fb.group({
      id: [{ value: data.id, disabled: true }],
      classe:[data.classe,Validators.required]
    });
  }
  close() {
    this.dialogRef.close();
  }
  save(){
    if(this.editClassForm.valid){
      this.dialogRef.close(this.editClassForm.value);
    }
  }
}
