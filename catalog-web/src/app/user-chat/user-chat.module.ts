import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserChatRoutingModule} from './user-chat-routing.module';
import {UserChatComponent} from './user-chat.component';
import {UserChatService} from './user-chat.service';

@NgModule({
  declarations: [UserChatComponent],
  imports: [
    CommonModule,
    UserChatRoutingModule
  ],
  providers: [UserChatService]
})

export class UserChatModule {
}
