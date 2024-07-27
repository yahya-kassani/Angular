import { Component } from '@angular/core';

@Component({
  selector: 'app-filematiere',
  templateUrl: './filematiere.component.html',
  styleUrl: './filematiere.component.css'
})
export class FilematiereComponent {
  matiere = ['ANGLAIS', 'BIG DATA', 'LIFERAY', 'BASE DE DONNEE', 'GESTION DE PROJET'];
  selectedmatier!: string;
}
