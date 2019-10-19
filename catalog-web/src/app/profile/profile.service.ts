import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleUser} from '../model/simple-user.model';

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
}
