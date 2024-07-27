import { Component } from '@angular/core';

@Component({
  selector: 'app-prof-classe',
  templateUrl: './prof-classe.component.html',
  styleUrl: './prof-classe.component.css'
})
export class ProfClasseComponent {

  years = ['1ère année', '2ème année', '3ème année', '4ème année', '5ème année'];
  selectedYear!: string;

  profs = ['TAHIRI AHMED', 'KHALID AISSAOUI', 'VIRI LIFERAY', 'AKHSSBI HASSNA', 'BOUAINE AMINE'];
  selectedprof!: string;
}
