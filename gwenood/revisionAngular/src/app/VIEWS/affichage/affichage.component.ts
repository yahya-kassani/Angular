import { Component, OnInit, ViewChild } from '@angular/core';

import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { EditStudentComponent } from '../../CRUD-ETUDIANT/edit-student/edit-student.component';
import Swal from 'sweetalert2';
import { StudentService } from '../../service/StudentService/student.service';

@Component({
  selector: 'app-affichage',
  templateUrl: './affichage.component.html',
  styleUrls: ['./affichage.component.css']
})
export class AffichageComponent implements OnInit {

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'image', 'year', 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _etudService: StudentService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getEmployeList();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteStudent(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you really want to delete this student?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this._etudService.deleteStudent(id).subscribe({
          next: (res) => {
            Swal.fire({
              title: 'Deleted!',
              text: 'Student deleted successfully.',
              icon: 'success',
              confirmButtonText: 'OK'
            }).then(() => {
              this.getEmployeList();
            });
          },
          error: (err) => {
            Swal.fire({
              title: 'Error',
              text: 'An error occurred while deleting the student.',
              icon: 'error',
              confirmButtonText: 'OK'
            });
            console.error(err);
          }
        });
      }
    });
  }

  getEmployeList() {
    this._etudService.getStudent().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }

  editStudent(student: any) {
    const dialogRef = this.dialog.open(EditStudentComponent, {
      width: '500px',
      data: student
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.updateStudent(result);
      }
    });
  }

  updateStudent(updatedStudent: any) {
    this._etudService.updateStudent(updatedStudent.id, updatedStudent).subscribe({
      next: () => {
        const index = this.dataSource.data.findIndex(student => student.id === updatedStudent.id);
        if (index !== -1) {
          this.dataSource.data[index] = updatedStudent;
          this.dataSource._updateChangeSubscription(); // Pour rafraîchir la table
        }
      },
      error: console.error,
    });
  }
}
