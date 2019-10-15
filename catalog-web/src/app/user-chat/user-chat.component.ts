import {Component, OnInit} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Message} from '../model/message.model';
import {Chat} from '../model/chat.model';
import {UserChatService} from './user-chat.service';

@Component({
  selector: 'app-user-chat',
  templateUrl: './user-chat.component.html',
  styleUrls: ['./user-chat.component.css']
})

export class UserChatComponent implements OnInit {
  messages: Message[];
  chats: Chat[];

  constructor(private userChatService: UserChatService, private cookieService: CookieService) {
  }

  ngOnInit() {
    const token: string = this.cookieService.get('token');
    return this.userChatService.getChats(token)
      .subscribe(data => this.chats = data);
  }
}
