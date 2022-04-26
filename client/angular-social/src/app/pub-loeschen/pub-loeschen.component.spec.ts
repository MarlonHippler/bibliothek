import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubLoeschenComponent } from './pub-loeschen.component';

describe('PubLoeschenComponent', () => {
  let component: PubLoeschenComponent;
  let fixture: ComponentFixture<PubLoeschenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PubLoeschenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PubLoeschenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
