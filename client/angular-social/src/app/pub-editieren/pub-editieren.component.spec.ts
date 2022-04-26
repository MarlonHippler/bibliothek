import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubEditierenComponent } from './pub-editieren.component';

describe('PubEditierenComponent', () => {
  let component: PubEditierenComponent;
  let fixture: ComponentFixture<PubEditierenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PubEditierenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PubEditierenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
