import {Component, OnInit} from '@angular/core';
import {UserChatsService} from '../user-chats.service';
import {Message} from '../../model/message.model';
import {ActivatedRoute} from '@angular/router';
import {CookieService} from 'ngx-cookie-service';
import {interval, Subscription} from 'rxjs';
import {delay} from 'rxjs/operators';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  messages: Message[];
  message: Message;
  id: string;

  constructor(private userChatService: UserChatsService, private cookieService: CookieService, private route: ActivatedRoute) {
  }

  async ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
    });

    this.getMessages();
  }

  send(event) {
    event.preventDefault();
    this.message = new Message();
    this.message.text = event.target.querySelector('#text').value;
    this.message.chatId = Number(this.id);
    this.userChatService.addMessage(this.message, this.getToken());
    this.getMessages();
  }

  getMessages() {
    return this.userChatService.getChatMessages(this.id, this.getToken())
      .subscribe(data => this.messages = data);
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
