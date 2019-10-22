import {Component} from '@angular/core';
import {LoginService} from './login.service';
import {Auth} from '../model/auth.model';
import {CookieService} from 'ngx-cookie-service';
import {Token} from '../model/token.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  private auth: Auth;
  private token: Token;

  constructor(private loginService: LoginService, private cookieService: CookieService, private router: Router) {
  }

  async authorize(event) {
    event.preventDefault();
    this.auth = new Auth();
    this.auth.login = event.target.querySelector('#login').value;
    this.auth.password = event.target.querySelector('#password').value;
    this.token = await this.loginService.authorize(this.auth);

    if (this.token.token !== undefined) {
      this.cookieService.set('token', this.token.token, 0.0416);
      await this.router.navigate(['/']);
    } else {
      await this.router.navigate(['/error']);
    }
  }
}
