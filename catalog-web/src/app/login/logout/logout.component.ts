import {Component} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})

export class LogoutComponent {

  constructor(private cookieService: CookieService, private router: Router) {
  }

  async logout() {
    this.cookieService.delete('token');
    await this.router.navigate(['/']);
  }
}
