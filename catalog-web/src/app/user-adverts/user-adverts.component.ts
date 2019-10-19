import {Component, OnInit} from '@angular/core';
import {SimpleAdvert} from '../model/simple-advert.model';
import {UserAdvertsService} from './user-adverts.service';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-user-adverts',
  templateUrl: './user-adverts.component.html',
  styleUrls: ['./user-adverts.component.css']
})
export class UserAdvertsComponent implements OnInit {
  adverts: SimpleAdvert[];

  constructor(private userAdvertsService: UserAdvertsService, private cookieService: CookieService) {
  }

  ngOnInit() {
    const token: string = this.cookieService.get('token');
    this.userAdvertsService.getUserAdverts(token).subscribe(data => this.adverts = data);
  }
}
