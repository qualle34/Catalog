import { TestBed } from '@angular/core/testing';

import { UserAdvertsService } from './user-adverts.service';

describe('UserAdvertService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserAdvertsService = TestBed.get(UserAdvertsService);
    expect(service).toBeTruthy();
  });
});
