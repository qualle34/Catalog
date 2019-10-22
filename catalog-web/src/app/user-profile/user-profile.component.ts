import {Component, OnInit} from '@angular/core';
import {SimpleUser} from '../model/simple-user.model';
import {CookieService} from 'ngx-cookie-service';
import {UserProfileService} from './user-profile.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})

export class UserProfileComponent implements OnInit {
  user: SimpleUser;

  constructor(private userProfileService: UserProfileService, private cookieService: CookieService, private router: Router) {
  }

  ngOnInit() {
    return this.userProfileService.getUser(this.getToken())
      .subscribe(data => this.user = data);
  }

  async delete() {
    this.userProfileService.deleteUser(this.getToken());
    this.cookieService.delete('token');
    await this.router.navigate(['/']);
  }

  getToken(): string {
    return this.cookieService.get('token');
  }
}
