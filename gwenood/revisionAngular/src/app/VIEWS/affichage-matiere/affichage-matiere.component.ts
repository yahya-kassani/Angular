import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatiereService } from '../../service/matierService/matiere.service';
import { MatDialog } from '@angular/material/dialog';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-affichage-matiere',
  templateUrl: './affichage-matiere.component.html',
  styleUrl: './affichage-matiere.component.css'
})
export class AffichageMatiereComponent implements OnInit{
  displayedColumns: string[] = ['id', 'nomIntitule','anneeSocolaire','nomProfs','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _matiereService:MatiereService,private dialog:MatDialog){}
  ngOnInit(): void {
    this.getMatiereList();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getMatiereList(){
    this._matiereService.getMatiere().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }

  deleteMatiere(id: number){
    Swal.fire({
      title: 'Are you sure?',
      text: 'Do you really want to delete this Module?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.isConfirmed) {
      this._matiereService.deleteMatiere(id).subscribe({
        next: (res) => {
          Swal.fire({
            title: 'Deleted!',
            text: 'Module deleted successfully.',
            icon: 'success',
            confirmButtonText: 'OK'
          }).then(() => {
            this.getMatiereList();
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
  

}
