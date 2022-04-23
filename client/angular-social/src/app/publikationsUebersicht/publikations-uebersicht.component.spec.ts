import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublikationsUebersichtComponent } from './publikations-uebersicht.component';

describe('MenuComponent', () => {
  let component: PublikationsUebersichtComponent;
  let fixture: ComponentFixture<PublikationsUebersichtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublikationsUebersichtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PublikationsUebersichtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
