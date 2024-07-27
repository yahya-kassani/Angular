import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent {
  editStudentForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<EditStudentComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.editStudentForm = this.fb.group({
      id: [data.id, Validators.required],
      firstName: [data.firstName, Validators.required],
      lastName: [data.lastName, Validators.required],
      image: [data.image, Validators.required],
      year: [data.year, Validators.required]
    });
  }

  save() {
    if (this.editStudentForm.valid) {
      this.dialogRef.close(this.editStudentForm.value);
    }
  }

  close() {
    this.dialogRef.close();
  }
}
