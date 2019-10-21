import {Component, OnInit} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {UserChatsService} from './user-chats.service';
import {SimpleChat} from '../model/simple-chat.model';

@Component({
  selector: 'app-user-chat',
  templateUrl: './user-chats.component.html',
  styleUrls: ['./user-chats.component.css']
})

export class UserChatsComponent implements OnInit {
  chats: SimpleChat[];

  constructor(private userChatService: UserChatsService, private cookieService: CookieService) {
  }

  ngOnInit() {
    return this.userChatService.getChats(this.getToken())
      .subscribe(data => this.chats = data);
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
