import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleUser} from '../model/simple-user.model';
import {NewChat} from '../model/new-chat.model';
import {CookieService} from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})

export class ProfileService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  getUserProfile(id) {
    return this.http.get<SimpleUser>(this.url + '/profile?id=' + id);
  }

  newChat(newChat: NewChat, token: string) {
    this.http.post(this.url + '/profile/chat', newChat, {headers: {'token': token}}).subscribe();
  }
}
