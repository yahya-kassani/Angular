import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AffichageProfComponent } from './affichage-prof.component';

describe('AffichageProfComponent', () => {
  let component: AffichageProfComponent;
  let fixture: ComponentFixture<AffichageProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AffichageProfComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AffichageProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
