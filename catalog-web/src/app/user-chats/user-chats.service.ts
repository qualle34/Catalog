import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Chat} from '../model/chat.model';
import {Message} from '../model/message.model';
import {SimpleChat} from '../model/simple-chat.model';

@Injectable({
  providedIn: 'root'
})

export class UserChatsService {
  url = 'http://localhost:8080/my';

  constructor(private http: HttpClient) {
  }

  getChats(token: string) {
    return this.http.get<SimpleChat[]>(this.url + '/chats', {headers: {'token': token}});
  }

  getChat(chatId: string, token: string) {
    return this.http.get<Chat>(this.url + '/chat?id=' + chatId, {headers: {'token': token}});
  }

  addMessage(message: Message, token: string) {
    this.http.post(this.url + '/chat/add', message, {headers: {'token': token}}).subscribe();
  }
}
