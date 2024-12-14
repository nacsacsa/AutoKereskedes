import { TestBed } from '@angular/core/testing';

import { TermekService } from './jarmu.service';

describe('TermekService', () => {
  let service: TermekService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TermekService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
