import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubUebersichtComponent } from './pub-uebersicht.component';

describe('PubUebersichtComponent', () => {
  let component: PubUebersichtComponent;
  let fixture: ComponentFixture<PubUebersichtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PubUebersichtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PubUebersichtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
