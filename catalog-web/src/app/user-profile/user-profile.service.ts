import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user.model';

@Injectable({
  providedIn: 'root'
})

export class UserProfileService {
  apiUrl = 'http://localhost:8080/my/profile';

  constructor(private http: HttpClient) {
  }

  getUser(token: string) {
    return this.http.get<User>(this.apiUrl, {headers: {'token': token}});
  }
}
