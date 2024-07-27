import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfClasseComponent } from './prof-classe.component';

describe('ProfClasseComponent', () => {
  let component: ProfClasseComponent;
  let fixture: ComponentFixture<ProfClasseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProfClasseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfClasseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
