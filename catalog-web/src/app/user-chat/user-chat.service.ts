import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Chat} from '../model/chat.model';
import {Message} from '../model/message.model';

@Injectable({
  providedIn: 'root'
})

export class UserChatService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  getChats(token: string) {
    return this.http.get<Chat[]>(this.url + '/chats', {headers: {'token': token}});
  }

  getChatMessages(chatId: number, token: string) {
    return this.http.get<Message[]>(this.url + '/chats/chat?id=' + chatId, {headers: {'token': token}});
  }
}
