import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubAusleihenComponent } from './pub-ausleihen.component';

describe('PubAusleihenComponent', () => {
  let component: PubAusleihenComponent;
  let fixture: ComponentFixture<PubAusleihenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PubAusleihenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PubAusleihenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
