import {Component} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})

export class LogoutComponent {

  constructor(private cookieService: CookieService) {
  }

  logout() {
    this.cookieService.delete('token');
  }
}
