import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeihvorgaengeUebersichtComponent } from './leihvorgaenge-uebersicht.component';

describe('LeihvorgaengeUebersichtComponent', () => {
  let component: LeihvorgaengeUebersichtComponent;
  let fixture: ComponentFixture<LeihvorgaengeUebersichtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeihvorgaengeUebersichtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeihvorgaengeUebersichtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
