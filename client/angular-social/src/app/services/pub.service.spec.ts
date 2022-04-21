import { TestBed } from '@angular/core/testing';

import { PubAnlegenService } from './pub-anlegen.service';

describe('PubAnlegenService', () => {
  let service: PubAnlegenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PubAnlegenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
