import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilematiereComponent } from './filematiere.component';

describe('FilematiereComponent', () => {
  let component: FilematiereComponent;
  let fixture: ComponentFixture<FilematiereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FilematiereComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FilematiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
