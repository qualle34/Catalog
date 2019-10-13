import { TestBed } from '@angular/core/testing';

import { AdvertService } from './advert.service';

describe('AdvertService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdvertService = TestBed.get(AdvertService);
    expect(service).toBeTruthy();
  });
});
