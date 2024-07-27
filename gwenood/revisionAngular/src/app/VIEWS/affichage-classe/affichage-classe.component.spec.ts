import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageClasseComponent } from './affichage-classe.component';

describe('AffichageClasseComponent', () => {
  let component: AffichageClasseComponent;
  let fixture: ComponentFixture<AffichageClasseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AffichageClasseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AffichageClasseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
