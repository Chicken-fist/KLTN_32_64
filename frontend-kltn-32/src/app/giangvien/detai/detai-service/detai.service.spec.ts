import { TestBed } from '@angular/core/testing';

import { DetaiService } from './detai.service';

describe('DetaiService', () => {
  let service: DetaiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetaiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
