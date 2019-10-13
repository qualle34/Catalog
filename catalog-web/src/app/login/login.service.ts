import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Auth} from '../model/auth.model';

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  url = 'http://localhost:8080/login';

  constructor(private http: HttpClient) {
  }

  authorize(auth: object) {
    this.http.post(this.url, auth).toPromise().then(data => {
      console.log(data);
    });
  }
}
