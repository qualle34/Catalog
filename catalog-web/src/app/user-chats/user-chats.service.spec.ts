import { TestBed } from '@angular/core/testing';

import { UserChatsService } from './user-chats.service';

describe('UserChatService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserChatsService = TestBed.get(UserChatsService);
    expect(service).toBeTruthy();
  });
});
