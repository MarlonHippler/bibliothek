import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubAnlegenComponent } from './pub-anlegen.component';

describe('PubAnlegenComponent', () => {
  let component: PubAnlegenComponent;
  let fixture: ComponentFixture<PubAnlegenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PubAnlegenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PubAnlegenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
