import { TestBed } from '@angular/core/testing';

import { LeihvorgangService } from './leihvorgang.service';

describe('LeihvorgangService', () => {
  let service: LeihvorgangService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeihvorgangService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
