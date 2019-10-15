import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Auth} from '../model/auth.model';
import {Token} from '../model/token.model';

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  url = 'http://localhost:8080/login';

  constructor(private http: HttpClient) {
  }

  authorize(auth: Auth): Promise<Token> {
    return this.http.post<Token>(this.url, auth).toPromise();
  }
}
