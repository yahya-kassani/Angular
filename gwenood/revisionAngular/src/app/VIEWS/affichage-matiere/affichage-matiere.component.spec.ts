import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageMatiereComponent } from './affichage-matiere.component';

describe('AffichageMatiereComponent', () => {
  let component: AffichageMatiereComponent;
  let fixture: ComponentFixture<AffichageMatiereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AffichageMatiereComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AffichageMatiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
