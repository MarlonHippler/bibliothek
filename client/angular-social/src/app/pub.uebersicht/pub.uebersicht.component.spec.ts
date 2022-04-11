import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pub.UebersichtComponent } from './pub.uebersicht.component';

describe('Pub.UebersichtComponent', () => {
  let component: Pub.UebersichtComponent;
  let fixture: ComponentFixture<Pub.UebersichtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pub.UebersichtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pub.UebersichtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
