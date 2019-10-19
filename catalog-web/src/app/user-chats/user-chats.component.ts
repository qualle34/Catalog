import {Component, OnInit} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Chat} from '../model/chat.model';
import {UserChatsService} from './user-chats.service';

@Component({
  selector: 'app-user-chat',
  templateUrl: './user-chats.component.html',
  styleUrls: ['./user-chats.component.css']
})

export class UserChatsComponent implements OnInit {
  chats: Chat[];

  constructor(private userChatService: UserChatsService, private cookieService: CookieService) {
  }

  ngOnInit() {
    const token: string = this.cookieService.get('token');
    return this.userChatService.getChats(token)
      .subscribe(data => this.chats = data);
  }
}
