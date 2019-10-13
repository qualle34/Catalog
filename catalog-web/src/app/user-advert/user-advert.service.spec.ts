import { TestBed } from '@angular/core/testing';

import { UserAdvertService } from './user-advert.service';

describe('UserAdvertService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserAdvertService = TestBed.get(UserAdvertService);
    expect(service).toBeTruthy();
  });
});
