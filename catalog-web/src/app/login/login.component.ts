import {Component, OnInit} from '@angular/core';
import {LoginService} from './login.service';
import {Auth} from '../model/auth.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  auth: Auth;
  login: string;
  password: string;

  constructor(private loginService: LoginService) {
  }

  authorize() {
    this.auth.login = this.login;
    this.auth.password = this.password;
    this.loginService.authorize(this.auth);
  }
}
