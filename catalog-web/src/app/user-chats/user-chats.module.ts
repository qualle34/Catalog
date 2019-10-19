import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserChatsRoutingModule} from './user-chats-routing.module';
import {UserChatsComponent} from './user-chats.component';
import {UserChatsService} from './user-chats.service';

@NgModule({
  declarations: [UserChatsComponent],
  imports: [
    CommonModule,
    UserChatsRoutingModule
  ],
  providers: [UserChatsService]
})

export class UserChatsModule {
}
