import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user.model';

@Injectable({
  providedIn: 'root'
})

export class UserProfileService {
  url = 'http://localhost:8080/my/profile';

  constructor(private http: HttpClient) {
  }

  getUser(token: string) {
    return this.http.get<User>(this.url, {headers: {'token': token}});
  }

  deleteUser(token: string) {
    return this.http.delete(this.url + '/delete', {headers: {'token': token}}).subscribe();
  }
}
