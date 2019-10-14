import {Injectable} from '@angular/core';
import {RegistrationUser} from '../model/registration-user.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  url = 'localhost:8080/registration/register';

  constructor(private http: HttpClient) {
  }

  register(user: RegistrationUser) {
    this.http.post(this.url, user);
  }
}
