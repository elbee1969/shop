import { TestBed } from '@angular/core/testing';

import { SaisieService } from './saisie.service';

describe('SaisieService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SaisieService = TestBed.get(SaisieService);
    expect(service).toBeTruthy();
  });
});
