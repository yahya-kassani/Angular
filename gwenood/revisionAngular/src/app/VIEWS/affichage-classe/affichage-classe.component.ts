import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ClasseServiceService } from '../../service/ClasseService/classe-service.service';
import { MatDialog } from '@angular/material/dialog';
import Swal from 'sweetalert2';
import { ClasseComponent } from '../../CRUD-CLASSE/classe/classe.component';
import { EditClassComponent } from '../../CRUD-CLASSE/edit-class/edit-class.component';
@Component({
  selector: 'app-affichage-classe',
  templateUrl: './affichage-classe.component.html',
  styleUrl: './affichage-classe.component.css'
})
export class AffichageClasseComponent implements OnInit{
  displayedColumns: string[] = ['id', 'classe','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _classService:ClasseServiceService,private dialog:MatDialog){}

  ngOnInit(): void {
    this.getClassList();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getClassList(){
    this._classService.getClass().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }


  deleteClasse(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you really want to delete this student?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
      this._classService.deleteClass(id).subscribe({
        next: (res) => {
          Swal.fire({
            title: 'Deleted!',
            text: 'Student deleted successfully.',
            icon: 'success',
            confirmButtonText: 'OK'
          }).then(() => {
            this.getClassList();
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
  
  modifierClasse(classeT:any){
    const dialogRef=this.dialog.open(EditClassComponent,{
      width: '500px',
      data: classeT
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.updateClasse(result);
      }
    });
  }

  updateClasse(updateClasse:any){
    this._classService.updateClass(updateClasse.id,updateClasse).subscribe({
      next:()=>{
        const index=this.dataSource.data.findIndex(classeT=>classeT.id == updateClasse.id);
        if(index!==-1){
          this.dataSource.data[index]=updateClasse;
          this.dataSource._updateChangeSubscription();
        }
      },
      error:console.error,
    })
  }
 
}
