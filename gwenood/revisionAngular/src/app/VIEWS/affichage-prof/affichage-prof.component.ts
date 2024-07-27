import { Component, OnInit, ViewChild } from '@angular/core';

import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import Swal from 'sweetalert2';
import { ProfService } from '../../service/ProfService/prof.service';
import { ProfesseurComponent } from '../../CRUD-PROFS/professeur/professeur.component';
import { ProfEditComponent } from '../../CRUD-PROFS/prof-edit/prof-edit.component';
@Component({
  selector: 'app-affichage-prof',
  templateUrl: './affichage-prof.component.html',
  styleUrl: './affichage-prof.component.css'
})
export class AffichageProfComponent implements OnInit {
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  ngOnInit(): void {
    this.getProfList();
  }

  constructor(private _profService:ProfService,private dialog: MatDialog){}

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  getProfList(){
    this._profService.getProf().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }


  deleteProfs(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you really want to delete this Teacher?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
        this._profService.deleteProf(id).subscribe({
        //this._etudService.deleteStudent(id).subscribe({
          next: (res) => {
            Swal.fire({
              title: 'Deleted!',
              text: 'Prof deleted successfully.',
              icon: 'success',
              confirmButtonText: 'OK'
            }).then(() => {
              this.getProfList();
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
  editProfs(profs:any){
    const dialogRef = this.dialog.open(ProfEditComponent, {
      width: '500px',
      data: profs
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.updateProfs(result);
      }
    });
  }

  updateProfs(updatedStudent: any) {
    this._profService.updateProf(updatedStudent.id, updatedStudent).subscribe({
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
