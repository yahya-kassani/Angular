import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesseurComponent } from './professeur.component';

describe('ProfesseurComponent', () => {
  let component: ProfesseurComponent;
  let fixture: ComponentFixture<ProfesseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProfesseurComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
