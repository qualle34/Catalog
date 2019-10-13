import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SimpleUser} from '../model/simple-user.model';

@Injectable({
  providedIn: 'root'
})

export class ProfileService {
  apiUrl = 'http://localhost:8080/profile?id=';

  constructor(private http: HttpClient) {
  }

  getUser(id) {
    return this.http.get<SimpleUser>(this.apiUrl + id);
  }
}
