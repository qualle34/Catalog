import {Component, OnInit} from '@angular/core';
import {SimpleUser} from '../model/simple-user.model';
import {CookieService} from 'ngx-cookie-service';
import {UserProfileService} from './user-profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})

export class UserProfileComponent implements OnInit {
  user: SimpleUser;

  constructor(private userProfileService: UserProfileService, private cookieService: CookieService) {
  }

  ngOnInit() {
    const token: string = this.cookieService.get('token');
    return this.userProfileService.getUser(token)
      .subscribe(data => this.user = data);
  }
}
