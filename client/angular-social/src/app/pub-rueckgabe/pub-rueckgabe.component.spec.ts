import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PubRueckgabeComponent } from './pub-rueckgabe.component';

describe('PubRueckgabeComponent', () => {
  let component: PubRueckgabeComponent;
  let fixture: ComponentFixture<PubRueckgabeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PubRueckgabeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PubRueckgabeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
