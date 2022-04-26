import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeihvorgangVerlaengernComponent } from './leihvorgang-verlaengern.component';

describe('LeihvorgangVerlaengernComponent', () => {
  let component: LeihvorgangVerlaengernComponent;
  let fixture: ComponentFixture<LeihvorgangVerlaengernComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeihvorgangVerlaengernComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeihvorgangVerlaengernComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
